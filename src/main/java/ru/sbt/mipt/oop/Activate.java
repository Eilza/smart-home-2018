package ru.sbt.mipt.oop;

public class Activate implements AlertState{
    Signaling signaling;

    public Activate(Signaling signaling, String pass) {
        this.signaling = signaling;
        this.signaling.setPassword(pass);
        System.out.println("Signaling activated");
    }

    @Override
    public void changeState( AlertState state) {
        signaling.changeState(state);
    }

    @Override
    public void activate(String pass) {
        System.out.println("Signaling already has been activated");
        changeState(new Alert(signaling));
    }

    @Override
    public void deactivate(String pass) {
        if (signaling.checkPassword(pass)) {
            System.out.println("Signaling is deactivated");
            changeState(new Deactivate(signaling));
        } else {
            System.out.println("Wrong password");
            changeState(new Alert(signaling));
        }
    }

    @Override
    public void setToAlert() {
        System.out.println("Unacceptable behaviour!");
        changeState(new Alert(signaling));
    }
}
