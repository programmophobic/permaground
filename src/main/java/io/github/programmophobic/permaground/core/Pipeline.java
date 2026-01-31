package io.github.programmophobic.permaground.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pipeline {

    private List<Processor> processors;

    public Pipeline() {
        processors = new ArrayList<>();
    }

    public Pipeline(Processor... processors) {
        this();
        Collections.addAll(this.processors, processors);
    }

    public boolean addProcessor(Processor processor) {
        return processors.add(processor);
    }

    public boolean removeProcessor(Processor processor) {
        return processors.remove(processor);
    }

    public void start(Scene scene) {
        for (GameObject gameObject : scene.gameObjects) {
            gameObject.start();
        }
        for (Processor processor : processors) {
            processor.start(scene);
        }
    }

    public void update(Scene scene, float dt) {
        for (GameObject gameObject : scene.gameObjects) {
            gameObject.update(dt);
        }
        for (Processor processor : processors) {
            processor.process(scene, dt);
        }
    }

    public void end(Scene scene) {
        for (Processor processor : processors) {
            processor.end(scene);
        }
    }
}
