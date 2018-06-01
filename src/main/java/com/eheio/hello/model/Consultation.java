package com.eheio.hello.model;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * . @author Salah eddine
 */
@Component
@Entity(name = "consultation")
@Table(name = "consultation")
public class Consultation {
  /**
   * . The id of consultation
   */
  @Id
  @Column(name = "consultation_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer consultationId;
  @Column(name = "observation")
  private String observation;
  @Column(name = "date_consultation")
  private Date dateConsultation;
  /**
   * . The patient whom this consultation concerns
   */
  @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinColumn(name = "patient_id")
  private UserInfo patient;
  /**
   * . The medecin whom this consultation concerns
   */
  @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinColumn(name = "medecin_id")
  private UserInfo medecin;
  /**
   * . The maladie which this consultation concerns
   */
  @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinColumn(name = "maladie_id")
  private Maladie maladie;

  /**
   * . Get the consultation id field
   * @return the consultationId
   */
  public final Integer getConsultationId() {
    return consultationId;
  }

  /**
   * . Change the consultation id
   * @param consultationId
   *          the consultationId to set
   */
  public final void setConsultationId(final Integer consultationId) {
    this.consultationId = consultationId;
  }

  /**
   * . Get the patient field
   * @return the patient
   */
  public final UserInfo getPatient() {
    return patient;
  }

  /**
   * . Change the patient
   * @param patient
   *          the patient to set
   */
  public final void setPatient(final UserInfo patient) {
    this.patient = patient;
  }

  /**
   * . Get the medecin field
   * @return the medecin
   */
  public final UserInfo getMedecin() {
    return medecin;
  }

  /**
   * . Change the medecin
   * @param medecin
   *          the medecin to set
   */
  public final void setMedecin(final UserInfo medecin) {
    this.medecin = medecin;
  }

  /**
   * . Getter of maladie
   * @return the maladie
   */
  public final Maladie getMaladie() {
    return maladie;
  }

  /**
   * . Setter of maladie
   * @param maladie the maladie to set
   */
  public final void setMaladie(Maladie maladie) {
    this.maladie = maladie;
  }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }
}
