package controller;



import model.room.GrandRoom;
import model.room.Room;
import model.room.StandardRoom;
import model.room.SuiteRoom;
import storage.roommanager.RNWRoomManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomManager implements Serializable {
    private static final int CAPACITY = 5;
    static ArrayList<Room> roomList = RNWRoomManager.readData();
    private RoomManager(){}
    private static boolean checkfull(){
        return roomList.size() <= CAPACITY;
    }
    public static void addRoom(Room room){
        if (checkfull()){
            System.out.println("done");
        roomList.add(room);}
        else System.out.println("Full");
    }
    public static List<Room> getListRoom(){
        return roomList;
    }
    public static int getSize() {
        return roomList.size();
    }
    public static int findRoomByName(String nameRoom){
        int index = -1;

        for (int i = 0; i < RoomManager.getSize(); i++) {
            if (Objects.equals(nameRoom, RoomManager.getListRoom().get(i).getName())){
                index = i;
                break;
            }
        }
        return index;
    }
    public static void showSuiteRoomNull(){
        boolean check = true;
        for (int i = 0; i < RoomManager.getSize(); i++) {
            if (RoomManager.getListRoom().get(i).isEmpty() && RoomManager.getListRoom().get(i) instanceof SuiteRoom){
                System.out.println(RoomManager.getListRoom().get(i));
                check = false;
            }
        }
        if (check){
            System.out.println("het phong");
        }
    }
    public static void showStandardRoomNull() {
        boolean check = true;
        for (int i = 0; i < RoomManager.getSize(); i++) {
            if (RoomManager.getListRoom().get(i).isEmpty() && RoomManager.getListRoom().get(i) instanceof StandardRoom){
                System.out.println(RoomManager.getListRoom().get(i));
                check = false;
            }
        }
        if (check){
            System.out.println("het phong");
        }
    }

    public static void showGrandRoomNull() {
        boolean check = true;
        for (int i = 0; i < RoomManager.getSize(); i++) {
            if (RoomManager.getListRoom().get(i).isEmpty() && RoomManager.getListRoom().get(i) instanceof GrandRoom){
                System.out.println(RoomManager.getListRoom().get(i));
                check = false;
            }
        }
        if (check){
            System.out.println("het phong");
        }
    }
    public static void showRoom(){
        for (int i = 0; i < RoomManager.getListRoom().size(); i++){
            System.out.println(roomList.get(i));
        }
    }
}
