package ru.sbt.mipt.oop;

public class Signaling {
    private AlertState state = new Deactivate(this);

    void setPassword(String password) {
        this.password = password;
    }

    private String password = "4444";

    public Signaling() {
    }

    public Signaling(String password) {
        this.password = password;
    }

    void changeState(AlertState state) {
        this.state = state;
    }

    public AlertState getState() {
        return state;
    }

    public void activate(String pass) {
        state.activate(pass);
    }

    public void deactivate(String pass) {
        state.deactivate(pass);
    }

    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    public void setToAlert() {
        state.setToAlert();
    }
}
