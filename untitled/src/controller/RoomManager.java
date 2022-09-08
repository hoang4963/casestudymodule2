package controller;


import model.room.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private static final int CAPACITY = 5;
     static List<Room> roomList = new ArrayList<>(CAPACITY);
    private static RoomManager instance;
    RoomManager(){}
    public RoomManager getInstance(){
        if (instance == null){
            instance = new RoomManager();
        }
        return instance;
    }
    public void addRoom(Room room){
        roomList.add(room);
    }
    public static ArrayList<Room> getListRoom(){
        return (ArrayList<Room>) roomList;
    }
}
