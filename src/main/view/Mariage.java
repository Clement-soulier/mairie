package main.view;

import java.awt.*;
import javax.swing.*;
import main.model.*;

public class Mariage extends JPanel {
    public Mariage(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel partenaire1 = new JLabel("id partenaire 1");
        JTextField id_partenaire1 = new JTextField(20);
        JLabel partenaire2 = new JLabel("id partenaire 2");
        JTextField id_partenaire2 = new JTextField(20);
        JButton bouton_mariage = new JButton("mariage");
        JLabel message_erreur = new JLabel("");

        partenaire1.setAlignmentX(CENTER_ALIGNMENT);
        id_partenaire1.setAlignmentX(CENTER_ALIGNMENT);
        partenaire2.setAlignmentX(CENTER_ALIGNMENT);
        id_partenaire2.setAlignmentX(CENTER_ALIGNMENT);
        bouton_mariage.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        id_partenaire1.setMaximumSize(id_partenaire1.getPreferredSize());
        id_partenaire2.setMaximumSize(id_partenaire2.getPreferredSize());

        add(Box.createVerticalStrut(25));
        add(partenaire1);
        add(Box.createVerticalStrut(5));
        add(id_partenaire1);
        add(Box.createVerticalStrut(30));
        add(partenaire2);
        add(Box.createVerticalStrut(5));
        add(id_partenaire2);
        add(Box.createVerticalStrut(30));
        add(bouton_mariage);
        add(Box.createVerticalStrut(30));
        add(message_erreur);
    }
}
