package main.controller;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import main.exceptions.MauvaisSexe;
import main.exceptions.Mort;
import main.exceptions.PersonneInexistante;
import main.model.Mairie;

public class Naissance implements ActionListener {
    private JLabel label_pere;
    private JTextField id_pere;
    private JLabel label_mere;
    private JTextField id_mere;
    private JLabel label_nom;
    private JTextField nom;
    private JLabel label_prenom;
    private JTextField prenom;
    private JLabel label_sexe;
    private JComboBox<String> choix_sexe;
    private JLabel label_naissance;
    private JTextField naissance;
    private JButton bouton_naissance;
    private JLabel message_erreur;
    private Mairie mairie;

    public Naissance(JLabel lab_pere, JTextField id_p, JLabel lab_mere,
            JTextField id_m, JLabel lab_nom, JTextField n, JLabel lab_prenom,
            JTextField p, JLabel lab_sexe, JComboBox<String> c_sexe, JLabel lab_naiss,
            JTextField naiss, JButton bout_naissance, JLabel msg_erreur, Mairie m) {
        label_pere = lab_pere;
        id_pere = id_p;
        label_mere = lab_mere;
        id_mere = id_m;
        label_nom = lab_nom;
        nom = n;
        label_prenom = lab_prenom;
        prenom = p;
        label_sexe = lab_sexe;
        choix_sexe = c_sexe;
        label_naissance = lab_naiss;
        naissance = naiss;
        bouton_naissance = bout_naissance;
        mairie = m;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int pere = Integer.parseInt(id_pere.getText());
            int mere = Integer.parseInt(id_mere.getText());
            if (pere == mere) {
                message_erreur.setText("Les deux parents doivent être deux personnes différentes");
                return;
            }
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
            LocalDate date = LocalDate.parse(naissance.getText(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (date.isAfter(LocalDate.now())) {
                message_erreur.setText("La personne doit être né(e) actuellement");
                return;
            }
            mairie.enregistrer_naissance(pere, mere, date, nom.getText(), prenom.getText(),
                    choix_sexe.getSelectedItem().toString());
            id_pere.setText("");
            id_mere.setText("");
            nom.setText("");
            prenom.setText("");
            choix_sexe.setSelectedItem("(Sélection)");
            naissance.setText("");
            message_erreur.setText("");
        } catch (NumberFormatException numerr) {
            message_erreur.setText("L'un des id n'existe pas");
        } catch (DateTimeParseException date_err) {
            message_erreur.setText("La date n'est pas valide");
        } catch (PersonneInexistante inexistante_err) {
            message_erreur.setText(inexistante_err.to_string());
        } catch (Mort mort_err) {
            message_erreur.setText(mort_err.to_string());
        } catch (MauvaisSexe sexe_err) {
            message_erreur.setText(sexe_err.to_string());
        }
    }
}
