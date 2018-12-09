package ru.sbt.mipt.oop;
import java.util.HashMap;
import java.util.Map;

public class RemoteController implements RemoteControl{
    private final String rcID;
    private Map<String, RemoteButtons> buttonMap = new HashMap<>();
    public RemoteController(String  rcID) {
        this.rcID = rcID;
    }
    public String getRcID() {
        return rcID;
    }
    @Override
    public void onButtonPressed(String buttonCode) {
        if (buttonMap.containsKey(buttonCode)) {
            buttonMap.get(buttonCode).execute();
        }
    }
    public RemoteController onButtonA(RemoteButtons command) {
        buttonMap.put("A", command);
        return this;
    }
    public RemoteController onButtonB(RemoteButtons command) {
        buttonMap.put("B", command);
        return this;
    }
    public RemoteController onButtonC(RemoteButtons command) {
        buttonMap.put("C", command);
        return this;
    }
    public RemoteController onButtonD(RemoteButtons command) {
        buttonMap.put("D", command);
        return this;
    }
    public RemoteController onButtonOne(RemoteButtons command) {
        buttonMap.put("1", command);
        return this;
    }
    public RemoteController onButtonTwo(RemoteButtons command) {
        buttonMap.put("2", command);
        return this;
    }
    public RemoteController onButtonThree(RemoteButtons command) {
        buttonMap.put("3", command);
        return this;
    }
    public RemoteController onButtonFour(RemoteButtons command) {
        buttonMap.put("4", command);
        return this;
    }
}
