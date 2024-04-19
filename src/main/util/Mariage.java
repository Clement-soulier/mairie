package main.util;

import main.model.*;
import java.time.LocalDate;

public class Mariage {
    public LocalDate date;
    public Mairie mairie;
    public Citoyen partenaire1;
    public Citoyen partenaire2;

    public Mariage(LocalDate d, Mairie m, Citoyen p1, Citoyen p2) {
        date = d;
        mairie = m;
        partenaire1 = p1;
        partenaire2 = p2;
    }
}
