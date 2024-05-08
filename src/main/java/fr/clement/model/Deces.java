package fr.clement.model;

import java.time.LocalDate;
import java.io.Serializable;

public class Deces implements Serializable {
    protected LocalDate date;
    protected Citoyen citoyen;
    protected Mairie mairie;

    public Deces(LocalDate d, Citoyen c, Mairie m) {
        date = d;
        citoyen = c;
        mairie = m;
    }

}
