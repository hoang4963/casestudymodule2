package controller;


import model.room.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private static final int CAPACITY = 5;
     static List<Room> roomList = new ArrayList<>(CAPACITY);
    private RoomManager(){}
    public void addRoom(Room room){
        roomList.add(room);
    }
    public static ArrayList<Room> getListRoom(){
        return (ArrayList<Room>) roomList;
    }
    public static int getSize(){
        return roomList.size();
    }
}
