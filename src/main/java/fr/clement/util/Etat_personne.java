package fr.clement.util;

import java.time.LocalDate;

public class Etat_personne {
    public int id;
    public String nom;
    public String prenom;
    public String sexe;
    public LocalDate date_naissance;
    public String conjoint;

    public Etat_personne(int identifiant, String n, String p, String s, LocalDate date, String conj) {
        id = identifiant;
        nom = n;
        prenom = p;
        sexe = s;
        date_naissance = date;
        conjoint = conj;
    }
}
