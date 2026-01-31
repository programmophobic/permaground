package io.github.programmophobic.permaground.core;

import java.util.ArrayList;
import java.util.List;

public class PooledScene extends Scene {

    private List<GameObject> pooledGameObjects;

    public PooledScene() {
        super();
        pooledGameObjects = new ArrayList<>();
    }

    public GameObject createGameObject() {
        GameObject gameObject;
        if (!pooledGameObjects.isEmpty())
            gameObject = pooledGameObjects.removeLast();
        else
            gameObject = new GameObject();
        gameObjects.add(gameObject);
        return gameObject;
    }

    public boolean removeGameObject(GameObject gameObject) {
        if (gameObjects.remove(gameObject)) {
            gameObject.reset();
            pooledGameObjects.add(gameObject);
            return true;
        }
        return false;
    }
}
