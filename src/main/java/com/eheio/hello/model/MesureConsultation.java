package com.eheio.hello.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mesure_consultation")
public class MesureConsultation {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "valeur")
  private int valeur;

  @ManyToOne(cascade = CascadeType.ALL)
  private Mesure mesure;

  @ManyToOne(cascade = CascadeType.ALL)
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

  public int getValeur() {
    return valeur;
  }

  public void setValeur(int valeur) {
    this.valeur = valeur;
  }
}
