package fr.clement.model;

import java.time.LocalDate;
import java.io.Serializable;

public class Mariage implements Serializable {
    protected LocalDate date;
    protected Mairie mairie;
    protected Citoyen partenaire1;
    protected Citoyen partenaire2;
    protected Divorce divorce;

    public Mariage(LocalDate d, Mairie m, Citoyen p1, Citoyen p2) {
        date = d;
        mairie = m;
        partenaire1 = p1;
        partenaire2 = p2;
        divorce = null;
    }

    public void to_string() {
        System.out.println("Mariage: ");
        if (divorce != null) {
            partenaire1.to_string();
            partenaire2.to_string();
            System.out.println(date);
            System.out.println("divorcé");
        } else {
            partenaire1.to_string();
            partenaire2.to_string();
            System.out.println(date);
        }
    }
}
