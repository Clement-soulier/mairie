package main.view;

import java.awt.*;
import javax.swing.*;
import main.model.*;

public class Naissance extends JPanel {
    public Naissance(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel label_pere = new JLabel("id père");
        JTextField id_pere = new JTextField(20);
        JLabel label_mere = new JLabel("id mère");
        JTextField id_mere = new JTextField(20);
        JLabel label_nom = new JLabel("Nom");
        JTextField nom = new JTextField(20);
        JLabel label_prenom = new JLabel("Prénom");
        JTextField prenom = new JTextField(20);
        JLabel label_naissance = new JLabel("Date de naissance");
        JTextField naissance = new JTextField(20);
        JButton bouton_ajouter = new JButton("Ajouter");
        JLabel message_erreur = new JLabel("");

        label_pere.setAlignmentX(CENTER_ALIGNMENT);
        id_pere.setAlignmentX(CENTER_ALIGNMENT);
        label_mere.setAlignmentX(CENTER_ALIGNMENT);
        id_mere.setAlignmentX(CENTER_ALIGNMENT);
        label_nom.setAlignmentX(CENTER_ALIGNMENT);
        nom.setAlignmentX(CENTER_ALIGNMENT);
        label_prenom.setAlignmentX(CENTER_ALIGNMENT);
        prenom.setAlignmentX(CENTER_ALIGNMENT);
        label_naissance.setAlignmentX(CENTER_ALIGNMENT);
        naissance.setAlignmentX(CENTER_ALIGNMENT);
        bouton_ajouter.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        id_pere.setMaximumSize(id_pere.getPreferredSize());
        id_mere.setMaximumSize(id_mere.getPreferredSize());
        nom.setMaximumSize(nom.getPreferredSize());
        prenom.setMaximumSize(prenom.getPreferredSize());
        naissance.setMaximumSize(naissance.getPreferredSize());

        add(Box.createVerticalStrut(25));
        add(label_pere, BorderLayout.WEST);
        add(Box.createVerticalStrut(5));
        add(id_pere, BorderLayout.WEST);
        add(Box.createVerticalStrut(30));
        add(label_mere, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(id_mere, BorderLayout.EAST);
        add(Box.createVerticalStrut(30));
        add(label_nom, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(nom, BorderLayout.EAST);
        add(Box.createVerticalStrut(30));
        add(label_prenom, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(prenom, BorderLayout.EAST);
        add(Box.createVerticalStrut(30));
        add(label_naissance, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(naissance, BorderLayout.EAST);
        add(Box.createVerticalStrut(30));
        add(bouton_ajouter, BorderLayout.SOUTH);
        add(Box.createVerticalStrut(30));
        add(message_erreur, BorderLayout.EAST);
    }
}
