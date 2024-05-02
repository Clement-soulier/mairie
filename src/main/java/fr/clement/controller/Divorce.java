package fr.clement.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import fr.clement.exceptions.Mort;
import fr.clement.exceptions.PasMarie;
import fr.clement.exceptions.PersonneInexistante;
import fr.clement.model.Mairie;

public class Divorce implements ActionListener {
    private JLabel personne;
    private JTextField id_personne;
    private JLabel label_date;
    private JTextField date;
    private JButton bouton_divorce;
    private JLabel message_erreur;
    private Mairie mairie;

    public Divorce(JLabel lab_pers, JTextField id_pers, JLabel lab_date,
            JTextField d, JButton bout_divorce, JLabel msg_erreur, Mairie m) {
        personne = lab_pers;
        id_personne = id_pers;
        label_date = lab_date;
        date = d;
        bouton_divorce = bout_divorce;
        message_erreur = msg_erreur;
        mairie = m;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(id_personne.getText());
            LocalDate date_divorce = LocalDate.parse(date.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            mairie.enregistrer_divorce(id, date_divorce);
            id_personne.setText("");
            date.setText("");
            message_erreur.setForeground(Color.GREEN);
            message_erreur.setText("Le divorce a bien été déclaré");
        } catch (NumberFormatException numerr) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText("L'id n'existe pas");
        } catch (PersonneInexistante inexistante_err) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText(inexistante_err.to_string());
        } catch (PasMarie marie_err) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText(marie_err.to_string());
        } catch (Mort mort_err) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText(mort_err.to_string());
        }
    }
}
