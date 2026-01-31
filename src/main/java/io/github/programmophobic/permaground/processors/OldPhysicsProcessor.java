package io.github.programmophobic.permaground.processors;

import io.github.programmophobic.permaground.core.GameObject;
import io.github.programmophobic.permaground.core.Processor;
import io.github.programmophobic.permaground.core.Scene;
import io.github.programmophobic.permaground.elements.ColliderElement;
import io.github.programmophobic.permaground.elements.VelocityElement;

import java.util.List;

public class OldPhysicsProcessor extends Processor {

    @Override
    public void start(Scene scene) {

    }

    @Override
    public void update(GameObject gameObject, float dt) {

    }

    @Override
    public void end(Scene scene) {

    }

    private void resolveCollision(GameObject go1, GameObject go2, ColliderElement ce1, ColliderElement ce2, VelocityElement ve1, VelocityElement ve2) {
        float vx = 0;
        float vy = 0;
        float vx2 = 0;
        float vy2 = 0;
        boolean xBlocked1 = false;
        boolean yBlocked1 = false;
        boolean xBlocked2 = false;
        boolean yBlocked2 = false;
        if (ve1 != null) {
            vx = ve1.x;
            vy = ve1.y;
            xBlocked1 = ve1.xBlocked;
            yBlocked1 = ve1.yBlocked;
        }
        if (ve2 != null) {
            vx2 = ve2.x;
            vy2 = ve2.y;
            xBlocked2 = ve2.xBlocked;
            yBlocked2 = ve2.yBlocked;
        }
        if (ce1.intersects(ce2, go1.getPosition().x + vx, go1.getPosition().y, go2.getPosition().x + vx2, go2.getPosition().y)) {
            if (vx > vx2) {

            }
            xBlocked1 = true;
            xBlocked2 = true;
        }
        if (ce1.intersects(ce2, go1.getPosition().x, go1.getPosition().y + vy, go2.getPosition().x, go2.getPosition().y + vy2)) {
            yBlocked1 = true;
            yBlocked2 = true;
        }
        if (ve1 != null) {
            ve1.xBlocked = xBlocked1;
            ve1.yBlocked = yBlocked1;
        }
        if (ve2 != null) {
            ve2.xBlocked = xBlocked2;
            ve2.yBlocked = yBlocked2;
        }
    }

    @Override
    public void process(Scene scene, float dt) {
        List<GameObject> gameObjects = scene.getGameObjects();
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            ColliderElement colliderElement = gameObject.getElement(ColliderElement.class);
            if (colliderElement == null)
                continue;
            for (int j = i + 1; j < gameObjects.size(); j++) {
                GameObject gameObject2 = gameObjects.get(j);
                ColliderElement colliderElement2 = gameObject2.getElement(ColliderElement.class);
                if (colliderElement2 == null)
                    continue;
                resolveCollision(gameObject, gameObject2, colliderElement, colliderElement2,
                        gameObject.getElement(VelocityElement.class), gameObject2.getElement(VelocityElement.class));
            }
        }
    }
}