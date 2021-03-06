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

/**
 * . @author Salah eddine
 */
@Component
@Entity(name = "maladie")
@Table(name = "maladie")
public class Maladie {
  /**
   * . Maladie id field
   */
  @Id
  @Column(name = "maladie_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer maladieId;
  @Column(name = "libelle")
  private String libelle;
  

  /**
   * . Getter of maladieId
   * @return the maladieId
   */
  public final Integer getMaladieId() {
    return maladieId;
  }

  /**
   * . Setter of maladieId
   * @param maladieId
   *          the maladieId to set
   */
  public final void setMaladieId(final Integer maladieId) {
    this.maladieId = maladieId;
  }

  /**
   * . Getter libelle
   * @return the libelle
   */
  public final String getLibelle() {
    return libelle;
  }

  /**
   * . Setter libelle
   * @param libelle the libelle to set
   */
  public final void setLibelle(String libelle) {
    this.libelle = libelle;
  }
}
