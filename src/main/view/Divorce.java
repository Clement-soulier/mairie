package main.view;

import java.awt.*;

import main.exceptions.Mort;
import main.exceptions.PasMarie;
import main.exceptions.PersonneInexistante;

import javax.swing.*;
import main.model.*;

public class Divorce extends JPanel {
    public Divorce(Mairie mairie) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel personne = new JLabel("id personne");
        JTextField id_personne = new JTextField(20);
        JButton bouton_divorce = new JButton("divorce");
        JLabel message_erreur = new JLabel("");
        message_erreur.setForeground(Color.RED);

        bouton_divorce.addActionListener(e -> {
            try {
                int id = Integer.parseInt(id_personne.getText());
                mairie.enregistrer_divorce(id);
                id_personne.setText("");
                message_erreur.setText("");
            } catch (NumberFormatException numerr) {
                message_erreur.setText("L'id n'existe pas");
            } catch (PersonneInexistante inexistante_err) {
                message_erreur.setText(inexistante_err.to_string());
            } catch (PasMarie marie_err) {
                message_erreur.setText(marie_err.to_string());
            } catch (Mort mort_err) {
                message_erreur.setText(mort_err.to_string());
            }
        });

        personne.setAlignmentX(CENTER_ALIGNMENT);
        id_personne.setAlignmentX(CENTER_ALIGNMENT);
        bouton_divorce.setAlignmentX(CENTER_ALIGNMENT);
        message_erreur.setAlignmentX(CENTER_ALIGNMENT);

        id_personne.setMaximumSize(id_personne.getPreferredSize());

        add(Box.createVerticalStrut(25));
        add(personne, BorderLayout.CENTER);
        add(Box.createVerticalStrut(5));
        add(id_personne, BorderLayout.CENTER);
        add(Box.createVerticalStrut(30));
        add(bouton_divorce, BorderLayout.SOUTH);
        add(Box.createVerticalStrut(30));
        add(message_erreur, BorderLayout.EAST);
        add(Box.createVerticalStrut(30));
    }
}
