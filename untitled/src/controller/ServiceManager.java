package controller;

import model.service.Service;
import storage.servicemanager.RNWServiceManager;

import java.util.List;

public class ServiceManager {
    static List<Service> serviceList = RNWServiceManager.readData();

    private ServiceManager(){}
    public static void addService(Service user){
        serviceList.add(user);
    }
    public static List<Service> getServiceList(){
        return serviceList;
    }
}
