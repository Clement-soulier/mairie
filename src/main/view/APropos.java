package main.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class APropos extends JFrame {

    public APropos() {
        super("A propos");
        setSize(400, 200);

        JPanel panel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("Clément Soulier 2024");

        panel.add(label);

        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}