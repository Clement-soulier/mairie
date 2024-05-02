package fr.clement.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.clement.model.Mairie;

public class Main_window implements WindowListener {
    JFrame window;
    Mairie mairie;

    public Main_window(JFrame arg_window, Mairie arg_mairie) {
        window = arg_window;
        mairie = arg_mairie;
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {
        int choix = JOptionPane.showConfirmDialog(null, "Voulez vous enregistrer avant de quitter ?");
        if (choix == JOptionPane.YES_OPTION) {
            JFileChooser fileChooser = new JFileChooser();
            int resultat = fileChooser.showSaveDialog(null);
            if (resultat == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    FileOutputStream fichierSortie = new FileOutputStream(file);
                    ObjectOutputStream fluxObjetSortie = new ObjectOutputStream(fichierSortie);
                    fluxObjetSortie.writeObject(mairie);
                    fluxObjetSortie.close();
                    fichierSortie.close();
                    JOptionPane.showMessageDialog(null, "Fichier enregistrer avec succès");
                    System.exit(0);
                } catch (IOException err) {
                    JOptionPane.showMessageDialog(null, "Echec lors de l'enregistrement du fichier");
                }
            }
        } else if (choix == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else {
            return;
        }
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}
