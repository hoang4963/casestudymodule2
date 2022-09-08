package controller;



import model.room.Room;
import storage.roommanager.RNWRoomManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomManager implements Serializable {
    private static final int CAPACITY = 5;
    static ArrayList<Room> roomList = (ArrayList<Room>) RNWRoomManager.readData();
    private RoomManager(){}
    private static boolean checkfull(){
        return roomList.size() <= CAPACITY;
    }
    public static void addRoom(Room room){
        if (checkfull())
        roomList.add(room);
        else System.out.println("Full");
    }
    public static List<Room> getListRoom(){
        return roomList;
    }
    public static int getSize(){
        return roomList.size();
    }
}
