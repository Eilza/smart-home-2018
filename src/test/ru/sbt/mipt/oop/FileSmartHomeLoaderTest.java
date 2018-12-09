package ru.sbt.mipt.oop;
<<<<<<< HEAD
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
=======
import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.FileSmartHomeLoader;
import ru.sbt.mipt.oop.SmartHomeLoader;
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
import java.io.IOException;

public class FileSmartHomeLoaderTest {
    @Test
    public void loadTest() {
        SmartHomeLoader loader = new FileSmartHomeLoader();
<<<<<<< HEAD
        SmartHomeInterface home = null;
=======
        SmartHome home = null;
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
        try {
            home = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        Assertions.assertNotNull(home);
=======
        Assert.assertTrue(home != null);
        Assert.assertTrue(!home.getRooms().isEmpty());
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
    }
}
