package storage.servicemanager;

import controller.ServiceManager;
import model.customer.Customer;
import model.service.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RNWServiceManager {
    private static final String LINK_SERVICEMANAGER = "C:\\Users\\Acer\\Desktop\\codegym\\Module2APJ\\casestudy\\untitled\\src\\storage\\servicemanager\\servicemanager.txt";

    private RNWServiceManager() {
    }

    private static RNWServiceManager instance;
    public RNWServiceManager getInstance() {
        if (instance == null) {
            instance = new RNWServiceManager();
        }
        return instance;
    }
    public static List<Service> readData() {
        ServiceManager serviceManager = null;
        try {
            FileInputStream fis = new FileInputStream(LINK_SERVICEMANAGER);
            ObjectInputStream ois = new ObjectInputStream(fis);
            serviceManager = (ServiceManager) ois.readObject();
            if (ois.readObject() == null){
                writeData(new ArrayList<Service>());
                readData();
            }
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (List<Service>) serviceManager;
    }
    public static void writeData(List<Service> list) {
        try {
            FileOutputStream fis = new FileOutputStream(LINK_SERVICEMANAGER);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(list);
            oos.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
