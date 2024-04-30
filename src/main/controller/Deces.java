package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;

import main.exceptions.Mort;
import main.exceptions.PersonneInexistante;
import main.model.Mairie;

public class Deces implements ActionListener {
    private JLabel personne;
    private JTextField id_personne;
    private JLabel label_date;
    private JTextField date;
    private JButton bouton_deces;
    private JLabel message_erreur;
    private Mairie mairie;

    public Deces(JLabel lab_pers, JTextField id_pers, JLabel lab_date,
            JTextField d, JButton bout_deces, JLabel msg_erreur, Mairie m) {
        personne = lab_pers;
        id_personne = id_pers;
        label_date = lab_date;
        date = d;
        bouton_deces = bout_deces;
        message_erreur = msg_erreur;
        mairie = m;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(id_personne.getText());
            LocalDate date_deces = LocalDate.parse(date.getText(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (date_deces.isAfter(LocalDate.now())) {
                message_erreur.setText("Impossible d'enregistrer un décès sans qu'il ait eu lieu");
                return;
            }
            mairie.enregistrer_deces(id, date_deces);
            id_personne.setText("");
            date.setText("");
            message_erreur.setText("");
        } catch (NumberFormatException numerr) {
            message_erreur.setText("L'id n'existe pas");
        } catch (DateTimeParseException date_err) {
            message_erreur.setText("La date n'est pas valide");
        } catch (PersonneInexistante inexistante_err) {
            message_erreur.setText(inexistante_err.to_string());
        } catch (Mort mort_err) {
            message_erreur.setText("Cette personne est déjà morte");
        }
    }
}
