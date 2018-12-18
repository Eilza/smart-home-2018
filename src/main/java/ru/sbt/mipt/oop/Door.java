package ru.sbt.mipt.oop;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;
    private final String OPENED = " was opened.";
    private final String CLOSED = " was closed.";

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void changeState(boolean state) {
        isOpen = state;
        System.out.println( "Door " + this.id + (state ? OPENED : CLOSED));
    }

    @Override
    public void executeHomeGoRoundFunctional(Action action) {
        action.execute(this);
    }
}
