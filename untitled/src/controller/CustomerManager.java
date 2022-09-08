package controller;

import model.customer.Customer;
import storage.customermanager.RNWCustomerManager;

import java.io.Serializable;
import java.util.List;

public class CustomerManager implements Serializable {
    static List<Customer> customerList = RNWCustomerManager.readData();

    public static void addCumtomer(Customer customer){
        customerList.add(customer);
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }
}

