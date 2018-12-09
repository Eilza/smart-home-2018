package ru.sbt.mipt.oop;
import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements SmartHomeInterface {
    private Collection<Room> rooms;
    public Collection<Room> getRooms() {
        return rooms;
    }
    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }
    public SmartHome() {
    }
    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }
    public SmartHomeSource toSmartHomeSource() {
        Collection<HomeComponent> homeComponents = new ArrayList<>();
        for (Room r: rooms) {
            Collection<HomeComponent> roomComponents = new ArrayList<>();
            for (Door d: r.getDoors()) {
                roomComponents.add(new DoorComponent(d.isOpen(),d.getId()));
            }
            for (Light l: r.getLights()) {
                roomComponents.add(new LightComponent( l.getId(), l.isOn()));
            }
            homeComponents.add(new RoomComponent(roomComponents, r.getName()));
        }
        return new SmartHomeSource(homeComponents);
    }
}