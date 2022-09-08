package model.room;


import controller.CalculateDate;
import model.customer.Customer;
import java.util.ArrayList;

public class GrandRoom extends Room {
    private final int CAPACITY = 4;
    ArrayList<Customer> customerList;
    public GrandRoom(String name, double cost) {
        super(name, cost);
        customerList = new ArrayList(CAPACITY);
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    @Override
    public double calculateBill() {
        return this.cost* CalculateDate.countDays(dayCheckIn.getDayOfMonth(),dayCheckIn.getMonthValue(),dayCheckIn.getYear());
    }
}