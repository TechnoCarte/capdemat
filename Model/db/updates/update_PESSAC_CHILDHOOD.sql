/* Global School Registration Request */
create table global_school_registration_request (
    id int8 not null,
    label_ecole_derog varchar(255),
    id_ecole_secteur varchar(255),
    motif_autre_precision varchar(255),
    id_ecole_derog varchar(255),
    est_derogation bool,
    label_ecole_secteur varchar(255),
    informations_complementaires_derogation varchar(1024),
    est_restauration bool,
    est_periscolaire bool,
    primary key (id)
);

create table global_school_registration_request_motifs_derogation (
    global_school_registration_request_id int8 not null,
    motifs_derogation_id int8 not null,
    motifs_derogation_index int4 not null,
    primary key (global_school_registration_request_id, motifs_derogation_index)
);

create table global_school_registration_request_regime_alimentaire (
    global_school_registration_request_id int8 not null,
    regime_alimentaire_id int8 not null,
    regime_alimentaire_index int4 not null,
    primary key (global_school_registration_request_id, regime_alimentaire_index)
);

alter table global_school_registration_request_motifs_derogation 
        add constraint FK2AEE7D4011E068CC 
        foreign key (motifs_derogation_id) 
        references local_referential_data;

alter table global_school_registration_request_motifs_derogation 
    add constraint FK2AEE7D4085DE12C2 
    foreign key (global_school_registration_request_id) 
    references global_school_registration_request;

alter table global_school_registration_request_regime_alimentaire 
    add constraint FK261E5D0CA7322BAE 
    foreign key (regime_alimentaire_id) 
    references local_referential_data;

alter table global_school_registration_request_regime_alimentaire 
    add constraint FK261E5D0C85DE12C2 
    foreign key (global_school_registration_request_id) 
    references global_school_registration_request;

/* School Transport Registration Request */
create table school_transport_registration_request (
    id int8 not null,
    frere_ou_soeur_nom varchar(38),
    autorisation varchar(255),
    frere_ou_soeur_ecole varchar(255),
    frere_ou_soeur_prenom varchar(38),
    arret varchar(255),
    ligne varchar(255),
    frere_ou_soeur_classe varchar(255),
    primary key (id)
);

create table tiers_informations (
    id int8 not null,
    tiers_nom varchar(38),
    tiers_prenom varchar(38),
    tiers_telephone varchar(10),
    school_transport_registration_request_id int8,
    tiers_autorises_index int4,
    primary key (id)
);

alter table tiers_informations 
    add constraint FK58C18B7589395924 
    foreign key (school_transport_registration_request_id) 
    references school_transport_registration_request;

/* Renewal Perischool Activities Request */
create table renewal_perischool_activities_request (
    id int8 not null,
    acceptation_reglement_interieur bool,
    est_restauration bool,
    est_periscolaire bool,
    primary key (id)
);

create table renewal_perischool_activities_request_regime_alimentaire (
    renewal_perischool_activities_request_id int8 not null,
    regime_alimentaire_id int8 not null,
    regime_alimentaire_index int4 not null,
    primary key (renewal_perischool_activities_request_id, regime_alimentaire_index)
);

alter table renewal_perischool_activities_request_regime_alimentaire 
    add constraint FKD089D14FE35CAE2 
    foreign key (renewal_perischool_activities_request_id) 
    references renewal_perischool_activities_request;

alter table renewal_perischool_activities_request_regime_alimentaire 
    add constraint FKD089D14FA7322BAE 
    foreign key (regime_alimentaire_id) 
    references local_referential_data;