package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements HomeComposite{
    Collection<HomeComponent> components;
    Collection<Room> rooms;

    public SmartHome() {

        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {

        this.rooms = rooms;
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
            components.addAll(rooms);
        }
        components.forEach(c -> c.executeHomeGoRoundFunctional(homeGoRoundFunctional));
    }
}
