package com.idfinance.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Proposal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String request;

  private Double bid;

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  private Date date;

  @Column(name="state")
  private String state = "waiting";

  public Proposal(){

  }

  public Proposal(String request, Double bid, Date date) {
    this.request = request;
    this.bid = bid;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public Double getBid() {
    return bid;
  }

  public void setBid(Double bid) {
    this.bid = bid;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
