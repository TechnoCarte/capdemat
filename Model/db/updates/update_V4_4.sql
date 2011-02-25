update home_folder set is_temporary = true where id in (select home_folder_id from request where has_tied_home_folder is true);
alter table request drop column has_tied_home_folder;

alter table home_folder drop constraint FKDB87BBCE6AB1E860;
alter table home_folder add constraint FKDB87BBCEB7531222 foreign key (address_id) references address;

alter table individual drop constraint FKFD3DA2996AB1E860;
alter table individual add constraint FKFD3DA299B7531222 foreign key (address_id) references address;

alter table child alter column child_born rename to born;

alter table document_action rename agent_id to user_id;
alter table document_action rename label to type;
alter table document_action alter column type set not null;
update document_action set type = 'Creation' where type = 'CREATION_ACTION';
update document_action set type = 'StateChange' where type = 'STATE_CHANGE_ACTION';
update document_action set type = 'PageAddition' where type = 'PAGE_ADD_ACTION';
update document_action set type = 'PageEdition' where type = 'PAGE_EDIT_ACTION';
update document_action set type = 'PageDeletion' where type = 'PAGE_DELETE_ACTION';
update document_action set type = 'Merge' where type = 'MERGE_ACTION';

-- New data in external home folder's CSV export files
alter table external_individual add column email varchar(255);
alter table external_individual add column home_phone varchar(255);

create table request_external_action_complementary_data (
    id int8 not null,
    value bytea,
    key varchar(255) not null,
    primary key (id, key)
);

alter table request_external_action_complementary_data
    add constraint FKB088082C294C4979
    foreign key (id)
    references request_external_action;

create or replace function migrate_request_external_action_subkeys() returns void as $$
  declare
    r record;
  begin
    for r in select * from request_external_action where subkey = 'document' loop
      insert into request_external_action_complementary_data (id, key, value) values (
        r.id,
        'nature',
        '\\254\\355\\000\\005t\\000\\010document'
      );
    end loop;
    for r in select * from request_external_action where subkey = 'summary' loop
      insert into request_external_action_complementary_data (id, key, value) values (
        r.id,
        'nature',
        '\\254\\355\\000\\005t\\000\\007summary'
      );
    end loop;
    for r in select * from request_external_action where subkey = 'subject' loop
      insert into request_external_action_complementary_data (id, key, value) values (
        r.id,
        'individual',
        '\\254\\355\\000\\005t\\000\\007subject'
      );
    end loop;
    for r in select * from request_external_action where subkey = 'accountHolder' loop
      insert into request_external_action_complementary_data (id, key, value) values (
        r.id,
        'individual',
        '\\254\\355\\000\\005t\\000\\015accountHolder'
      );
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_request_external_action_subkeys();
drop function migrate_request_external_action_subkeys();

alter table request_external_action drop column subkey;

alter table child drop column note;
alter table child drop column badge_number;
alter table individual drop column version;
alter table individual drop column public_key;
alter table adult add column login varchar(255) unique;
alter table child add column sex varchar(8);

create or replace function migrate_individual_model() returns void as $$
  declare
    r record;
  begin
    for r in select * from individual loop
      update adult a set login = r.login where a.id = r.id;
      update child c set sex = r.sex where c.id = r.id;
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_individual_model();
drop function migrate_individual_model();

alter table individual drop column login;
alter table individual drop column sex;