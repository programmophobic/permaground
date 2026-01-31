package io.github.programmophobic.permaground.screens;

import com.badlogic.gdx.Screen;

import io.github.programmophobic.permaground.PermagroundGame;

public abstract class AbstractScreen implements Screen {

    protected final PermagroundGame game;

    public AbstractScreen(PermagroundGame game) {
        this.game = game;
    }
}
