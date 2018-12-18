package ru.sbt.mipt.oop;
import java.util.Collection;

public interface HomeComposite extends Actionable {
    void addChild(Actionable component);

    void remove(Actionable component);

    Collection<Actionable> getChildren();
}
