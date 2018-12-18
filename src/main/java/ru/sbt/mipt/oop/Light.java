package ru.sbt.mipt.oop;

public class Light implements Actionable {
    private boolean isOn;
    private final String id;
    final String TURNED_ON = " was turned on.";
    final String TURNED_OFF = " was turned off.";

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public String getId() {
        return id;
    }


    public boolean isOn() {
        return isOn;
    }

    public void changeState(boolean state) {
        isOn = state;
        System.out.println("Light " + this.id + (state ? TURNED_ON : TURNED_OFF));
    }

    @Override
    public void executeHomeGoRoundFunctional(Action action) {
        action.execute(this);
    }
}