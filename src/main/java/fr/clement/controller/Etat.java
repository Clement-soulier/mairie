package fr.clement.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fr.clement.exceptions.PersonneInexistante;
import fr.clement.model.Mairie;
import fr.clement.util.Etat_personne;

public class Etat implements ActionListener {
    private JFrame window;
    private JPanel panel;
    private JLabel label_personne;
    private JTextField id_personne;
    private JButton etat_bouton;
    private JLabel message_erreur;
    private DefaultTableModel model;
    private JButton chercher_bouton;
    private Mairie mairie;

    public Etat(JFrame arg_window, JPanel arg_panel,
            JLabel arg_label_personne, JTextField arg_id_personne,
            JButton arg_etat_bouton, JLabel arg_message_erreur,
            DefaultTableModel arg_model, JButton arg_chercher_bouton,
            Mairie arg_mairie) {
        window = arg_window;
        panel = arg_panel;
        label_personne = arg_label_personne;
        id_personne = arg_id_personne;
        etat_bouton = arg_etat_bouton;
        message_erreur = arg_message_erreur;
        model = arg_model;
        chercher_bouton = arg_chercher_bouton;
        mairie = arg_mairie;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == etat_bouton) {
            try {
                int id = Integer.parseInt(id_personne.getText());
                Etat_personne c = mairie.obtenir_etat(mairie.trouver_citoyen_par_id(id));
                id_personne.setText("");
                panel.removeAll();

                Object[] row = { c.id, c.nom, c.prenom, c.sexe, c.date_naissance, c.conjoint };
                model.addRow(row);

                JTable tableau = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(tableau);

                panel.add(scrollPane);
                panel.add(Box.createVerticalStrut(30));
                panel.add(chercher_bouton);
                panel.add(Box.createVerticalStrut(25));
                window.revalidate();
                window.repaint();
            } catch (NumberFormatException numerr) {
                message_erreur.setText("L'id n'existe pas");
            } catch (PersonneInexistante inexistante_err) {
                message_erreur.setText(inexistante_err.to_string());
            }
        } else if (e.getSource() == chercher_bouton) {
            panel.removeAll();
            model.removeRow(0);
            panel.add(Box.createVerticalStrut(25));
            panel.add(label_personne);
            panel.add(Box.createVerticalStrut(5));
            panel.add(id_personne);
            panel.add(Box.createVerticalStrut(20));
            panel.add(etat_bouton);
            panel.add(Box.createVerticalStrut(25));
            panel.add(message_erreur);
            panel.add(Box.createVerticalStrut(20));
            window.revalidate();
            window.repaint();
        }
    }
}