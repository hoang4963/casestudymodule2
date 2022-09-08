package storage.servicemanager;

import controller.ServiceManager;
import model.service.Service;

import java.io.*;
import java.util.List;

public class RNWServiceManager {
    private final String LINK_SERVICEMANAGER = "C:\\Users\\Acer\\Desktop\\codegym\\Module2APJ\\casestudy\\untitled\\src\\storage\\servicemanager\\servicemanager.txt";

    private RNWServiceManager() {
    }

    private static RNWServiceManager instance;
    public RNWServiceManager getInstance() {
        if (instance == null) {
            instance = new RNWServiceManager();
        }
        return instance;
    }
    public List<Service> readData() {
        ServiceManager serviceManager = null;
        try {
            FileInputStream fis = new FileInputStream(LINK_SERVICEMANAGER);
            ObjectInputStream ois = new ObjectInputStream(fis);
            serviceManager = (ServiceManager) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (List<Service>) serviceManager;
    }
    public void writeData(List<Service> list) {
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
