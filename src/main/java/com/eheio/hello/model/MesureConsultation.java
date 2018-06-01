package com.eheio.hello.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "mesure_consultation")
@Table(name = "mesure_consultation")
public class MesureConsultation {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "mesure_id")
  private Mesure mesure;

  //,fetch=FetchType.EAGER
  @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinColumn(name = "consultation_id")
  private Consultation consultation;
  
  /**
   * . Getter of id
   * @return the id
   */
  public int getId() {
    return id;
  }
  
  /**
   * . Setter of id
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }
  
  /**
   * . Getter consultation
   * @return the consultation
   */
  public Consultation getConsultation() {
    return consultation;
  }
  
  /**
   * . Setter consultation
   * @param consultation the consultation to set
   */
  public void setConsultation(Consultation consultation) {
    this.consultation = consultation;
  }

  /**
   * . Getter of mesure
   * @return the mesure
   */
  public Mesure getMesure() {
    return mesure;
  }

  /**
   * . Setter of mesure
   * @param mesure the mesure to set
   */
  public void setMesure(Mesure mesure) {
    this.mesure = mesure;
  }
}
