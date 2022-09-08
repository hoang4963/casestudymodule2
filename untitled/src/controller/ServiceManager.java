package controller;

import model.service.Service;
import storage.servicemanager.RNWServiceManager;

import java.io.Serializable;
import java.util.List;

public class ServiceManager implements Serializable {
    static List<Service> serviceList = RNWServiceManager.readData();

    private ServiceManager(){}
    public static void addService(Service user){
        serviceList.add(user);
    }
    public static List<Service> getServiceList(){
        return serviceList;
    }
}
