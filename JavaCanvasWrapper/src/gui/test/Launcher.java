package gui.test;

import gui.Display;
import rendering.Renderer;

import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        // create a display that contains a canvas
        Display display = new Display("Window Title", 500, 500);
        // create renderer in order to render content on the canvas
        // double buffering is builtin to the renderer
        Renderer renderer = new Renderer(display);
        // retrieve the context from the renderer
        Graphics2D g2 = renderer.getGraphics();
        // show the display
        display.showCanvas();
        // start rendering
        renderer.startRendering();


        // do your painting anytime using simple commands
        g2.setColor(Color.RED);
        g2.fillRect(0, 0, 100, 100);


    }
}
