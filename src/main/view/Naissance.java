package main.view;

import java.awt.*;
import java.time.LocalDate;

import javax.swing.*;

import main.exceptions.MauvaisSexe;
import main.exceptions.Mort;
import main.exceptions.PersonneInexistante;
import main.model.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Naissance extends JPanel {
    public Naissance(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] sexes = { "(Sélection)", "Homme", "Femme" };

        JLabel label_pere = new JLabel("id père");
        JTextField id_pere = new JTextField(20);
        JLabel label_mere = new JLabel("id mère");
        JTextField id_mere = new JTextField(20);
        JLabel label_nom = new JLabel("Nom");
        JTextField nom = new JTextField(20);
        JLabel label_prenom = new JLabel("Prénom");
        JTextField prenom = new JTextField(20);
        JLabel label_sexe = new JLabel("sexe");
        JComboBox<String> choix_sexe = new JComboBox<>(sexes);
        JLabel label_naissance = new JLabel("Date de naissance");
        JTextField naissance = new JTextField(20);
        JButton bouton_naissance = new JButton("Ajouter");
        JLabel message_erreur = new JLabel("");
        message_erreur.setForeground(Color.RED);

        bouton_naissance.addActionListener(e -> {
            try {
                int pere = Integer.parseInt(id_pere.getText());
                int mere = Integer.parseInt(id_mere.getText());
                if (pere == mere) {
                    message_erreur.setText("Les deux parents doivent être deux personnes différentes");
                    return;
                }
                String naissance_nom = nom.getText();
                if (naissance_nom.equals("")) {
                    message_erreur.setText("Veuillez renseigner un nom");
                    return;
                }
                String naissance_prenom = prenom.getText();
                if (naissance_prenom.equals("")) {
                    message_erreur.setText("Veuillez renseigner un prénom");
                    return;
                }
                String naissance_sexe = (String) choix_sexe.getSelectedItem();
                if (naissance_sexe.equals("(Sélection)")) {
                    message_erreur.setText("Veuillez sélectionner un sexe");
                    return;
                }
                LocalDate naissance_naissance = LocalDate.parse(naissance.getText(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (naissance_naissance.isAfter(LocalDate.now())) {
                    message_erreur.setText("La personne doit être né(e) actuellement");
                    return;
                }
                mairie.enregistrer_naissance(pere, mere, naissance_naissance, naissance_nom, naissance_prenom,
                        naissance_sexe);
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
        });

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
