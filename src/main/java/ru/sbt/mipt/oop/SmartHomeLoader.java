package ru.sbt.mipt.oop;
import java.io.IOException;

public interface SmartHomeLoader {
    SmartHomeInterface load() throws IOException;
}
