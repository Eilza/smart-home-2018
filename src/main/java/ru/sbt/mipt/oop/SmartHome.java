package ru.sbt.mipt.oop;
import ru.sbt.mipt.oop.Signaling;
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.Alert;

<<<<<<< HEAD
=======
public class SmartHome implements HomeComposite{
    Collection<HomeComponent> components;
    Collection<Room> rooms;
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40

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
<<<<<<< HEAD
=======

>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
        components.add(component);
    }

    @Override
    public void remove(HomeComponent component) {
<<<<<<< HEAD
        components.remove(component);
    }

    @Override
    public Collection<HomeComponent> getChildren() {
        return components;
    }

    @Override
=======

        components.remove(component);
    }

    @Override
    public Collection<HomeComponent> getChildren() {

        return components;
    }

    @Override
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
    public void executeHomeGoRoundFunctional(HomeGoRoundFunctional homeGoRoundFunctional) {
        homeGoRoundFunctional.execute(this);
        if (components == null) {
            components = new ArrayList<>();
            components.addAll(rooms);
        }
        components.forEach(c -> c.executeHomeGoRoundFunctional(homeGoRoundFunctional));
<<<<<<< HEAD
    }

    public boolean isHomeLocked() {
        return this.signaling.getState() instanceof Alert;
    }
    public void activateSignaling(String pass){
        this.signaling.activate(pass);
    }
    public void deactivateSignaling(String pass){
        this.signaling.deactivate(pass);
=======
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
    }
}
