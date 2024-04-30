package main.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import main.model.Mairie;

public class Main_window implements ActionListener {
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

    public Main_window(JFrame arg_window, JPanel arg_content_pane, JPanel arg_currentPanel,
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
            new main.view.Etat(mairie);
        } else if (e.getSource() == liste) {
            contentPane.remove(currentPanel);
            currentPanel = new main.view.Liste(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == mariage) {
            contentPane.remove(currentPanel);
            currentPanel = new main.view.Mariage(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == divorce) {
            contentPane.remove(currentPanel);
            currentPanel = new main.view.Divorce(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == deces) {
            contentPane.remove(currentPanel);
            currentPanel = new main.view.Deces(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == ajouter) {
            contentPane.remove(currentPanel);
            currentPanel = new main.view.Ajouter(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == naissance) {
            contentPane.remove(currentPanel);
            currentPanel = new main.view.Naissance(mairie);
            contentPane.add(currentPanel, BorderLayout.CENTER);
            window.revalidate();
            window.repaint();
        } else if (e.getSource() == APropos) {
            new main.view.APropos();
        }
    }
}
