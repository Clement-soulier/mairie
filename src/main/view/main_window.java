package main.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class main_window extends JFrame {
    public main_window() {
        super("gestion mairie");
        setSize(900, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(l);
        setVisible(true);
    }
}
