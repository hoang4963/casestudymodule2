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
    public static void showService(){
        for (int i = 0; i < ServiceManager.getServiceList().size(); i++) {
            System.out.println((i+1) + ". " + ServiceManager.getServiceList().get(i).getName());
        }
    }
    public static void deleteService(int index){
        serviceList.remove(index);
    }
}
