package com.eheio.hello.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@JsonAutoDetect
@Component
@Entity(name = "mesure_patient")
@Table(name = "mesure_patient")
public class MesurePatient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "valeur")
    private int valeur;
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "mesure_id")
    private Mesure mesure;

    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private UserInfo patient;
    public MesurePatient(){

    }
    public MesurePatient(int id,int valeur,Mesure mesure,UserInfo patient){
        this.id = id;
        this.valeur = valeur;
        this.mesure = mesure;
        this.patient = patient;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mesure getMesure() {
        return mesure;
    }

    public void setMesure(Mesure mesure) {
        this.mesure = mesure;
    }

    public UserInfo getPatient() {
        return patient;
    }

    public void setPatient(UserInfo patient) {
        this.patient = patient;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
