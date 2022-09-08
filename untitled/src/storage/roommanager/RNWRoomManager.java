package storage.roommanager;

import controller.RoomManager;
import model.room.Room;

import java.io.*;
import java.util.List;

public class RNWRoomManager {
    private final String LINK_ROOMMAMAGER = "C:\\Users\\Acer\\Desktop\\codegym\\Module2APJ\\casestudy\\untitled\\src\\storage\\roommanager\\roommanager.txt";
    private RNWRoomManager(){}

    private static RNWRoomManager instance;

    public RNWRoomManager getInstance(){
        if (instance == null)
            instance = new RNWRoomManager();
        return instance;
    }
    public List<Room> readData() {
        RoomManager roomManager = null;
        try {
            FileInputStream fis = new FileInputStream(LINK_ROOMMAMAGER);
            ObjectInputStream ois = new ObjectInputStream(fis);
            roomManager = (RoomManager) ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (List<Room>) roomManager;
    }

    public void writeData(List<Room> list) {
        try {
            FileOutputStream fis = new FileOutputStream(LINK_ROOMMAMAGER);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(list);
            oos.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
