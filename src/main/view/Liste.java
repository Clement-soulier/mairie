package main.view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.model.*;
import main.util.Etat_personne;

public class Liste extends JPanel {
    public Liste(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ArrayList<Etat_personne> donnees = new ArrayList<>();

        for (Citoyen citoyen : mairie.citoyen) {
            donnees.add(mairie.obtenir_etat(citoyen));
        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nom");
        model.addColumn("prénom");
        model.addColumn("sexe");
        model.addColumn("date naissance");
        model.addColumn("conjoint");

        for (Etat_personne etat : donnees) {
            Object[] row = { etat.id, etat.nom, etat.prenom, etat.sexe, etat.date_naissance, etat.conjoint };
            model.addRow(row);
        }

        JTable tableau = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableau);

        add(scrollPane);
    }
}
