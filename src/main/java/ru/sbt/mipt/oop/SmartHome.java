package ru.sbt.mipt.oop;
import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements SmartHomeInterface, HomeComponent {
    private Collection<Room> rooms;
    private Collection<HomeComponent> components;

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    /*public SmartHome() {
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }*/

    /*public SmartHome toSmartHome() {
        Collection<HomeComponent> homeComponents = new ArrayList<>();
        for (Room r: rooms) {
            Collection<HomeComponent> roomComponents = new ArrayList<>();
            for (Door d: r.getDoors()) {
                roomComponents.add(new Door(d.isOpen(),d.getId()));
            }
            for (Light l: r.getLights()) {
                roomComponents.add(new Light( l.getId(), l.isOn()));
            }
            homeComponents.add(new Room(roomComponents, r.getName()));
        }
        return new SmartHome(homeComponents);
    }*/





    //private Collection<HomeComponent> components;
    private Signaling signaling;

    /*public Collection<HomeComponent> getComponents() {
        return components;
    }*/

    public Signaling getSignaling() {
        return signaling;
    }

    public SmartHome() {
        components = new ArrayList<>();
        signaling = new Signaling();
    }

    public SmartHome(Collection<? extends HomeComponent> components) {
        this.components = new ArrayList<>();
        this.components.addAll(components);
        this.signaling = new Signaling();
    }

    /*@Override
    public void addChild(HomeComponent component) {
        if (components == null) components = new ArrayList<>();
        components.add(component);
    }

    @Override
    public void remove(HomeComponent component) {
        components.remove(component);
    }

    @Override
    public Collection<HomeComponent> getChildren() {
        return components;
    }*/

    @Override
    public void executeHomeGoRoundFunctional(HomeGoRoundFunctional homeGoRoundFunctional) {
        homeGoRoundFunctional.execute(this);
        //if (components != null) components.forEach(c -> c.executeHomeGoRoundFunctional(homeGoRoundFunctional));
    }

    public void activateSignaling(String code) {
        this.signaling.activate(code);
    }

    public void deactivateSignaling(String code) {
        this.signaling.deactivate(code);
    }

    @Override
    public SmartHome toSmartHome() {
        return this;
    }
}