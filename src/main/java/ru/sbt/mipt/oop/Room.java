package ru.sbt.mipt.oop;
import java.util.Collection;

public class Room implements Actionable, Printable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;
    private Collection<Actionable> components;

    public void setLights(Collection<Light> lights) {
        this.lights = lights;
    }

    public void setDoors(Collection<Door> doors) {
        this.doors = doors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Room() {
    }

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        //this.components = new ArrayList<>();
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    /*public Room(Collection<Actionable> components, String name) {
        this.components = components;
        this.name = name;
    }*/

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    @Override
    public void executeHomeGoRoundFunctional(Action action) {
        action.execute(this);

        for (Light light : getLights()) {
            light.executeHomeGoRoundFunctional(action);
        }
        for (Door door : getDoors()) {
            door.executeHomeGoRoundFunctional(action);
        }

    }

    @Override
    public void printToSystem() {
        System.out.println("Room " + getName() + " consist of:");
        for(Door door : doors){
            System.out.println("Door " + door.getId() + " is open: " + door.isOpen() + ".");
        }

        for(Light light : lights){
            System.out.println("Light " + light.getId() + " is on: " + light.isOn() + ".");
        }

    }
}
