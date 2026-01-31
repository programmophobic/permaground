package io.github.programmophobic.permaground;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class PGMain {

    private static final String TITLE = "Permaground";
    private static final String VERSION = "v0.1";
    private static final float RATIO = 16f / 9f;
    private static final int WIDTH = 960;
    private static final int HEIGHT = (int) (WIDTH / RATIO);

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration conf = new Lwjgl3ApplicationConfiguration();
        conf.setTitle("Permaground");
        conf.setWindowedMode(WIDTH, HEIGHT);
        conf.setResizable(false);
        new Lwjgl3Application(new PermagroundGame(), conf);
    }
}
