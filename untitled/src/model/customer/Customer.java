package model.customer;

import model.room.Room;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private long identityCard;
    Room room;

    public Customer(String name, long identityCard) {
        this.name = name;
        this.identityCard = identityCard;
        this.room = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(long identityCard) {
        this.identityCard = identityCard;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer(String name, long identityCard, Room room) {
        this.name = name;
        this.identityCard = identityCard;
        this.room = room;
    }
}
