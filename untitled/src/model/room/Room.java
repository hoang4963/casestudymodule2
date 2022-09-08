package model.room;



import model.service.Service;

import java.time.LocalDate;
import java.util.List;


public abstract class Room implements Bill {
    protected String name;
    protected LocalDate dayCheckIn;
    protected boolean isEmpty;
    private Room(){}
    protected double cost;
    protected List<Service> serviceList;

    protected Room(String name, double cost) {
        this.cost = cost;
        this.name = name;
        this.dayCheckIn = null;
        this.isEmpty = true;
        serviceList = null;
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
                '}';
    }
    public void orderService(Service service){
        serviceList.add(service);
    }

    public List<Service> getServiceList() {
        return serviceList;
    }
}
