package main.view;

import java.awt.*;
import javax.swing.*;

public class Ajouter extends JPanel {
    public Ajouter() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label_nom = new JLabel("Nom");
        JTextField nom = new JTextField(20);
        JLabel label_prenom = new JLabel("Prénom");
        JTextField prenom = new JTextField(20);
        JLabel label_naissance = new JLabel("Date de naissance");
        JTextField naissance = new JTextField(20);
        JButton bouton_ajouter = new JButton("Ajouter");
        JLabel message_erreur = new JLabel("");

        label_nom.setAlignmentX(CENTER_ALIGNMENT);
        nom.setAlignmentX(CENTER_ALIGNMENT);
        label_prenom.setAlignmentX(CENTER_ALIGNMENT);
        prenom.setAlignmentX(CENTER_ALIGNMENT);
        label_naissance.setAlignmentX(CENTER_ALIGNMENT);
        naissance.setAlignmentX(CENTER_ALIGNMENT);
        bouton_ajouter.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        nom.setMaximumSize(nom.getPreferredSize());
        prenom.setMaximumSize(prenom.getPreferredSize());
        naissance.setMaximumSize(naissance.getPreferredSize());

        add(Box.createVerticalStrut(25));
        add(label_nom);
        add(Box.createVerticalStrut(5));
        add(nom);
        add(Box.createVerticalStrut(30));
        add(label_prenom);
        add(Box.createVerticalStrut(5));
        add(prenom);
        add(Box.createVerticalStrut(30));
        add(label_naissance);
        add(Box.createVerticalStrut(5));
        add(naissance);
        add(Box.createVerticalStrut(30));
        add(bouton_ajouter, BorderLayout.SOUTH);
        add(Box.createVerticalStrut(30));
        add(message_erreur);
    }
}
