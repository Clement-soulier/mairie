package main.model;

import java.time.LocalDate;

public class Deces {
    protected LocalDate date;
    public Citoyen citoyen;
    public Mairie mairie;

    public Deces(LocalDate d, Citoyen c, Mairie m) {
        date = d;
        citoyen = c;
        mairie = m;
    }

}
