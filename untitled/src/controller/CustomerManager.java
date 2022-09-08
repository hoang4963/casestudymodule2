package controller;

import model.customer.Customer;

import java.util.List;

public class CustomerManager {
    List<Customer> customerList;
    private static CustomerManager instance;
    CustomerManager(){}
    public CustomerManager getInstance(){
        if (instance == null){
            instance = new CustomerManager();
        }
        return instance;
    }
}
