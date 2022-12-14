package model.room;


import model.customer.Customer;
import model.service.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public abstract class Room implements MakeBill, Serializable {
    protected String name;
    protected LocalDate dayCheckIn;
    protected boolean isEmpty;
    private Room(){}
    protected double cost;
    protected ArrayList<Service> serviceList;
    protected ArrayList<Customer> customerList;

    protected Room(String name, double cost) {
        this.cost = cost;
        this.name = name;
        this.dayCheckIn = null;
        this.isEmpty = true;
    }

    public Room(String name, LocalDate dayCheckIn, double cost) {
        this.name = name;
        this.dayCheckIn = dayCheckIn;
        this.cost = cost;
        this.isEmpty = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayCheckIn() {
        return dayCheckIn;
    }

    public void setDayCheckIn(LocalDate dayCheckIn) {
        this.dayCheckIn = dayCheckIn;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", dayCheckIn=" + dayCheckIn +
                ", isEmpty=" + isEmpty +
                ", cost=" + cost +
                ", serviceList=" + serviceList +
                ", customerList=" + customerList +
                '}';}
    public void orderService(Service service){
        if (serviceList == null) serviceList = new ArrayList<>();
        serviceList.add(service);
    }

    public ArrayList<Service> getServiceList() {
        return serviceList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
