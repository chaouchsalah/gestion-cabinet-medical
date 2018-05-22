create database cabinet_db;

use cabinet_db;

create table medecin (
    medecin_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(30),
    login varchar(30),
    password VARCHAR(256)
);
create TABLE patient (
    patient_id int PRIMARY KEY auto_increment,
    name varchar(30),
    login varchar(30),
    password VARCHAR(256)
);
create table consultation (
    consultation_id int PRIMARY key auto_increment,
    patient_id int,
    medecin_id int,
    FOREIGN KEY (medecin_id) REFERENCES medecin(medecin_id),
    FOREIGN key (patient_id) REFERENCES patient(patient_id)
);
create table maladie (
    maladie_id int PRIMARY KEY AUTO_INCREMENT,
    minimum int,
    maximum int
);
create table mesure (
    mesure_id int PRIMARY KEY auto_increment,
    patient_id int,
    maladie_id int,
    FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    FOREIGN KEY (maladie_id) REFERENCES maladie(maladie_id)
);
create TABLE consultation_maladie (
    id int PRIMARY key,
    consultation_id int,
    maladie_id int,
    FOREIGN KEY (consultation_id) REFERENCES consultation(consultation_id),
    FOREIGN KEY (maladie_id) REFERENCES maladie(maladie_id)
);