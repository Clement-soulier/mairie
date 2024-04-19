package main.view;

import java.awt.*;
import javax.swing.*;
import main.model.*;

public class Divorce extends JPanel {
    public Divorce(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel personne = new JLabel("id personne");
        JTextField id_personne = new JTextField(20);
        JButton bouton_divorce = new JButton("divorce");
        JLabel message_erreur = new JLabel("");

        personne.setAlignmentX(CENTER_ALIGNMENT);
        id_personne.setAlignmentX(CENTER_ALIGNMENT);
        bouton_divorce.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        id_personne.setMaximumSize(id_personne.getPreferredSize());

        add(Box.createVerticalStrut(25));
        add(personne, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(id_personne, BorderLayout.CENTER);
        add(Box.createVerticalStrut(30));
        add(bouton_divorce, BorderLayout.SOUTH);
        add(Box.createVerticalStrut(30));
        add(message_erreur, BorderLayout.EAST);
    }
}
