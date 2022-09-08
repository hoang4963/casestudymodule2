package controller;


import model.room.Room;
import storage.roommanager.RNWRoomManager;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private static final int CAPACITY = 5;
     static List<Room> roomList = RNWRoomManager.readData();
    private RoomManager(){}
    private static boolean checkfull(){
        return roomList.size() <= CAPACITY;
    }
    public static void addRoom(Room room){
        if (checkfull())
        roomList.add(room);
        else System.out.println("Full");
    }
    public static ArrayList<Room> getListRoom(){
        return (ArrayList<Room>) roomList;
    }
    public static int getSize(){
        return roomList.size();
    }
}
