package fr.clement.view;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import fr.clement.model.*;
import fr.clement.util.Etat_personne;

public class Liste extends JPanel {
    public Liste(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ArrayList<Etat_personne> donnees = new ArrayList<>();

        for (Etat_personne citoyen : mairie.obtenir_etat_tous_citoyen()) {
            donnees.add(citoyen);
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
