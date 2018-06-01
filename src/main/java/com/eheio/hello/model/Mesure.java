package com.eheio.hello.model;

import org.springframework.stereotype.Component;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Component
@Entity(name = "mesure")
@Table(name = "mesure")
public class Mesure {
  @Id
  @Column(name = "mesure_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer mesureId;
  @Column(name = "libelle")
  private String libelle;
  @Column(name = "minimum")
  private Integer minimum;
  @Column(name = "maximum")
  private Integer maximum;
  
  /**
   * . Getter of mesureId
   * @return the mesureId
   */
  public final Integer getMesureId() {
    return mesureId;
  }

  /**
   * . Setter of mesureId
   * @param mesureId
   *          the mesureId to set
   */
  public final void setMesureId(Integer mesureId) {
    this.mesureId = mesureId;
  }

  /**
   * . Getter of minimum
   * @return the minimum
   */
  public final Integer getMinimum() {
    return minimum;
  }

  /**
   * . Setter of minimum
   * @param minimum the minimum to set
   */
  public final void setMinimum(Integer minimum) {
    this.minimum = minimum;
  }

  /**
   * . Getter of maximum
   * @return the maximum
   */
  public final Integer getMaximum() {
    return maximum;
  }

  /**
   * . Setter of maximum
   * @param maximum the maximum to set
   */
  public final void setMaximum(Integer maximum) {
    this.maximum = maximum;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }
}
