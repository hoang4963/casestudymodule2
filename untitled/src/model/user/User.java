package model.user;

import controller.UserManager;
import model.customer.Customer;

public class User {
    private static final String ACCOUNT = "admin";
    private static final int PASSWORD = 1703;
    private long passwordCustomer;
    private User(){}
    private User(long passwordCustomer){
        this.passwordCustomer = passwordCustomer;
    }
    static CheckCustomer checkCustomer;
    public void createUser(Customer customer){
        if (checkCustomer.checkCumtomer(customer))
            UserManager.addUser(new User(customer.getIdentityCard()));
    }

    public static String getACCOUNT() {
        return ACCOUNT;
    }

    public static int getPASSWORD() {
        return PASSWORD;
    }

    public long getPasswordCustomer() {
        return passwordCustomer;
    }

    public void setPasswordCustomer(long passwordCustomer) {
        this.passwordCustomer = passwordCustomer;
    }
}
