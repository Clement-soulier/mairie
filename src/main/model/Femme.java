package main.model;

import java.util.*;
import java.time.LocalDate;

public class Femme extends Citoyen {
    public Femme(String name, String p, LocalDate d, Mairie m, Naissance n) {
        super(name, p, d, m, n);
    }


}
