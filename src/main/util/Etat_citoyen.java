package main.util;

import java.time.LocalDate;

public class Etat_citoyen {
    public int id;
    public String nom;
    public String prenom;
    public String sexe;
    public LocalDate date_naissance;

    public Etat_citoyen(int identifiant, String n, String p, String s, LocalDate date) {
        id = identifiant;
        nom = n;
        prenom = p;
        sexe = s;
        date_naissance = date;
    }
}
