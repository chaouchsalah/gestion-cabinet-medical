package com.eheio.hello.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "mesure_patient")
@Table(name = "mesure_patient")
public class MesurePatient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mesure_id")
    private Mesure mesure;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserInfo patient;
}
