package gui;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private Canvas canvas;
    protected Toolkit toolkit;

    public Display(String title, int width, int height) {
        toolkit = Toolkit.getDefaultToolkit();
        canvas = new Canvas();
        canvas.setSize(width, height);
        canvas.setBackground(Color.WHITE);
        canvas.setIgnoreRepaint(true);
        getContentPane().add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Toolkit tools = Toolkit.getDefaultToolkit();
        setLocation((tools.getScreenSize().width - width) / 2, (tools.getScreenSize().height - height) / 2);
        setTitle(title);
        setIgnoreRepaint(true);
        setResizable(false);
        setUndecorated(true);
        setVisible(false);
        pack();
    }

    public void showCanvas() {
        setVisible(true);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
