package main.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import main.model.*;

public class Main_window extends JFrame {

    private JPanel contentPane;
    private JPanel currentPanel;

    public Main_window(Mairie mairie) {
        super("gestion mairie");
        setSize(900, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);

        // création menu bar
        JMenuBar menu = new JMenuBar();
        // Création du menu Fichier
        JMenu fichierMenu = new JMenu("Fichier");
        JMenuItem nouveau = new JMenuItem("Nouveau", 'N');
        fichierMenu.add(nouveau);
        JMenuItem ouvrir = new JMenuItem("Ouvrir", 'O');
        fichierMenu.add(ouvrir);
        JMenuItem sauver = new JMenuItem("Sauver", 'S');
        fichierMenu.add(sauver);
        JMenuItem quitter = new JMenuItem("Quitter");
        fichierMenu.add(quitter);
        fichierMenu.insertSeparator(1);

        // Création menu action
        JMenu actionMenu = new JMenu("Action");
        JMenuItem etat = new JMenuItem("Etat");
        actionMenu.add(etat);
        JMenuItem liste = new JMenuItem("Liste");
        actionMenu.add(liste);
        JMenuItem mariage = new JMenuItem("Mariage");
        actionMenu.add(mariage);
        JMenuItem divorce = new JMenuItem("Divorce");
        actionMenu.add(divorce);
        JMenuItem naissance = new JMenuItem("Naissance");
        actionMenu.add(naissance);
        JMenuItem deces = new JMenuItem("Décès");
        actionMenu.add(deces);
        JMenuItem ajouter = new JMenuItem("Ajouter");
        actionMenu.add(ajouter);
        actionMenu.insertSeparator(2);

        add(fichierMenu);
        add(actionMenu);
        JMenuItem APropos = new JMenuItem("A propos");
        menu.add(fichierMenu);
        menu.add(actionMenu);
        menu.add(APropos);
        setJMenuBar(menu);

        // initialisation fenêtre
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        currentPanel = new main.view.Liste(mairie);
        contentPane.add(currentPanel, BorderLayout.CENTER);
        add(contentPane);

        etat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new main.view.Etat(mairie);
            }
        });

        liste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPanel);
                currentPanel = new main.view.Liste(mairie);
                contentPane.add(currentPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        mariage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPanel);
                currentPanel = new main.view.Mariage(mairie);
                contentPane.add(currentPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        divorce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPanel);
                currentPanel = new main.view.Divorce(mairie);
                contentPane.add(currentPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        deces.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPanel);
                currentPanel = new main.view.Deces(mairie);
                contentPane.add(currentPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPanel);
                currentPanel = new main.view.Ajouter(mairie);
                contentPane.add(currentPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        naissance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.remove(currentPanel);
                currentPanel = new main.view.Naissance(mairie);
                contentPane.add(currentPanel, BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        APropos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new main.view.APropos();
            }
        });

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(l);
        setVisible(true);
    }
}
