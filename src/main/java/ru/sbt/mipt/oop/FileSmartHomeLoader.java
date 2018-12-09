package ru.sbt.mipt.oop;
import com.google.gson.Gson;
<<<<<<< HEAD
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Component;

=======
import ru.sbt.mipt.oop.SmartHome;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
<<<<<<< HEAD
import org.springframework.stereotype.Component;

@Component
=======

>>>>>>> 29d1065829dcc247aa42f4fd11191c1c60a6d77d
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
public class FileSmartHomeLoader implements SmartHomeLoader {
    @Override
    public SmartHome load() throws IOException {
        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        return gson.fromJson(json, SmartHome.class);
    }
}

