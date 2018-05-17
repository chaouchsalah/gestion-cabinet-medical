package com.eheio.hello.model;

import java.util.List;

import javax.persistence.*;

@Table(name="patient")
public class Patient extends Personne {
	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	@OneToMany
	@JoinColumn(name="patient_id")
	private List<Consultation> consultations;
	@OneToMany
	@JoinColumn(name="patient_id")
	private List<Mesure> mesures;
}
