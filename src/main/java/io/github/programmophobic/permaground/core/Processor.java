package io.github.programmophobic.permaground.core;

public abstract class Processor {

    public abstract void start(Scene scene);

    public abstract void update(GameObject gameObject, float dt);

    public abstract void end(Scene scene);

    public void process(Scene scene, float dt) {
        for (GameObject gameObject : scene.getGameObjects()) {
            update(gameObject, dt);
        }
    }
}
