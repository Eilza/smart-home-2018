package ru.sbt.mipt.oop;
import java.util.Collection;
import java.util.ArrayList;;

public class Room implements HomeComposite{
    private Collection<Light> lights;
    private Collection<Door> doors;
    private Collection<HomeComponent> components;
    private String name;

    public void setLights(Collection<Light> lights) {
        this.lights = lights;
    }
    public void setDoors(Collection<Door> doors) {
        this.doors = doors;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Room() {
    }

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        components = new ArrayList<>();
        components.addAll(lights);
        components.addAll(doors);
        this.name = name;
    }

    @Override
    public void addChild(HomeComponent component) {
        components.add(component);
    }

    @Override
    public void remove(HomeComponent component) {
        components.remove(component);
    }

    @Override
    public Collection<HomeComponent> getChildren() {
        return components;
    }

    @Override
    public void executeHomeGoRoundFunctional(HomeGoRoundFunctional homeGoRoundFunctional) {
        homeGoRoundFunctional.execute(this);
<<<<<<< HEAD
        if (components == null || components.isEmpty()) {
=======
        if (components == null) {
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
            components = new ArrayList<>();
            components.addAll(doors);
            components.addAll(lights);
        }
        components.forEach((c) -> c.executeHomeGoRoundFunctional(homeGoRoundFunctional));
    }

    public String getName() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
        return name;
    }
}
