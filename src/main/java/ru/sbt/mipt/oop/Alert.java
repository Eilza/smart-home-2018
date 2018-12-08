package ru.sbt.mipt.oop;

public class Alert implements AlertState {
    private Signaling signaling;

    public Alert(Signaling signaling) {
        this.signaling = signaling;
        System.out.println( "Alert!");
    }

    @Override
    public void changeState(AlertState state) {
        signaling.changeState(state);
    }

    @Override
    public void activate(String pass) {
        System.out.println("Someone try to change password");
    }

    @Override
    public void deactivate(String pass) {
        if (signaling.checkPassword(pass)){
            signaling.changeState(new Deactivate(signaling));
            System.out.println("Signaling deactivated");
        }
        System.out.println("Wrong password");
    }

    @Override
    public void setToAlert() {
    }
}
