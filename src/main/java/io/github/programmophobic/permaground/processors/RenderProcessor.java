package io.github.programmophobic.permaground.processors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.programmophobic.permaground.core.GameObject;
import io.github.programmophobic.permaground.core.Processor;
import io.github.programmophobic.permaground.core.Scene;
import io.github.programmophobic.permaground.elements.TextureElement;

public class RenderProcessor extends Processor {

    private SpriteBatch batch;

    @Override
    public void start(Scene scene) {
        batch = new SpriteBatch();
    }

    @Override
    public void end(Scene scene) {
        batch.dispose();
    }

    @Override
    public void update(GameObject gameObject, float dt) {

    }

    @Override
    public void process(Scene scene, float dt) {
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        for (var go : scene.getGameObjects()) {
            var te = go.getElement(TextureElement.class);
            if (te != null) {
                batch.draw(te.texture, go.getPosition().x, go.getPosition().y, te.width, te.height);
            }
        }
        batch.end();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }
}
