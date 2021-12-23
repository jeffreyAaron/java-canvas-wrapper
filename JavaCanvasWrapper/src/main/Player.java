package main;

import java.awt.*;

public class Player extends Entity {

    public Color color = Color.RED;
    public float velY = 0;

    @Override
    public void update() {
        velY += 1;

        y += velY;

        if(y + height > 500) {
            y = 500 - height;
            velY = -14;
        }
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect((int) x, (int) y, (int) width, (int) height);
    }
}
