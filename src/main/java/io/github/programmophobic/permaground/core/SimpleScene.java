package io.github.programmophobic.permaground.core;

public class SimpleScene extends Scene {

    public boolean addGameObject(GameObject gameObject) {
        boolean result = gameObjects.add(gameObject);
        if (result)
            gameObject.setScene(this);
        return result;
    }

    public boolean removeGameObject(GameObject gameObject) {
        boolean result = gameObjects.remove(gameObject);
        if (result)
            gameObject.setScene(null);
        return result;
    }
}
