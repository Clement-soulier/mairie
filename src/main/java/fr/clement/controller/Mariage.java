package fr.clement.controller;

import javax.swing.*;

import fr.clement.exceptions.DejaMarie;
import fr.clement.exceptions.Mort;
import fr.clement.exceptions.PersonneInexistante;
import fr.clement.model.Mairie;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mariage implements ActionListener {
    private JLabel partenaire1;
    private JTextField id_partenaire1;
    private JLabel partenaire2;
    private JTextField id_partenaire2;
    private JLabel label_date;
    private JTextField date;
    private JButton bouton_mariage;
    private JLabel message_erreur;
    private Mairie mairie;

    public Mariage(JLabel part1, JTextField id_part1, JLabel part2,
            JTextField id_part2, JLabel lab_date, JTextField d, JButton bout_mariage,
            JLabel msg_erreur, Mairie m) {
        partenaire1 = part1;
        id_partenaire1 = id_part1;
        partenaire2 = part2;
        id_partenaire2 = id_part2;
        label_date = lab_date;
        date = d;
        bouton_mariage = bout_mariage;
        message_erreur = msg_erreur;
        mairie = m;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int id1 = Integer.parseInt(id_partenaire1.getText());
            int id2 = Integer.parseInt(id_partenaire2.getText());
            if (id1 == id2) {
                message_erreur.setText("Une personne ne peut pas se marier seul(e)");
                return;
            }
            LocalDate date_mariage = LocalDate.parse(date.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (date_mariage.isAfter(LocalDate.now())) {
                message_erreur.setText("Veuillez enregistrer le mariage une fois qu'il sera effectué");
                return;
            }
            mairie.enregistrer_mariage(id1, id2, date_mariage);
            message_erreur.setForeground(Color.GREEN);
            message_erreur.setText("La mariage a bien été enregistré");
            id_partenaire1.setText("");
            id_partenaire2.setText("");
            date.setText("");
        } catch (NumberFormatException numerr) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText("L'un des id n'existe pas");
        } catch (DateTimeParseException date_err) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText("La date n'est pas valide");
        } catch (DejaMarie marie_err) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText(marie_err.to_string());
        } catch (PersonneInexistante inexistante_err) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText(inexistante_err.to_string());
        } catch (Mort mort_err) {
            message_erreur.setForeground(Color.RED);
            message_erreur.setText(mort_err.to_string());
        }
    }
}
