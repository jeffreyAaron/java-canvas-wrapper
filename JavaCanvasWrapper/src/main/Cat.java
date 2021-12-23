package main;

import java.awt.*;

public class Cat extends Player {

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillOval((int) x, (int) y, (int) width, (int) height);
    }
}
