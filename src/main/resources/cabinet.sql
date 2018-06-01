drop DATABASE cabinet_db;
create database cabinet_db;

use cabinet_db;

create table user (
    user_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(30),
    login varchar(30),
    password VARCHAR(30),
    role varchar(15)
);
create table maladie (
    maladie_id int PRIMARY KEY AUTO_INCREMENT,
    libelle varchar(20)
);
create table consultation (
    consultation_id int PRIMARY key AUTO_INCREMENT,
    patient_id int,
    medecin_id int,
    maladie_id int,
    FOREIGN KEY (patient_id) REFERENCES user(user_id),
    FOREIGN KEY (medecin_id) REFERENCES user(user_id),
    FOREIGN KEY (maladie_id) REFERENCES maladie(maladie_id)
);
create table mesure (
    mesure_id int PRIMARY KEY AUTO_INCREMENT,
    minimum int,
    maximum int
);
create table mesure_consultation (
    id int PRIMARY KEY AUTO_INCREMENT,
    mesure_id int,
    consultation_id int,
    valeur int,
    FOREIGN KEY (consultation_id) REFERENCES consultation(consultation_id),
    FOREIGN KEY (mesure_id) REFERENCES mesure(mesure_id)
);

create table mesure_patient (
    id int PRIMARY KEY AUTO_INCREMENT,
    mesure_id int,
    patient_id int,
    valeur int,
    FOREIGN KEY (mesure_id) REFERENCES mesure(mesure_id),
    FOREIGN KEY (patient_id) REFERENCES user(user_id)
)