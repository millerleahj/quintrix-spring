package com.quintrix.jfs.quintrixspring.models;

import java.util.List;
import com.quintrix.jfs.quintrixspring.models.agent.Agents;

public class GetCarResponse {

  private String availableWarranty;

  List<ClientCar> availableCarList;

  List<Agents> agentsList;

  public String getAvailableWarranty() {
    return availableWarranty;
  }



  public void setAvailableWarranty(String availableWarranty) {
    this.availableWarranty = availableWarranty;
  }



  public List<ClientCar> getAvailableCarList() {
    return availableCarList;
  }



  public void setAvailableCarList(List<ClientCar> availableCarList) {
    this.availableCarList = availableCarList;
  }



  public List<Agents> getAgentsList() {
    return agentsList;
  }



  public void setAgentsList(List<Agents> agentsList) {
    this.agentsList = agentsList;
  }



  private void Notes() {

    /*
     * private String make;
     * 
     * private String model;
     * 
     * private Integer year;
     * 
     * public String getAvailableWarranty() { return availableWarranty; }
     * 
     * public void setAvailableWarranty(String availableWarranty) { this.availableWarranty =
     * availableWarranty; }
     * 
     * public String getMake() { return make; }
     * 
     * public void setMake(String make) { this.make = make; }
     * 
     * public String getModel() { return model; }
     * 
     * public void setModel(String model) { this.model = model; }
     * 
     * public Integer getYear() { return year; }
     * 
     * public void setYear(Integer year) { this.year = year; }
     */

  }
}
