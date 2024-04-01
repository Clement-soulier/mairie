package main.model;

import java.time.LocalDate;

public class Naissance {
    protected LocalDate date;
    public Mairie mairie;
    public int citoyen;
    public Citoyen parent1;
    public Citoyen parent2;

    public Naissance(LocalDate d, Mairie m, int c, Citoyen p1, Citoyen p2) {
        date = d;
        mairie = m;
        citoyen = c;
        parent1 = p1;
        parent2 = p2;
    }

    public Naissance(LocalDate d, Mairie m, int c) {
        date = d;
        mairie = m;
        citoyen = c;
        parent1 = null;
        parent2 = null;
    }

    public Naissance(LocalDate d, Mairie m, int c, Citoyen p) {
        date = d;
        mairie = m;
        citoyen = c;
        parent1 = p;
        parent2 = null;
    }

    public void to_string() {
        if (parent1 != null && parent2 != null) {
            System.out.println("Parent1: " + parent1.id + " " + parent1.nom + " " + parent1.prenom);
            System.out.println("Parent2: " + parent2.id + " " + parent2.nom + " " + parent2.prenom);
        } else if (parent1 != null) {
            System.out.println("Parent1: " + parent1.id + " " + parent1.nom + " " + parent1.prenom);
        }
        System.out.println("Enfant: " + citoyen);
    }
}
