package io.github.programmophobic.permaground.util;

public class Vertex {

    public float x, y;

    public Vertex(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vertex() {
        this(0, 0);
    }

    public Vertex set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vertex translate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }

    public Vertex translateX(float dx) {
        this.x += dx;
        return this;
    }

    public Vertex translateY(float dy) {
        this.y += dy;
        return this;
    }

    public Vertex reset() {
        return set(0, 0);
    }

    public Vertex copy() {
        return new Vertex(x, y);
    }

    public Vertex add(Vertex vertex) {
        translate(vertex.x, vertex.y);
        return this;
    }

    public Vertex sub(Vertex vertex) {
        translate(-vertex.x, -vertex.y);
        return this;
    }
}
