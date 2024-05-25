package fr.clement.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import fr.clement.model.*;

public class Etat extends JFrame {
    private JPanel panel = new JPanel();
    private JLabel label_personne = new JLabel("id personne");
    private JTextField id_personne = new JTextField(20);
    private JButton etat_bouton = new JButton("Obtenir Etat");
    private JLabel message_erreur = new JLabel("");
    private DefaultTableModel model = new DefaultTableModel();
    private JButton chercher_bouton = new JButton("Chercher une autre personne");

    public Etat(
            Mairie mairie) {
        super("Etat");
        setSize(400, 200);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        model.addColumn("id");
        model.addColumn("nom");
        model.addColumn("prénom");
        model.addColumn("sexe");
        model.addColumn("date naissance");
        model.addColumn("conjoint");

        message_erreur.setForeground(Color.RED);

        fr.clement.controller.Etat controller = new fr.clement.controller.Etat(
                this, panel, label_personne, id_personne,
                etat_bouton, message_erreur, model, chercher_bouton,
                mairie);

        etat_bouton.addActionListener(e -> controller.actionPerformed(e));
        chercher_bouton.addActionListener(e -> controller.actionPerformed(e));
        id_personne.setMaximumSize(id_personne.getPreferredSize());

        label_personne.setAlignmentX(CENTER_ALIGNMENT);
        id_personne.setAlignmentX(CENTER_ALIGNMENT);
        etat_bouton.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);
        chercher_bouton.setAlignmentX(CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(25));
        panel.add(label_personne);
        panel.add(Box.createVerticalStrut(5));
        panel.add(id_personne);
        panel.add(Box.createVerticalStrut(20));
        panel.add(etat_bouton);
        panel.add(Box.createVerticalStrut(25));
        panel.add(message_erreur);
        panel.add(Box.createVerticalStrut(20));

        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
