package com.eheio.hello.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * . @author Salah eddine
 */
@Entity
@Table(name = "consultation")
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
  private UserInfo patient;
  /**
   * . The medecin whom this consultation concerns
   */
  @ManyToOne(cascade = CascadeType.ALL)
  private UserInfo medecin;
  /**
   * . The maladie whom this consultation concerns
   */
  @ManyToOne(cascade = CascadeType.ALL)
  private Maladie maladie;
  @OneToMany
  @JoinColumn(name = "consultation_id")
  private List<MesureConsultation> mesureConsultations;

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
  public UserInfo getPatient() {
    return patient;
  }

  /**
   * . Change the patient
   * @param patient
   *          the patient to set
   */
  public void setPatient(final UserInfo patient) {
    this.patient = patient;
  }

  /**
   * . Get the medecin field
   * @return the medecin
   */
  public UserInfo getMedecin() {
    return medecin;
  }

  /**
   * . Change the medecin
   * @param medecin
   *          the medecin to set
   */
  public void setMedecin(final UserInfo medecin) {
    this.medecin = medecin;
  }

  /**
   * . Getter of maladie
   * @return the maladie
   */
  public Maladie getMaladie() {
    return maladie;
  }

  /**
   * . Setter of maladie
   * @param maladie the maladie to set
   */
  public void setMaladie(Maladie maladie) {
    this.maladie = maladie;
  }

  /**
   * . Getter mesure consultation
   * @return the mesureConsultations
   */
  public List<MesureConsultation> getMesureConsultations() {
    return mesureConsultations;
  }

  /**
   * . Setter mesure consultation
   * @param mesureConsultations the mesureConsultations to set
   */
  public void setMesureConsultations(List<MesureConsultation> mesureConsultations) {
    this.mesureConsultations = mesureConsultations;
  }
}
