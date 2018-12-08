package ru.sbt.mipt.oop;

public class Door implements HomeFlap{
    private final String id;
    private boolean isOpen;
    private boolean lock;

    public boolean isLock() {
        return lock;
    }

    public void lock(boolean lock) {
        this.lock = lock;
    }

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
        if (this.isLock()) {
            System.out.println("Someone trying to change state of door "+ id +
                    "\n Sending sms \n");;
            return;
        }
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
