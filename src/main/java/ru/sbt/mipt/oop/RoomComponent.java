package ru.sbt.mipt.oop;
import java.util.ArrayList;
import java.util.Collection;

public class RoomComponent implements HomeComponent {
    private Collection<HomeComponent> components;
    private String name;

    public RoomComponent(Collection<HomeComponent> components, String name) {
        this.components = components;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public RoomComponent() {
        this.components = new ArrayList<>();
    }

    @Override
    public void addChild(HomeComponent component) {
        if (components == null){
            components = new ArrayList<>();
        }
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
        if (components != null)     components.forEach((c) -> c.executeHomeGoRoundFunctional(homeGoRoundFunctional));
    }
}
