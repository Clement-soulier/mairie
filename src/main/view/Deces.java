package main.view;

import java.awt.*;
import javax.swing.*;

public class Deces extends JPanel {
    public Deces() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel personne = new JLabel("id personne");
        JTextField id_personne = new JTextField(20);
        JButton bouton_deces = new JButton("déclarer décès");
        JLabel message_erreur = new JLabel("");

        personne.setAlignmentX(CENTER_ALIGNMENT);
        id_personne.setAlignmentX(CENTER_ALIGNMENT);
        bouton_deces.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        id_personne.setMaximumSize(id_personne.getPreferredSize());

        add(Box.createVerticalStrut(25));
        add(personne, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(id_personne, BorderLayout.CENTER);
        add(Box.createVerticalStrut(30));
        add(bouton_deces, BorderLayout.SOUTH);
        add(Box.createVerticalStrut(30));
        add(message_erreur, BorderLayout.EAST);
    }
}
