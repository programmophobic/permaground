package io.github.programmophobic.permaground.elements;

import io.github.programmophobic.permaground.core.Element;

public class VelocityElement extends Element {

    public float x, y;
    public boolean xBlocked, yBlocked;

    public VelocityElement(float x, float y) {
        this.x = x;
        this.y = y;
        xBlocked = false;
        yBlocked = false;
    }

    public void move(float dt) {
        if (!xBlocked) {
            getOwner().getPosition().translateX(x * dt);
        }
        if (!yBlocked) {
            getOwner().getPosition().translateY(y * dt);
        }
        xBlocked = false;
        yBlocked = false;
        x = 0;
        y = 0;
    }
}
