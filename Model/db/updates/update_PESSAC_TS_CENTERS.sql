/* Holiday Camp Registration Request */
create table holiday_camp_registration_request (
    id int8 not null,
    label_centre_sejours varchar(255),
    id_centre_sejours varchar(255),
    acceptation_reglement_interieur bool,
    est_accompte bool,
    primary key (id)
);

/* Leisure Center Registration Request */
create table leisure_center_registration_request (
    id int8 not null,
    acceptation_reglement_interieur bool,
    est_derogation bool,
    id_centre_loisirs varchar(255),
    est_transport bool,
    arret varchar(255),
    ligne varchar(255),
    label_centre_loisirs varchar(255),
    primary key (id)
);

create table leisure_center_registration_request_mode_accueil (
    leisure_center_registration_request_id int8 not null,
    mode_accueil_id int8 not null,
    mode_accueil_index int4 not null,
    primary key (leisure_center_registration_request_id, mode_accueil_index)
);

create table leisure_center_registration_request_motifs_derogation (
    leisure_center_registration_request_id int8 not null,
    motifs_derogation_id int8 not null,
    motifs_derogation_index int4 not null,
    primary key (leisure_center_registration_request_id, motifs_derogation_index)
);

alter table leisure_center_registration_request_mode_accueil 
    add constraint FKA9077FE9D930190 
    foreign key (leisure_center_registration_request_id) 
    references leisure_center_registration_request;

alter table leisure_center_registration_request_mode_accueil 
    add constraint FKA9077FE835B7D7B 
    foreign key (mode_accueil_id) 
    references local_referential_data;

alter table leisure_center_registration_request_motifs_derogation 
    add constraint FKE41AD04111E068CC 
    foreign key (motifs_derogation_id) 
     references local_referential_data;

alter table leisure_center_registration_request_motifs_derogation 
    add constraint FKE41AD0419D930190 
    foreign key (leisure_center_registration_request_id) 
    references leisure_center_registration_request;