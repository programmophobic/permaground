package io.github.programmophobic.permaground.elements;

import com.badlogic.gdx.graphics.Texture;
import io.github.programmophobic.permaground.core.Element;

public class TextureElement extends Element {

    public Texture texture;
    public float width, height;

    public TextureElement(Texture texture, float width, float height) {
        this.texture = texture;
        this.width = width;
        this.height = height;
    }

    public TextureElement(Texture texture) {
        this(texture, texture.getWidth(), texture.getHeight());
    }
}
