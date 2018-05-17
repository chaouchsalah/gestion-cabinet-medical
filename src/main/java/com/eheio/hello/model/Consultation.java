package com.eheio.hello.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "Consultation")
public class Consultation {
	@Id
	@Column(name = "consultation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer consultationId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Patient patient;
	@ManyToOne(cascade = CascadeType.ALL)
	private Medecin medecin;
}
