package io.github.programmophobic.permaground.core;

import io.github.programmophobic.permaground.util.Vertex;

import java.util.*;

public class GameObject {

    private Map<Class<? extends Element>, Element> elementMap;
    private List<Element> elementList;
    private Scene scene;
    private Vertex position;

    public GameObject() {
        elementMap = new HashMap<>();
        elementList = new ArrayList<>();
        position = new Vertex();
    }

    public void start() {
        for (Element element : elementList) {
            element.start();
        }
    }

    public void update(float dt) {
        for (Element element : elementList) {
            element.update(dt);
        }
    }

    public boolean addElement(Element element) {
        if (elementMap.containsKey(element.getClass()))
            return false;
        elementMap.put(element.getClass(), element);
        elementList.add(element);
        element.setOwner(this);
        return true;
    }

    public GameObject addElements(Element... elements) {
        for (Element element : elements) {
            if (!addElement(element))
                throw new IllegalStateException("Cannot add duplicate element type '" + element.getClass().getSimpleName() + "' to GameObject");
        }
        return this;
    }

    public <T extends Element> T getElement(Class<T> elementClass) {
        return elementClass.cast(elementMap.get(elementClass));
    }

    public <T extends Element> T requireElement(Class<T> elementClass) {
        var result = getElement(elementClass);
        if (result == null)
            throw new IllegalStateException("GameObject is missing required element '" + elementClass.getSimpleName() + "'");
        return result;
    }

    public boolean removeElement(Class<? extends Element> elementType) {
        Element element = elementMap.remove(elementType);
        if (element != null) {
            elementList.remove(element);
            element.setOwner(null);
            return true;
        }
        return false;
    }

    public boolean removeElement(Element element) {
        if (elementMap.remove(element.getClass()) != null) {
            elementList.remove(element);
            element.setOwner(null);
            return true;
        }
        return false;
    }

    public Vertex getPosition() {
        return position;
    }

    public void reset() {
        scene = null;
        position.reset();
        elementList.clear();
        elementMap.clear();
    }

    void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}
