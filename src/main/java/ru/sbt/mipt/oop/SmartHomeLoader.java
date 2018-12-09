package ru.sbt.mipt.oop;
import java.io.IOException;
import ru.sbt.mipt.oop.SmartHome;

public interface SmartHomeLoader {
    SmartHome load() throws IOException;
}
