package ru.sbt.mipt.oop;
import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements SmartHomeInterface, Actionable, Printable {
    private Collection<Room> rooms;
    private Signaling signaling;

    public Signaling getSignaling(){
        return signaling;
    }

    public SmartHome() {
        rooms = new ArrayList<>();
        signaling = new Signaling();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        signaling = new Signaling();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void executeHomeGoRoundFunctional(Action action) {
        action.execute(this);
        for (Room room : rooms) {
            room.executeHomeGoRoundFunctional(action);
        }
    }

    public void activateSignaling(String pass) {
        this.signaling.activate(pass);
    }

    public void deactivateSignaling(String pass) {
        this.signaling.deactivate(pass);
    }

    @Override
    public SmartHome toSmartHome() {
        return this;
    }

    @Override
    public void printToSystem() {
        System.out.println("Smart home consists of:");
        for(Room room : rooms){
            room.printToSystem();
        }
    }
}