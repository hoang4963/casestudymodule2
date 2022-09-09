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
    public static void addBillService(int chose, long cmnd){
        int index = -1;
        for (int i = 0; i < CustomerManager.getCustomerList().size(); i++) {
            if (cmnd == CustomerManager.getCustomerList().get(i).getIdentityCard()){
                index = i;
                break;
            }
        }
        CustomerManager.getCustomerList().get(index).getRoom().orderService(ServiceManager.getServiceList().get(chose));
    }
    public static int findCustomerByCmnd(long cmnd){
        int index = -1;
        for (int i = 0; i < CustomerManager.getCustomerList().size(); i++) {
            if (CustomerManager.getCustomerList().get(i).getIdentityCard() == cmnd) {
                index = i;
                break;
            }
        }
        return index;
    }
}


