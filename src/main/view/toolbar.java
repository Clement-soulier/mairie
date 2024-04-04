package main.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class toolbar extends JMenuBar {

    public toolbar() {
        // Création du menu Fichier
        JMenu fichierMenu = new JMenu("Fichier");
        JMenuItem item = new JMenuItem("Nouveau", 'N');
        fichierMenu.add(item);
        item = new JMenuItem("Ouvrir", 'O');
        fichierMenu.add(item);
        item = new JMenuItem("Sauver", 'S');
        fichierMenu.add(item);
        item = new JMenuItem("Quitter");
        fichierMenu.add(item);
        fichierMenu.insertSeparator(1);

        // Création menu action
        JMenu actionMenu = new JMenu("Action");
        item = new JMenuItem("Etat");
        actionMenu.add(item);
        item = new JMenuItem("Liste");
        actionMenu.add(item);
        item = new JMenuItem("Mariage");
        actionMenu.add(item);
        item = new JMenuItem("Divorce");
        actionMenu.add(item);
        item = new JMenuItem("Naissance");
        actionMenu.add(item);
        item = new JMenuItem("Décès");
        actionMenu.add(item);
        item = new JMenuItem("Ajouter");
        actionMenu.add(item);
        actionMenu.insertSeparator(2);

        add(fichierMenu);
        add(actionMenu);
        add(new JMenuItem("A propos"));
    }

}
