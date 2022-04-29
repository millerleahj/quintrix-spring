package com.quintrix.jfs.quintrixspring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// @Table(name = "Employee")
public class Employee {

  @Id
  // primary key
  // @Column(name = "ID")
  private Integer id;
  private String first;
  private String last;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return first;
  }

  public void setFirstName(String first) {
    this.first = first;
  }

  public String getLastName() {
    return last;
  }

  public void setLastName(String last) {
    this.last = last;
  }



}
