package fr.clement.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import java.awt.*;
import fr.clement.model.Mairie;

public class Main_window_content implements ActionListener {
    private JFrame window;
    private JPanel contentPane;
    private JPanel currentPanel;
    private JMenuBar menu;
    private JMenu fichierMenu;
    private JMenuItem nouveau;
    private JMenuItem ouvrir;
    private JMenuItem sauver;
    private JMenuItem quitter;
    private JMenu actionMenu;
    private JMenuItem etat;
    private JMenuItem liste;
    private JMenuItem mariage;
    private JMenuItem divorce;
    private JMenuItem naissance;
    private JMenuItem deces;
    private JMenuItem ajouter;
    private JMenuItem APropos;
    private Mairie mairie;

    public Main_window_content(JFrame arg_window, JPanel arg_content_pane, JPanel arg_currentPanel,
            JMenuBar arg_menu, JMenu arg_fichierMenu, JMenuItem arg_nouveau,
            JMenuItem arg_ouvrir, JMenuItem arg_sauver, JMenuItem arg_quitter,
            JMenu arg_actionMenu, JMenuItem arg_etat, JMenuItem arg_liste,
            JMenuItem arg_mariage, JMenuItem arg_divorce, JMenuItem arg_naissance,
            JMenuItem arg_deces, JMenuItem arg_ajouter, JMenuItem arg_APropos, Mairie arg_mairie) {
        window = arg_window;
        contentPane = arg_content_pane;
        currentPanel = arg_currentPanel;
        menu = arg_menu;
        fichierMenu = arg_fichierMenu;
        nouveau = arg_nouveau;
        ouvrir = arg_ouvrir;
        sauver = arg_sauver;
        quitter = arg_quitter;
        actionMenu = arg_actionMenu;
        etat = arg_etat;
        liste = arg_liste;
        mariage = arg_mariage;
        divorce = arg_divorce;
        naissance = arg_naissance;
        deces = arg_deces;
        ajouter = arg_ajouter;
        APropos = arg_APropos;
        mairie = arg_mairie;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == etat) {
            new fr.clement.view.Etat(mairie);
        } else if (e.getSource() == liste) {
            contentPane.remove(currentPanel);
            currentPanel = new fr.clement.view.Liste(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == mariage) {
            contentPane.remove(currentPanel);
            currentPanel = new fr.clement.view.Mariage(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == divorce) {
            contentPane.remove(currentPanel);
            currentPanel = new fr.clement.view.Divorce(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == deces) {
            contentPane.remove(currentPanel);
            currentPanel = new fr.clement.view.Deces(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == ajouter) {
            contentPane.remove(currentPanel);
            currentPanel = new fr.clement.view.Ajouter(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == naissance) {
            contentPane.remove(currentPanel);
            currentPanel = new fr.clement.view.Naissance(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == APropos) {
            JOptionPane.showMessageDialog(null, "Clément Soulier 2024");
        } else if (e.getSource() == nouveau) {
            int confirmation = JOptionPane.showConfirmDialog(null,
                    "Attention toute modification non enregistré sera perdue. Souhaitez vous continuer ?");
            if (confirmation == JOptionPane.YES_OPTION) {
                String nouveau_nom = JOptionPane.showInputDialog(null,
                        "Veuillez entrez le nom de la ville dont vous allez gérer la mairie");
                mairie = new Mairie(nouveau_nom);
                contentPane.remove(currentPanel);
                currentPanel = new fr.clement.view.Liste(mairie);
                contentPane.add(currentPanel, BorderLayout.CENTER);
                window.revalidate();
                window.repaint();
            }
        } else if (e.getSource() == sauver) {
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
                    contentPane.remove(currentPanel);
                    currentPanel = new fr.clement.view.Liste(mairie);
                    contentPane.add(currentPanel, BorderLayout.CENTER);
                    window.revalidate();
                    window.repaint();
                    JOptionPane.showMessageDialog(null, "Fichier enregistrer avec succès");
                } catch (IOException err) {
                    JOptionPane.showMessageDialog(null, "Echec lors de l'enregistrement du fichier");
                    System.out.println(err.getMessage());
                }

            }
        } else if (e.getSource() == ouvrir) {
            JOptionPane.showMessageDialog(null,
                    "Attention si vous ouvrez un fichier toute modification non enregistrée sera perdue");
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    FileInputStream fichierEntree = new FileInputStream(file);
                    ObjectInputStream fluxObjectEntree = new ObjectInputStream(fichierEntree);
                    Mairie objectDeserialisee = (Mairie) fluxObjectEntree.readObject();
                    fluxObjectEntree.close();
                    fichierEntree.close();
                    mairie = objectDeserialisee;
                    contentPane.remove(currentPanel);
                    currentPanel = new fr.clement.view.Liste(mairie);
                    contentPane.add(currentPanel, BorderLayout.CENTER);
                    window.revalidate();
                    window.repaint();
                } catch (IOException | ClassNotFoundException error) {
                    JOptionPane.showMessageDialog(null, "Echec de l'ouverture du fichier");
                }
            }
        } else if (e.getSource() == quitter) {
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
            }
        }
    }
}
