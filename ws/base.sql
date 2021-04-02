create database stm;

alter database stm owner to postgres;

\c stm

create table operateur
(
    idOperateur int primary key,
    nomOperateur varchar(10),
    prefixeOperateur varchar(3)
);

insert into operateur values (1,'Ntsika','035');

create table offre
(
    idOffre int primary key,
    nomOffre varchar(15) unique not null,
    prixOffre decimal(8,2) not null check(prixOffre >= 0),
    dureeOffre decimal(5,2) not null check(dureeOffre >=0),
    uniteDuree varchar(10) not null check(uniteDuree = 'min' or uniteDuree = 'hrs' or uniteDuree = 'jrs' or uniteDuree = 'mois'),
    status timestamp,
    priorite int
);

create table DetailOffre
(
    idOffre int not null,
    type varchar(15),
    valeur decimal(8,2) not null check(valeur >= 0),
    unite varchar(10) not null check(unite = 'sec' or unite = 'min' or unite = 'hrs' or unite = 'mo' or unite = 'go' or unite = 'sms'),
    foreign key (idOffre) references offre(idOffre)
);

create table ValiditeOffre
(
    idOffre int,
    h_debut int check(h_debut >= 0 and h_debut <= 24),
    h_fin int check(h_fin >= 0 and h_fin <= 24),
    foreign key (idOffre) references offre(idOffre)
);

create table Type
(
    name varchar(20) ,
    

);


insert into offre values(1,'offreMora',500,1,'jrs','2021-03-30',10);

insert into offre values(2,'OffreTest',2000,24,'hrs','2021-03-30',10);

insert into DetailOffre (2,'internet',20,'mo'),
                        (2,'appel',120,'sec'),
                        (2,'message',20,'sms');

insert into DetailOffre values( 1,'appel',500,'sec' )



insert into validiteoffre values (1,6,21);