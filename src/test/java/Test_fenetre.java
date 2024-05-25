import javax.swing.*;
import fr.clement.model.*;
import java.time.LocalDate;

public class Test_fenetre {

    public static void main(String[] args) {
        Mairie m = new Mairie("Feurs");
        LocalDate date = LocalDate.now();

        // ajouter Citoyen sans parent
        m.ajouter_citoyen(date, "Marteau", "Bertrand", "Homme");
        m.ajouter_citoyen(date, "Marteau", "Sophie", "Femme");
        m.ajouter_citoyen(date, "Malicieu", "Robert", "Homme");
        m.ajouter_citoyen(date, "Delaplace", "Margot", "Femme");
        m.ajouter_citoyen(date, "Bricoleur", "Bob", "Homme");
        m.ajouter_citoyen(date, "Duchamps", "Albertine", "Femme");

        JFrame frame = new fr.clement.view.Main_window(m);
        frame.setVisible(true);
    }

}
