package storage.customermanager;

import model.customer.Customer;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RNWCustomerManager {
    private static final String LINK_CUSTOMERMANAGER = "C:\\Users\\Acer\\Desktop\\codegym\\Module2APJ\\casestudy\\untitled\\src\\storage\\customermanager\\customermanager.txt";
    private static RNWCustomerManager instance;
    public RNWCustomerManager getInstance(){
        if (instance == null){
            instance = new RNWCustomerManager();
        }
        return instance;
    }
    private RNWCustomerManager() {
        super();
    }

    public static ArrayList<Customer> readData() {
        ArrayList<Customer> arrayList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(LINK_CUSTOMERMANAGER);
            ObjectInputStream ois = new ObjectInputStream(fis);
            arrayList = (ArrayList<Customer>) ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public static void writeData(List<Customer> list) {
        try {
            FileOutputStream fis = new FileOutputStream(LINK_CUSTOMERMANAGER);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(list);
            oos.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
