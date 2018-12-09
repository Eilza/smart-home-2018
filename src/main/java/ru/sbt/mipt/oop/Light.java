package ru.sbt.mipt.oop;

public class Light implements HomeFlap{
    private boolean isOn;
    private final String id;
    private boolean lock;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

<<<<<<< HEAD
    public void changeState(String componentID, boolean state) {
=======
<<<<<<< HEAD
    public boolean isLock() {
        return lock;
    }

    public void changeState(String componentID, boolean state) {
        if (this.isLock()) {
            System.out.println("Someone trying to change state of light "+ id +
                    "\n Sending sms \n");;
            return;
        }
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
        if (componentID.equals(this.id)) {
            this.setOn(state);
            System.out.println("Light " + this.id + (state ? "was turned on" : "was turned off"));
        }
    }

    @Override
<<<<<<< HEAD
=======
    public void lock(boolean lock) {
        this.lock = lock;
    }

=======
    public void changeState(String componentID, boolean state) {
        if (componentID.equals(this.id)) {
            this.setOn(state);
            System.out.println("Light " + this.id + (state ? " was turned on" : " was turned off"));
        }
    }
>>>>>>> 8d9b98930b40e65a28cefb07a5066cc77ad5ac40
    @Override
>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
    public void executeHomeGoRoundFunctional(HomeGoRoundFunctional homeGoRoundFunctional) {
        homeGoRoundFunctional.execute(this);
    }

}