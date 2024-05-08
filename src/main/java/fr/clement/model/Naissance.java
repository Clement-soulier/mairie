package fr.clement.model;

import java.time.LocalDate;
import java.io.Serializable;

public class Naissance implements Serializable {
    protected LocalDate date;
    protected Mairie mairie;
    protected Citoyen citoyen;
    protected Homme pere;
    protected Femme mere;

    public Naissance(LocalDate d, Mairie m, Citoyen c, Homme p1, Femme p2) {
        date = d;
        mairie = m;
        citoyen = c;
        pere = p1;
        mere = p2;
    }

    public void to_string() {
        System.out.println("pere: " + pere.id + " " + pere.nom + " " + pere.prenom);
        System.out.println("mere: " + mere.id + " " + mere.nom + " " + mere.prenom);
        System.out.println("Enfant: " + citoyen);
    }
}
