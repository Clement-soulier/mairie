package main.model;

import java.time.LocalDate;

public class Homme extends Citoyen {
    public Homme(String name, String p, LocalDate d, Mairie m) {
        super(name, p, d, m);
    }

}
