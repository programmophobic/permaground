package io.github.programmophobic.permaground.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import io.github.programmophobic.permaground.core.Element;

public class PlayerElement extends Element {

    @Override
    public void update(float dt) {
        VelocityElement ve = getOwner().requireElement(VelocityElement.class);
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            ve.x = 500;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            ve.x = -500;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            ve.y = 500;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            ve.y = -500;
        }
    }
}
