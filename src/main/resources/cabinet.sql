create database cabinet_db;

use cabinet_db;

create table user (
    user_id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(30),
    login varchar(30),
    password VARCHAR(256),
    role varchar(15)
);
create table consultation (
    consultation_id int PRIMARY key auto_increment,
    patient_id int,
    medecin_id int,
    FOREIGN KEY (patient_id) REFERENCES user(user_id),
    FOREIGN KEY (medecin_id) REFERENCES user(user_id)
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
    FOREIGN KEY (patient_id) REFERENCES user(user_id),
    FOREIGN KEY (maladie_id) REFERENCES maladie(maladie_id)
);
create TABLE consultation_maladie (
    id int PRIMARY key,
    consultation_id int,
    maladie_id int,
    FOREIGN KEY (consultation_id) REFERENCES consultation(consultation_id),
    FOREIGN KEY (maladie_id) REFERENCES maladie(maladie_id)
);