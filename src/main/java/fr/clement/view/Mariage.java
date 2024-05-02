package fr.clement.view;

import java.awt.*;
import javax.swing.*;
import fr.clement.model.*;

public class Mariage extends JPanel {
    private JLabel partenaire1 = new JLabel("id partenaire 1");
    private JTextField id_partenaire1 = new JTextField(20);
    private JLabel partenaire2 = new JLabel("id partenaire 2");
    private JTextField id_partenaire2 = new JTextField(20);
    private JLabel label_date = new JLabel("date (jj/mm/aaaa)");
    private JTextField date = new JTextField(20);
    private JButton bouton_mariage = new JButton("mariage");
    private JLabel message_erreur = new JLabel("");

    public Mariage(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        message_erreur.setForeground(Color.RED);

        fr.clement.controller.Mariage controller = new fr.clement.controller.Mariage(
                partenaire1, id_partenaire1, partenaire2, id_partenaire2,
                label_date, date, bouton_mariage, message_erreur, mairie);

        bouton_mariage.addActionListener(e -> controller.actionPerformed(e));

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
