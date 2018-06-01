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
@Entity(name = "user")
@Table(name = "user")
public class UserInfo {
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
  @Column(name = "username")
  private String username;
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
  @Column(name = "enabled")
  private byte enabled;

  /**
   * . Get the value of the field name
   * @return the name
   */
  public final String getName() {
    return name;
  }

  /**
   * . Change the value of name
   * @param name
   *          the name to set
   */
  public final void setName(final String name) {
    this.name = name;
  }

  /**
   * . Getter of role
   * @return the role
   */
  public final String getRole() {
    return role;
  }

  /**
   * . Setter of role
   * @param role the role to set
   */
  public final void setRole(String role) {
    this.role = role;
  }

  /**
   * . Getter password
   * @return the password
   */
  public final String getPassword() {
    return password;
  }

  /**
   * . Setter password
   * @param password the password to set
   */
  public final void setPassword(String password) {
    this.password = password;
  }

  public final Integer getUserId() {
    return userId;
  }

  public final void setUserId(Integer userId) {
    this.userId = userId;
  }

  public final String getUsername() {
    return username;
  }

  public final void setUsername(String username) {
    this.username = username;
  }

  public final byte getEnabled() {
    return enabled;
  }

  public final void setEnabled(byte enabled) {
    this.enabled = enabled;
  }
}
