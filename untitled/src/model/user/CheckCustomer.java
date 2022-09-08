package model.user;

import model.customer.Customer;

public class CheckCustomer {
    public CheckCustomer(){}
    public boolean checkCumtomer(Customer customer){
        return customer.getRoom() != null;
    }
}
