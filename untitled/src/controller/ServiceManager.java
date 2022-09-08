package controller;

import model.service.Service;
import model.user.User;

import java.util.List;

public class ServiceManager {
    static List<Service> serviceList;
    private static ServiceManager instance;
    private void ServiceManager(){}
    public ServiceManager getInstance(){
        if (instance == null){
            instance = new ServiceManager();
        }
        return instance;
    }
    public static void addService(Service user){
        serviceList.add(user);
    }
}
