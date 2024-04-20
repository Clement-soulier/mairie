package main.view;

import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;
import main.model.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Ajouter extends JPanel {
    public Ajouter(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] sexes = { "(Sélection)", "Homme", "Femme" };

        JLabel label_nom = new JLabel("nom");
        JTextField nom = new JTextField(20);
        JLabel label_prenom = new JLabel("prénom");
        JTextField prenom = new JTextField(20);
        JLabel label_sexe = new JLabel("sexe");
        JComboBox<String> choix_sexe = new JComboBox<>(sexes);
        JLabel label_naissance = new JLabel("date de naissance (jj/mm/aaaa)");
        JTextField naissance = new JTextField(20);
        JButton bouton_ajouter = new JButton("Ajouter");
        JLabel message_erreur = new JLabel("");
        message_erreur.setForeground(Color.RED);

        bouton_ajouter.addActionListener(e -> {
            try {
                String nouveau_nom = nom.getText();
                if (nouveau_nom.equals("")) {
                    message_erreur.setText("Veuillez renseigner un nom");
                    return;
                }
                String nouveau_prenom = prenom.getText();
                if (nouveau_prenom.equals("")) {
                    message_erreur.setText("Veuillez renseigner un prénom");
                    return;
                }
                String nouveau_sexe = (String) choix_sexe.getSelectedItem();
                if (nouveau_sexe.equals("(Sélection)")) {
                    message_erreur.setText("Veuillez sélectionner un sexe");
                    return;
                }
                LocalDate nouveau_naissance = LocalDate.parse(naissance.getText(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (nouveau_naissance.isAfter(LocalDate.now())) {
                    message_erreur.setText("La personne doit être né(e) actuellement");
                    return;
                }
                mairie.ajouter_citoyen(nouveau_naissance, nouveau_nom, nouveau_prenom,
                        nouveau_sexe);
                nom.setText("");
                prenom.setText("");
                choix_sexe.setSelectedItem("(Sélection)");
                naissance.setText("");
            } catch (DateTimeParseException date_err) {
                message_erreur.setText("La date n'est pas valide");
            }
        });

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
