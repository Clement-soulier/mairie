package main.model;

import java.time.LocalDate;

public class Divorce {
    protected LocalDate date;
    public Mariage mariage;
    public Mairie mairie;

    public Divorce(LocalDate d, Mariage m, Mairie mair) {
        date = d;
        mariage = m;
        mairie = mair;
    }

    public void to_string() {
        System.out.println(date);
        mariage.to_string();
        System.out.println(mairie.nom_ville);
    }

}
