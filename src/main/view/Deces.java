package main.view;

import java.awt.*;
import javax.swing.*;

import main.exceptions.PersonneInexistante;
import main.exceptions.Mort;
import main.model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deces extends JPanel {
    public Deces(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel personne = new JLabel("id personne");
        JTextField id_personne = new JTextField(20);
        JLabel label_date = new JLabel("date (jj/mm/aaaa)");
        JTextField date = new JTextField(20);
        JButton bouton_deces = new JButton("déclarer décès");
        JLabel message_erreur = new JLabel("");
        message_erreur.setForeground(Color.RED);

        bouton_deces.addActionListener(e -> {
            try {
                int id = Integer.parseInt(id_personne.getText());
                LocalDate date_deces = LocalDate.parse(date.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
        });

        personne.setAlignmentX(CENTER_ALIGNMENT);
        id_personne.setAlignmentX(CENTER_ALIGNMENT);
        label_date.setAlignmentX(CENTER_ALIGNMENT);
        date.setAlignmentX(CENTER_ALIGNMENT);
        bouton_deces.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        id_personne.setMaximumSize(id_personne.getPreferredSize());
        date.setMaximumSize(date.getPreferredSize());

        add(Box.createVerticalStrut(25));
        add(personne, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(id_personne, BorderLayout.CENTER);
        add(Box.createVerticalStrut(30));
        add(label_date);
        add(Box.createVerticalStrut(5));
        add(date);
        add(Box.createVerticalStrut(30));
        add(bouton_deces, BorderLayout.SOUTH);
        add(Box.createVerticalStrut(30));
        add(message_erreur, BorderLayout.EAST);
    }
}
