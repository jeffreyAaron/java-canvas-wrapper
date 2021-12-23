package main;

import java.awt.*;

public abstract class Entity {
    protected float x, y;
    protected float width, height;


    // Game loop
    // (process input)
    // update
    // render
    // repeat

    // behavior
    public abstract void update();
    public abstract void render(Graphics2D g2);

    // GETTERS AND SETTERS

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
