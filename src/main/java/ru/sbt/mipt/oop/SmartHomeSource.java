package ru.sbt.mipt.oop;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class SmartHomeSource implements HomeComposite, SmartHomeInterface {
    private Collection<HomeComponent> components;
    private Signaling signaling;

    public Collection<HomeComponent> getComponents() {
        return components;
    }

    public Signaling getSignaling() {
        return signaling;
    }

    public SmartHomeSource() {
        components = new ArrayList<>();
        signaling = new Signaling();
    }

    public SmartHomeSource(Collection<? extends HomeComponent> components) {
        this.components = new ArrayList<>();
        this.components.addAll(components);
        this.signaling = new Signaling();
    }

    @Override
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
    }

    @Override
    public void executeHomeGoRoundFunctional(HomeGoRoundFunctional homeGoRoundFunctional) {
        homeGoRoundFunctional.execute(this);
        if (components != null) components.forEach(c -> c.executeHomeGoRoundFunctional(homeGoRoundFunctional));
    }

    public void activateSignaling(String code) {
        this.signaling.activate(code);
    }

    public void deactivateSignaling(String code) {
        this.signaling.deactivate(code);
    }

    @Override
    public SmartHomeSource toSmartHomeSource() {
        return this;
    }
}
