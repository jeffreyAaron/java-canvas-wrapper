package gui.test;

import gui.Display;
import rendering.Renderer;

import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        Display display = new Display("Window Title", 500, 500);
        Renderer renderer = new Renderer(display);
        Graphics2D g2 = renderer.getGraphics();
        display.showCanvas();
        renderer.startRendering();

        g2.setColor(Color.RED);
        g2.fillRect(0, 0, 100, 100);


    }
}
