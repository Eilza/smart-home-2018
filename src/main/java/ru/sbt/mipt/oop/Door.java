package ru.sbt.mipt.oop;

public class Door implements HomeFlap{
    private final String id;
    private boolean isOpen;
<<<<<<< HEAD
=======
    private boolean lock;

    public boolean isLock() {
        return lock;
    }

    public void lock(boolean lock) {
        this.lock = lock;
    }

>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }
    public String getId() {

        return id;
    }
<<<<<<< HEAD
    private void setOpen(boolean open) {
        isOpen = open;
    }
    public boolean isOpen() {
        return isOpen;
=======

    public void setOpen(boolean open) {

        isOpen = open;
    }

    public void changeState(String componentID, boolean state) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
        if (this.isLock()) {
            System.out.println("Someone trying to change state of door "+ id +
                    "\n Sending sms \n");;
            return;
        }
=======
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
        if (componentID.equals(this.id)) {
            this.setOpen(state);
            System.out.println( "Door " + this.id + (state ? "was opened" : "was closed"));
        }
    }

    @Override
    public void executeHomeGoRoundFunctional(HomeGoRoundFunctional homeGoRoundFunctional) {
        homeGoRoundFunctional.execute(this);
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
    }
}
