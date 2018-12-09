package ru.sbt.mipt.oop;
import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Component;

@Component
public class FileSmartHomeLoader implements SmartHomeLoader {
    @Override
    public SmartHome load() throws IOException {
        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        return gson.fromJson(json, SmartHome.class);
    }
}

