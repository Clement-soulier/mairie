package main.view;

import java.awt.*;
import javax.swing.*;
import main.model.*;

public class Liste extends JPanel {
    public Liste(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String[] entetes = { "id", "nom", "prénom", "sexe", "date naissance", "conjoint" };
        Object[][] data = {
                { 1, "juju", "lea", "Femme", "XXXX", "" },
        };

        JTable tableau = new JTable(data, entetes);
        JScrollPane scrollPane = new JScrollPane(tableau);

        add(scrollPane);
    }
}
