package model.room;

import model.customer.Customer;

import java.util.ArrayList;

public class StandardRoom extends Room {
    private final int CAPACITY = 2;
    ArrayList<Customer> customerList;
    protected StandardRoom(String name, double cost) {
        super(name, cost);
        customerList = new ArrayList(CAPACITY);
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
