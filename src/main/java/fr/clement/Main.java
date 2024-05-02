package fr.clement;

import javax.swing.*;
import fr.clement.model.*;

public class Main {

    public static void main(String[] args) {
        Mairie m = new Mairie("Feurs");
        JFrame frame = new fr.clement.view.Main_window(m);
        frame.setVisible(true);
    }

}
