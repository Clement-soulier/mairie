package fr.clement.controller;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import fr.clement.model.Mairie;

public class Ajouter implements ActionListener {
    private JLabel label_nom;
    private JTextField nom;
    private JLabel label_prenom;
    private JTextField prenom;
    private JLabel label_sexe;
    private JComboBox<String> choix_sexe;
    private JLabel label_naissance;
    private JTextField naissance;
    private JButton bouton_ajouter;
    private JLabel message_erreur;
    private Mairie mairie;

    public Ajouter(JLabel lab_nom, JTextField n, JLabel lab_prenom,
            JTextField p, JLabel lab_sexe, JComboBox<String> c_sexe,
            JLabel lab_naissance, JTextField naiss, JButton bout_ajouter,
            JLabel msg_erreur, Mairie m) {
        label_nom = lab_nom;
        nom = n;
        label_prenom = lab_prenom;
        prenom = p;
        label_sexe = lab_sexe;
        choix_sexe = c_sexe;
        label_naissance = lab_naissance;
        naissance = naiss;
        bouton_ajouter = bout_ajouter;
        message_erreur = msg_erreur;
        mairie = m;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (nom.getText().equals("")) {
                message_erreur.setText("Veuillez renseigner un nom");
                return;
            }
            if (prenom.getText().equals("")) {
                message_erreur.setText("Veuillez renseigner un prénom");
                return;
            }
            if (choix_sexe.getSelectedItem().equals("(Sélection)")) {
                message_erreur.setText("Veuillez sélectionner un sexe");
                return;
            }
            LocalDate date_naissance = LocalDate.parse(naissance.getText(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (date_naissance.isAfter(LocalDate.now())) {
                message_erreur.setText("La personne doit être né(e) actuellement");
                return;
            }
            mairie.ajouter_citoyen(date_naissance, nom.getText(), prenom.getText(),
                    choix_sexe.getSelectedItem().toString());
            nom.setText("");
            prenom.setText("");
            choix_sexe.setSelectedItem("(Sélection)");
            naissance.setText("");
            message_erreur.setForeground(Color.GREEN);
            message_erreur.setText("Citoyen ajouté avec succès");
        } catch (DateTimeParseException date_err) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText("La date n'est pas valide");
        }
    }
}
