package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileLoaderAdapterTest {
    @Test
    public void toSmartHomeTest() {
        SmartHomeLoader loader = new FileLoaderAdapter();
        SmartHomeInterface home = null;
        try {
            home = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(home);
        SmartHome smartHome = home.toSmartHome();
        Assertions.assertEquals(4, smartHome.getRooms().size());
    }
}