package com.eheio.hello.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * . @author Salah eddine
 */
public class Maladie {
  /**
   * . Maladie id field
   */
  @Id
  @Column(name = "maladie_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer maladieId;
  /**
   * . Minimum field
   */
  @Column(name = "minimum")
  private Integer minimum;
  /**
   * . Maximum field
   */
  @Column(name = "maximum")
  private Integer maximum;
  /**
   * . List of mesures
   */
  @OneToMany
  @JoinColumn(name = "maladie_id")
  private List<Mesure> mesures;
  
  /**
   * . Constructor
   * @param maladieId is the id of maladie
   * @param minimum is the minimum
   * @param maximum is the maximum
   * @param mesures is the list of mesures
   */
  public Maladie(final Integer maladieId, final Integer minimum,
      final Integer maximum, final List<Mesure> mesures) {
    super();
    this.maladieId = maladieId;
    this.minimum = minimum;
    this.maximum = maximum;
    this.mesures = mesures;
  }

  /**
   * . Getter of maladieId
   * @return the maladieId
   */
  public Integer getMaladieId() {
    return maladieId;
  }

  /**
   * . Setter of maladieId
   * @param maladieId
   *          the maladieId to set
   */
  public void setMaladieId(final Integer maladieId) {
    this.maladieId = maladieId;
  }

  /**
   * . Getter of minimum
   * @return the minimum
   */
  public Integer getMinimum() {
    return minimum;
  }

  /**
   * . Setter of minimum
   * @param minimum
   *          the minimum to set
   */
  public void setMinimum(final Integer minimum) {
    this.minimum = minimum;
  }

  /**
   * . Getter of maximum
   * @return the maximum
   */
  public Integer getMaximum() {
    return maximum;
  }

  /**
   * . Setter of maximum
   * @param maximum
   *          the maximum to set
   */
  public void setMaximum(final Integer maximum) {
    this.maximum = maximum;
  }

  /**
   * . Getter of list of mesures
   * @return the mesures
   */
  public List<Mesure> getMesures() {
    return mesures;
  }

  /**
   * . Setter of list of mesures
   * @param mesures
   *          the mesures to set
   */
  public void setMesures(final List<Mesure> mesures) {
    this.mesures = mesures;
  }
}
