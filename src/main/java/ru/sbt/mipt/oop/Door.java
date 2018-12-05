package ru.sbt.mipt.oop;

public class Door implements HomeFlap{
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public void setOpen(boolean open) {

        isOpen = open;
    }

    public void changeState(String componentID, boolean state) {
        if (componentID.equals(this.id)) {
            this.setOpen(state);
            System.out.println( "Door " + this.id + (state ? "was opened" : "was closed"));
        }
    }

    @Override
    public void executeHomeGoRoundFunctional(HomeGoRoundFunctional homeGoRoundFunctional) {
        homeGoRoundFunctional.execute(this);
    }
}
