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
  private User user;
  @ManyToOne(cascade = CascadeType.ALL)
  private Maladie maladie;

  /**
   * @return the mesureId
   */
  public Integer getMesureId() {
    return mesureId;
  }

  /**
   * @param mesureId
   *          the mesureId to set
   */
  public void setMesureId(Integer mesureId) {
    this.mesureId = mesureId;
  }

  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * @param user
   *          the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * @return the maladie
   */
  public Maladie getMaladie() {
    return maladie;
  }

  /**
   * @param maladie
   *          the maladie to set
   */
  public void setMaladie(Maladie maladie) {
    this.maladie = maladie;
  }
}
