package ru.sbt.mipt.oop;
import java.io.IOException;

public class FileLoaderAdapter implements SmartHomeLoader {
    @Override
    public SmartHomeInterface load() throws IOException {
        FileSmartHomeLoader loader = new FileSmartHomeLoader();
        SmartHome home = loader.load();
        return home.toSmartHome();
    }
}
