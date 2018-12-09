package ru.sbt.mipt.oop;
<<<<<<< HEAD

=======
>>>>>>> e35bf48c620e741f61eddf8168fc2a21d6d2a618
import java.util.Collection;

public interface HomeComposite extends HomeComponent {
    void addChild(HomeComponent component);

    void remove(HomeComponent component);

    Collection<HomeComponent> getChildren();
}
