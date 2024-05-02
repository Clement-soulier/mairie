package fr.clement.view;

import java.awt.*;
import javax.swing.*;
import fr.clement.model.*;

public class Deces extends JPanel {
    private JLabel personne = new JLabel("id personne");
    private JTextField id_personne = new JTextField(20);
    private JLabel label_date = new JLabel("date (jj/mm/aaaa)");
    private JTextField date = new JTextField(20);
    private JButton bouton_deces = new JButton("déclarer décès");
    private JLabel message_erreur = new JLabel("");

    public Deces(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        message_erreur.setForeground(Color.RED);

        fr.clement.controller.Deces controller = new fr.clement.controller.Deces(personne,
                id_personne, label_date, date, bouton_deces, message_erreur, mairie);

        bouton_deces.addActionListener(e -> controller.actionPerformed(e));

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
