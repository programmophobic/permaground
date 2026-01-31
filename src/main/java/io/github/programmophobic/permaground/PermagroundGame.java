package io.github.programmophobic.permaground;

import com.badlogic.gdx.Game;
import io.github.programmophobic.permaground.screens.PlayScreen;

public class PermagroundGame extends Game {

    @Override
    public void create() {
        super.setScreen(new PlayScreen(this));
    }
}
