package main.model;

import java.time.LocalDate;

public class Mariage {
    protected LocalDate date;
    public Mairie mairie;
    public Citoyen partenaire1;
    public Citoyen partenaire2;
    public Divorce divorce;

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
