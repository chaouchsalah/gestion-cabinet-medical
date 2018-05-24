package com.eheio.hello.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * . @author Salah eddine
 */
@Table(name = "Consultation")
public class Consultation {
  /**
   * . The id of consultation
   */
  @Id
  @Column(name = "consultation_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer consultationId;
  /**
   * . The patient whom this consultation concerns
   */
  @ManyToOne(cascade = CascadeType.ALL)
  private User patient;
  /**
   * . The medecin whom this consultation concerns
   */
  @ManyToOne(cascade = CascadeType.ALL)
  private User medecin;

  /**
   * . Get the consultation id field
   * @return the consultationId
   */
  public Integer getConsultationId() {
    return consultationId;
  }

  /**
   * . Change the consultation id
   * @param consultationId
   *          the consultationId to set
   */
  public void setConsultationId(final Integer consultationId) {
    this.consultationId = consultationId;
  }

  /**
   * . Get the patient field
   * @return the patient
   */
  public User getPatient() {
    return patient;
  }

  /**
   * . Change the patient
   * @param patient
   *          the patient to set
   */
  public void setPatient(final User patient) {
    this.patient = patient;
  }

  /**
   * . Get the medecin field
   * @return the medecin
   */
  public User getMedecin() {
    return medecin;
  }

  /**
   * . Change the medecin
   * @param medecin
   *          the medecin to set
   */
  public void setMedecin(final User medecin) {
    this.medecin = medecin;
  }
}
