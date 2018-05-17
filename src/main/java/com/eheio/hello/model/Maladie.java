package com.eheio.hello.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Maladie {
	@Id
	@Column(name = "maladie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maladieId;
	@Column(name = "minimum")
	private Integer minimum;
	@Column(name = "maximum")
	private Integer maximum;
	@OneToMany
	@JoinColumn(name="maladie_id")
	private List<Mesure> mesures;
}
