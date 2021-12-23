package gui.test;

import gui.Display;
import main.Cat;
import main.Entity;
import main.Player;
import rendering.RenderFrame;
import rendering.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        // create a display that contains a canvas
        Display display = new Display("Window Title", 500, 600);
        // create renderer in order to render content on the canvas
        // double buffering is builtin to the renderer
        Renderer renderer = new Renderer(display);
        // show the display
        display.showCanvas();

        List<Entity> entities = new ArrayList<>();
        Cat dot1 = new Cat();
        dot1.setX(0);
        dot1.setY(0);
        dot1.setWidth(100);
        dot1.setHeight(100);
        entities.add(dot1);

        Cat dot2 = new Cat();
        dot2.setX(200);
        dot2.setY(100);
        dot2.setWidth(100);
        dot2.setHeight(100);
        entities.add(dot2);

        Cat dot3 = new Cat();
        dot3.setX(400);
        dot3.setY(200);
        dot3.setWidth(100);
        dot3.setHeight(100);
        entities.add(dot3);

        // start rendering
        renderer.startRendering(new RenderFrame() {
            @Override
            public void renderFrame(Graphics2D g2) {
                g2.clearRect(0, 0, 500, 600);
                for (Entity e : entities) {
                    e.update();
                    e.render(g2);
                }
            }
        });

    }
}
