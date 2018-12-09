package ru.sbt.mipt.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class FileSmartHomeLoaderTest {
    @Test
    public void loadTest() {
        SmartHomeLoader loader = new FileSmartHomeLoader();
        SmartHomeInterface home = null;
        try {
            home = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(home);
    }
}
