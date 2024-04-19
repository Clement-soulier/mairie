package main.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import main.model.*;

public class Etat extends JFrame {

    public Etat(Mairie mairie) {
        super("Etat");
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label_personne = new JLabel("id personne");
        JTextField id_personne = new JTextField(20);
        JButton etat_bouton = new JButton("Obtenir Etat");
        JLabel message_erreur = new JLabel("");

        id_personne.setMaximumSize(id_personne.getPreferredSize());

        label_personne.setAlignmentX(CENTER_ALIGNMENT);
        id_personne.setAlignmentX(CENTER_ALIGNMENT);
        etat_bouton.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(25));
        panel.add(label_personne);
        panel.add(Box.createVerticalStrut(5));
        panel.add(id_personne);
        panel.add(Box.createVerticalStrut(20));
        panel.add(etat_bouton);

        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
