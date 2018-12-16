package ru.sbt.mipt.oop;
import java.util.ArrayList;
import java.util.Collection;

public class Room implements HomeComponent{
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;
    private Collection<HomeComponent> components;

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

    /*public Room(Collection<HomeComponent> components, String name) {
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
    public void executeHomeGoRoundFunctional(HomeGoRoundFunctional homeGoRoundFunctional) {
        homeGoRoundFunctional.execute(this);
    }
}
