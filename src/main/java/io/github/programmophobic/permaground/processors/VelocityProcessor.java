package io.github.programmophobic.permaground.processors;

import io.github.programmophobic.permaground.core.GameObject;
import io.github.programmophobic.permaground.core.Processor;
import io.github.programmophobic.permaground.core.Scene;
import io.github.programmophobic.permaground.elements.VelocityElement;

public class VelocityProcessor extends Processor {

    @Override
    public void start(Scene scene) {

    }

    @Override
    public void end(Scene scene) {

    }

    @Override
    public void update(GameObject gameObject, float dt) {
        VelocityElement ve = gameObject.getElement(VelocityElement.class);
        if (ve != null)
            ve.move(dt);
    }
}
