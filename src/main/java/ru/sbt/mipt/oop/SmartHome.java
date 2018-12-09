package ru.sbt.mipt.oop;
import ru.sbt.mipt.oop.Signaling;
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.Alert;
import org.springframework.stereotype.Component;

@Component
public class SmartHome implements HomeComposite{
    private Collection<HomeComponent> components;
    private Collection<Room> rooms;
    private Signaling signaling;

    public SmartHome() {
        rooms = new ArrayList<>();
        signaling = new Signaling();
    }

    public Signaling getSignaling() {
        return signaling;
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        signaling = new Signaling();
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

    public boolean isHomeLocked() {
        return this.signaling.getState() instanceof Alert;
    }
    public void activateSignaling(String pass){
        this.signaling.activate(pass);
    }
    public void deactivateSignaling(String pass){
        this.signaling.deactivate(pass);
    }
}
