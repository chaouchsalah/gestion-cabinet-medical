package com.eheio.hello.model;

import java.util.List;

import javax.persistence.*;

@Table(name = "Medecin")
public class Medecin extends Personne {
	@Id
	@Column(name = "medecin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer medecinId;
	@OneToMany
	@JoinColumn(name="medecin_id")
	private List<Consultation> consultations;
}
