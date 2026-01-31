package io.github.programmophobic.permaground.core;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    protected List<GameObject> gameObjects;

    public Scene() {
        gameObjects = new ArrayList<>();
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
