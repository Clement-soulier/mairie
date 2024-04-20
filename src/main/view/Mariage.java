package main.view;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.*;

import main.exceptions.DejaMarie;
import main.exceptions.Mort;
import main.exceptions.PersonneInexistante;
import main.model.*;

public class Mariage extends JPanel {
    public Mariage(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel partenaire1 = new JLabel("id partenaire 1");
        JTextField id_partenaire1 = new JTextField(20);
        JLabel partenaire2 = new JLabel("id partenaire 2");
        JTextField id_partenaire2 = new JTextField(20);
        JLabel label_date = new JLabel("date (jj/mm/aaaa)");
        JTextField date = new JTextField(20);
        JButton bouton_mariage = new JButton("mariage");
        JLabel message_erreur = new JLabel("");
        message_erreur.setForeground(Color.RED);

        bouton_mariage.addActionListener(e -> {
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
                message_erreur.setText("");
                id_partenaire1.setText("");
                id_partenaire2.setText("");
                date.setText("");
            } catch (NumberFormatException numerr) {
                message_erreur.setText("L'un des id n'existe pas");
            } catch (DateTimeParseException date_err) {
                message_erreur.setText("La date n'est pas valide");
            } catch (DejaMarie marie_err) {
                message_erreur.setText(marie_err.to_string());
            } catch (PersonneInexistante inexistante_err) {
                message_erreur.setText(inexistante_err.to_string());
            } catch (Mort mort_err) {
                message_erreur.setText(mort_err.to_string());
            }
        });

        partenaire1.setAlignmentX(CENTER_ALIGNMENT);
        id_partenaire1.setAlignmentX(CENTER_ALIGNMENT);
        partenaire2.setAlignmentX(CENTER_ALIGNMENT);
        id_partenaire2.setAlignmentX(CENTER_ALIGNMENT);
        label_date.setAlignmentX(CENTER_ALIGNMENT);
        date.setAlignmentX(CENTER_ALIGNMENT);
        bouton_mariage.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        id_partenaire1.setMaximumSize(id_partenaire1.getPreferredSize());
        id_partenaire2.setMaximumSize(id_partenaire2.getPreferredSize());
        date.setMaximumSize(date.getPreferredSize());

        add(Box.createVerticalStrut(25));
        add(partenaire1);
        add(Box.createVerticalStrut(5));
        add(id_partenaire1);
        add(Box.createVerticalStrut(30));
        add(partenaire2);
        add(Box.createVerticalStrut(5));
        add(id_partenaire2);
        add(Box.createVerticalStrut(30));
        add(label_date);
        add(Box.createVerticalStrut(5));
        add(date);
        add(Box.createVerticalStrut(30));
        add(bouton_mariage);
        add(Box.createVerticalStrut(30));
        add(message_erreur);
        add(Box.createVerticalStrut(30));
    }
}
