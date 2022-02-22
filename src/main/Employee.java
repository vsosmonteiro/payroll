package main;

import java.time.LocalDate;

public class Employee {
   protected String name;
   protected String address;
   protected int type;
   protected int id;
   protected int fired;
   protected int sindicate;
   protected Double servicetax;
   protected LocalDate lastPayday;



  public  Employee( String name,String address,int type,int id,int fired,int sindicate){
    this.name= name;
    this.address=address;
    this.type=type;
    this.id=id;
    this.fired=fired;
    this.sindicate=sindicate;
    this.servicetax=0.0;
  }

    public void setSindicate(int sindicate) {
        this.sindicate = sindicate;
    }

    public void setFired(int fired) {
        this.fired = fired;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setServicetax(Double servicetax) {
        this.servicetax = this.servicetax+servicetax;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getSindicate() {
        return sindicate;
    }

    public int getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getFired() {
        return fired;
    }

    public Double getServicetax() {
        return servicetax;
    }

    public LocalDate getLastPayday() {
        return lastPayday;
    }

    public void setLastPayday(LocalDate lastPayday) {
        this.lastPayday = lastPayday;
    }

    @Override
    public String toString() {
        return "main.Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", fired=" + fired +
                '}';
    }
}

