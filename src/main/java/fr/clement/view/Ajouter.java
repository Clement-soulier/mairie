package fr.clement.view;

import fr.clement.model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class Ajouter extends JPanel {
    private JLabel label_nom = new JLabel("nom");
    private JTextField nom = new JTextField(20);
    private JLabel label_prenom = new JLabel("prénom");
    private JTextField prenom = new JTextField(20);
    private JLabel label_sexe = new JLabel("sexe");
    private JComboBox<String> choix_sexe;
    private JLabel label_naissance = new JLabel("date de naissance (jj/mm/aaaa)");
    private JTextField naissance = new JTextField(20);
    private JButton bouton_ajouter = new JButton("Ajouter");
    private JLabel message_erreur = new JLabel("");

    public Ajouter(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] sexes = { "(Sélection)", "Homme", "Femme" };

        choix_sexe = new JComboBox<>(sexes);
        message_erreur.setForeground(Color.RED);

        fr.clement.controller.Ajouter controller = new fr.clement.controller.Ajouter(label_nom,
                nom, label_prenom, prenom, label_sexe, choix_sexe, label_naissance,
                naissance, bouton_ajouter, message_erreur, mairie);

        bouton_ajouter.addActionListener(e -> controller.actionPerformed(e));

        label_nom.setAlignmentX(CENTER_ALIGNMENT);
        nom.setAlignmentX(CENTER_ALIGNMENT);
        label_prenom.setAlignmentX(CENTER_ALIGNMENT);
        prenom.setAlignmentX(CENTER_ALIGNMENT);
        label_sexe.setAlignmentX(CENTER_ALIGNMENT);
        choix_sexe.setAlignmentX(CENTER_ALIGNMENT);
        label_naissance.setAlignmentX(CENTER_ALIGNMENT);
        naissance.setAlignmentX(CENTER_ALIGNMENT);
        bouton_ajouter.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        nom.setMaximumSize(nom.getPreferredSize());
        prenom.setMaximumSize(prenom.getPreferredSize());
        choix_sexe.setMaximumSize(choix_sexe.getPreferredSize());
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
        add(label_sexe);
        add(Box.createVerticalStrut(5));
        add(choix_sexe);
        add(Box.createVerticalStrut(30));
        add(label_naissance);
        add(Box.createVerticalStrut(5));
        add(naissance);
        add(Box.createVerticalStrut(30));
        add(bouton_ajouter, BorderLayout.SOUTH);
        add(Box.createVerticalStrut(30));
        add(message_erreur);
        add(Box.createVerticalStrut(30));
    }
}
