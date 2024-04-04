package test;

import javax.swing.*;
import java.awt.event.*;
import main.view.*;

public class main_window {

    public static void main(String[] args) {
        JFrame frame = new main.view.main_window();
        frame.setJMenuBar(new main.view.toolbar());
        frame.setVisible(true);
    }

}
