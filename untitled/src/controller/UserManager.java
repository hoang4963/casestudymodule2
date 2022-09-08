package controller;

import model.user.User;

import java.util.List;

public class UserManager {
    static List<User> userList;
    private static UserManager instance;
    private void CustomerManager(){}
    public UserManager getInstance(){
        if (instance == null){
            instance = new UserManager();
        }
        return instance;
    }
    public static void addUser(User user){
        userList.add(user);
    }
}
