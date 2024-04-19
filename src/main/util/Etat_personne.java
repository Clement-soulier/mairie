package main.util;

import java.time.LocalDate;

public class Etat_personne extends Etat_citoyen {
    public String conjoint;

    public Etat_personne(int id, String nom, String prenom, String sexe, LocalDate date_naissance, String conj) {
        super(id, nom, prenom, sexe, date_naissance);
        conjoint = conj;
    }
}
