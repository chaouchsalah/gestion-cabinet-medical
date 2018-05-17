package com.eheio.hello.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Mesure {
	@Id
	@Column(name = "mesure_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mesureId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Patient patient;
	@ManyToOne(cascade = CascadeType.ALL)
	private Maladie maladie;
}
