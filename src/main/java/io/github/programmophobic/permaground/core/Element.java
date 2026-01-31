package io.github.programmophobic.permaground.core;

public class Element {

    private GameObject owner;

    void setOwner(GameObject owner) {
        this.owner = owner;
    }

    public GameObject getOwner() {
        return owner;
    }

    public void start() {}

    public void update(float dt) {}
}
