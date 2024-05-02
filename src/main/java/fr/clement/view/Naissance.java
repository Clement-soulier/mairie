package fr.clement.view;

import java.awt.*;
import javax.swing.*;
import fr.clement.model.*;

public class Naissance extends JPanel {
    private JLabel label_pere = new JLabel("id père");
    private JTextField id_pere = new JTextField(20);
    private JLabel label_mere = new JLabel("id mère");
    private JTextField id_mere = new JTextField(20);
    private JLabel label_nom = new JLabel("Nom");
    private JTextField nom = new JTextField(20);
    private JLabel label_prenom = new JLabel("Prénom");
    private JTextField prenom = new JTextField(20);
    private JLabel label_sexe = new JLabel("sexe");
    private JComboBox<String> choix_sexe;
    private JLabel label_naissance = new JLabel("Date de naissance (jj/mm/aaaa)");
    private JTextField naissance = new JTextField(20);
    private JButton bouton_naissance = new JButton("Ajouter");
    private JLabel message_erreur = new JLabel("");

    public Naissance(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] sexes = { "(Sélection)", "Homme", "Femme" };

        choix_sexe = new JComboBox<>(sexes);
        message_erreur.setForeground(Color.RED);

        fr.clement.controller.Naissance controller = new fr.clement.controller.Naissance(
                label_pere, id_pere, label_mere, id_mere, label_nom, nom, label_prenom,
                prenom, label_sexe, choix_sexe, label_naissance, naissance, bouton_naissance,
                message_erreur, mairie);

        bouton_naissance.addActionListener(e -> controller.actionPerformed(e));

        label_pere.setAlignmentX(CENTER_ALIGNMENT);
        id_pere.setAlignmentX(CENTER_ALIGNMENT);
        label_mere.setAlignmentX(CENTER_ALIGNMENT);
        id_mere.setAlignmentX(CENTER_ALIGNMENT);
        label_nom.setAlignmentX(CENTER_ALIGNMENT);
        nom.setAlignmentX(CENTER_ALIGNMENT);
        label_prenom.setAlignmentX(CENTER_ALIGNMENT);
        prenom.setAlignmentX(CENTER_ALIGNMENT);
        label_sexe.setAlignmentX(CENTER_ALIGNMENT);
        choix_sexe.setAlignmentX(CENTER_ALIGNMENT);
        label_naissance.setAlignmentX(CENTER_ALIGNMENT);
        naissance.setAlignmentX(CENTER_ALIGNMENT);
        bouton_naissance.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        id_pere.setMaximumSize(id_pere.getPreferredSize());
        id_mere.setMaximumSize(id_mere.getPreferredSize());
        nom.setMaximumSize(nom.getPreferredSize());
        prenom.setMaximumSize(prenom.getPreferredSize());
        choix_sexe.setMaximumSize(choix_sexe.getPreferredSize());
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
        add(label_sexe);
        add(Box.createVerticalStrut(5));
        add(choix_sexe);
        add(Box.createVerticalStrut(30));
        add(label_naissance, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(naissance, BorderLayout.EAST);
        add(Box.createVerticalStrut(30));
        add(bouton_naissance, BorderLayout.SOUTH);
        add(Box.createVerticalStrut(30));
        add(message_erreur, BorderLayout.EAST);
    }
}
