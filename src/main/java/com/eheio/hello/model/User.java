package com.eheio.hello.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * . @author Salah eddine
 */
@MappedSuperclass
public class User {
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;
  /**
   * . The name of the user
   */
  @Column(name = "name")
  private String name;
  /**
   * . The login of the user
   */
  @Column(name = "login")
  private String login;
  /**
   * . The password of the user
   */
  @Column(name = "password")
  private String password;
  /**
   * . The role of the user
   */
  @Column(name = "role")
  private String role;
  @OneToMany
  @JoinColumn(name = "user_id")
  private List<Consultation> consultations;
  
  /**
   * . Constructor for spring security
   * @param login login
   * @param password password
   * @param role role
   */
  public User(String login, String password, String role) {
    super();
    this.login = login;
    this.password = password;
    this.role = role;
  }

  /**
   * . Get the value of the field name
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * . Change the value of name
   * @param name
   *          the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * . Get the value of the login field
   * @return the login
   */
  public String getLogin() {
    return login;
  }

  /**
   * . Change the value of login
   * @param login the login to set
   */
  public void setLogin(final String login) {
    this.login = login;
  }

  /**
   * . Getter of role
   * @return the role
   */
  public String getRole() {
    return role;
  }

  /**
   * . Setter of role
   * @param role the role to set
   */
  public void setRole(String role) {
    this.role = role;
  }

  /**
   * . Getter password
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * . Setter password
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
