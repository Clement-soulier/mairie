package fr.clement.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import fr.clement.model.*;

public class Main_window extends JFrame {

    private JPanel contentPane = new JPanel();
    private JPanel currentPanel;
    // création menu bar
    private JMenuBar menu = new JMenuBar();
    // Création du menu Fichier
    private JMenu fichierMenu = new JMenu("Fichier");
    private JMenuItem nouveau = new JMenuItem("Nouveau", 'N');
    private JMenuItem ouvrir = new JMenuItem("Ouvrir", 'O');
    private JMenuItem sauver = new JMenuItem("Sauver", 'S');
    private JMenuItem quitter = new JMenuItem("Quitter");
    // Création menu action
    private JMenu actionMenu = new JMenu("Action");
    private JMenuItem etat = new JMenuItem("Etat");
    private JMenuItem liste = new JMenuItem("Liste");
    private JMenuItem mariage = new JMenuItem("Mariage");
    private JMenuItem divorce = new JMenuItem("Divorce");
    private JMenuItem naissance = new JMenuItem("Naissance");
    private JMenuItem deces = new JMenuItem("Décès");
    private JMenuItem ajouter = new JMenuItem("Ajouter");
    private JMenuItem APropos = new JMenuItem("A propos");

    public Main_window(Mairie mairie) {
        super("gestion mairie");
        setSize(900, 600);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        fichierMenu.add(nouveau);
        fichierMenu.add(ouvrir);
        fichierMenu.add(sauver);
        fichierMenu.add(quitter);
        fichierMenu.insertSeparator(1);

        actionMenu.add(etat);
        actionMenu.add(liste);
        actionMenu.add(mariage);
        actionMenu.add(divorce);
        actionMenu.add(naissance);
        actionMenu.add(deces);
        actionMenu.add(ajouter);
        actionMenu.insertSeparator(2);

        add(fichierMenu);
        add(actionMenu);
        menu.add(fichierMenu);
        menu.add(actionMenu);
        menu.add(APropos);
        setJMenuBar(menu);

        // initialisation fenêtre
        contentPane.setLayout(new BorderLayout());
        currentPanel = new fr.clement.view.Liste(mairie);
        contentPane.add(currentPanel, BorderLayout.CENTER);
        add(contentPane);

        fr.clement.controller.Main_window window_controller = new fr.clement.controller.Main_window(this, mairie);
        addWindowListener(window_controller);

        fr.clement.controller.Main_window_content controller = new fr.clement.controller.Main_window_content(
                this, contentPane, currentPanel, menu, fichierMenu, nouveau,
                ouvrir, sauver, quitter, actionMenu, etat, liste, mariage, divorce,
                naissance, deces, ajouter, APropos, mairie);

        nouveau.addActionListener(e -> controller.actionPerformed(e));
        sauver.addActionListener(e -> controller.actionPerformed(e));
        ouvrir.addActionListener(e -> controller.actionPerformed(e));
        quitter.addActionListener(e -> controller.actionPerformed(e));
        etat.addActionListener(e -> controller.actionPerformed(e));
        liste.addActionListener(e -> controller.actionPerformed(e));
        mariage.addActionListener(e -> controller.actionPerformed(e));
        divorce.addActionListener(e -> controller.actionPerformed(e));
        naissance.addActionListener(e -> controller.actionPerformed(e));
        deces.addActionListener(e -> controller.actionPerformed(e));
        ajouter.addActionListener(e -> controller.actionPerformed(e));
        APropos.addActionListener(e -> controller.actionPerformed(e));
        setVisible(true);
    }
}
