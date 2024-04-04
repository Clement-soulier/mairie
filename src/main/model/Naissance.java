package main.model;

import java.time.LocalDate;

public class Naissance {
    protected LocalDate date;
    public Mairie mairie;
    public Citoyen citoyen;
    public Homme pere;
    public Femme mere;

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
