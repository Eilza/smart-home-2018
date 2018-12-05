package ru.sbt.mipt.oop;
import java.util.Collection;
import java.util.ArrayList;;

public class Room implements HomeComposite{
    private Collection<Light> lights;
    private Collection<Door> doors;
    private Collection<HomeComponent> components;
    private String name;

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
        if (components == null) {
            components = new ArrayList<>();
            components.addAll(doors);
            components.addAll(lights);
        }
        components.forEach((c) -> c.executeHomeGoRoundFunctional(homeGoRoundFunctional));
    }

    public String getName() {

        return name;
    }
}
