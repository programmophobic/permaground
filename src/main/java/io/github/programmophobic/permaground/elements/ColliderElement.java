package io.github.programmophobic.permaground.elements;

import io.github.programmophobic.permaground.core.Element;

public class ColliderElement extends Element {

    public float width, height;
    public boolean solid;

    public ColliderElement(float width, float height, boolean solid) {
        this.width = width;
        this.height = height;
        this.solid = solid;
    }

    public boolean intersects(ColliderElement other) {
        return (getOwner().getPosition().x - width / 2 < other.getOwner().getPosition().x + other.width / 2 &&
                getOwner().getPosition().x + width / 2 > other.getOwner().getPosition().x - other.width / 2 &&
                getOwner().getPosition().y - height / 2 < other.getOwner().getPosition().y + other.height / 2 &&
                getOwner().getPosition().y + height / 2 > other.getOwner().getPosition().y - other.height / 2);
    }

    public boolean intersects(ColliderElement other, float x, float y, float x2, float y2) {
        return (x - width / 2 < x2 + other.width / 2 &&
                x + width / 2 > x2 - other.width / 2 &&
                y - height / 2 < y2 + other.height / 2 &&
                y + height / 2 > y2 - other.height / 2);
    }
}
