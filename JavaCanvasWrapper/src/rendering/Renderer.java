package rendering;

import gui.Display;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferStrategy;

public class Renderer implements Runnable {

    private final Display display;
    private volatile BufferStrategy bs;
    private volatile int width, height;
    private volatile BufferedImage buffer;
    private final Thread renderThread;

    private volatile boolean isRunning = false;

    public Renderer(Display display) {
        this.display = display;
        this.renderThread = new Thread(this);
        performVariableInit();
    }

    private void performVariableInit() {
        setUpBufferStrategy();
        this.bs = display.getCanvas().getBufferStrategy();
        this.width = display.getCanvas().getWidth();
        this.height = display.getCanvas().getHeight();
        this.buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public Graphics2D getGraphics() {
        return buffer.createGraphics();
    }

    private void setUpBufferStrategy() {
        display.getCanvas().createBufferStrategy(2);
    }

    public void startRendering() {
        renderThread.start();
    }

    public void renderLoop(){
        isRunning = true;
        while(isRunning) {
            renderFrame();
            sleep(16);
        }
    }

    private void renderFrame() {
        do {
            do {
                Graphics g = null;
                try {

                    g = bs.getDrawGraphics();
                    g.clearRect(0, 0, getWidth(), getHeight());
                    g.drawImage(buffer, 0, 0, null);
                } finally {
                    if (g != null) {
                        g.dispose();
                    }
                }
            } while (bs.contentsRestored());
            bs.show();
        } while (bs.contentsLost());

    }

//    public void registerForRendering(RenderCallback renderCallback){
//        renderCallbacks.add(renderCallback);
//    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // HELPER METHODS

    public void sleep(long ms) {
        try {Thread.sleep(ms);} catch (InterruptedException e) {}
    }

    @Override
    public void run() {
        renderLoop();
    }
}
