package model.room;

import model.customer.Customer;

import java.util.ArrayList;

public class SuiteRoom {
    private final int CAPACITY = 2;
    ArrayList<Customer> customerList;
    protected SuiteRoom(String name, double cost) {
        super(name, cost);
        customerList = new ArrayList(CAPACITY);
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
