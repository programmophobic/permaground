package io.github.programmophobic.permaground.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.programmophobic.permaground.PermagroundGame;
import io.github.programmophobic.permaground.core.*;
import io.github.programmophobic.permaground.elements.ColliderElement;
import io.github.programmophobic.permaground.elements.PlayerElement;
import io.github.programmophobic.permaground.elements.TextureElement;
import io.github.programmophobic.permaground.elements.VelocityElement;
import io.github.programmophobic.permaground.processors.RenderProcessor;
import io.github.programmophobic.permaground.processors.VelocityProcessor;

public class PlayScreen extends AbstractScreen {

    private PooledScene scene;
    private Pipeline pipeline;

    private Texture texture;

    public PlayScreen(PermagroundGame game) {
        super(game);

        texture = new Texture("programmophobic.png");
        scene = new PooledScene();

        scene.createGameObject().addElements(
                new VelocityElement(0, 0),
                new PlayerElement(),
                new TextureElement(texture, 32, 32),
                new ColliderElement(32, 32, false)
        ).getPosition().set(128, 256);

        scene.createGameObject().addElements(
                new TextureElement(texture, 32, 32),
                new ColliderElement(32, 32, false)
        ).getPosition().set(256, 256);

        scene.createGameObject().addElements(
                new VelocityElement(0, 0),
                new Element() {
                    @Override
                    public void update(float dt) {
                        VelocityElement ve = getOwner().requireElement(VelocityElement.class);
                        ve.x = -100;
                    }
                },
                new TextureElement(texture, 32, 32),
                new ColliderElement(32, 32, false)
        ).getPosition().set(700, 256);

        //pipeline.addProcessor(new PhysicsProcessor());

        pipeline = new Pipeline(
                new VelocityProcessor(),
                new RenderProcessor()
        );
        pipeline.start(scene);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float dt) {
        pipeline.update(scene, dt);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        texture.dispose();
        pipeline.end(scene);
    }
}
