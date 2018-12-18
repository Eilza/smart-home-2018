package ru.sbt.mipt.oop;

public class Deactivate implements AlertState {
    private Signaling signaling;

    public Deactivate(Signaling signaling) {
        this.signaling = signaling;
        this.signaling.setPassword("4444");
        System.out.println( "Signaling disabled");
    }
    @Override
    public void changeState(AlertState state) {
        signaling.changeState(state);
    }
    @Override
    public void activate(String pass) {
        signaling.changeState(new Activate(signaling,pass));
        System.out.println("Signaling is activated");
    }
    @Override
    public void deactivate(String pass) {
        System.out.println("Signaling is already disabled");
    }

    @Override
    public void setToAlert() {
        System.out.println("Something goes wrong");
        changeState(new Alert(signaling));
    }
}

