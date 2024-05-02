package fr.clement.model;

import java.time.LocalDate;
import java.io.Serializable;

public class Citoyen implements Serializable {
    static int get_id = 0;
    protected int id;
    protected String nom;
    protected String prenom;
    protected LocalDate date_naissance;
    protected Mairie mairie;
    protected Deces deces;
    protected Naissance naissance;

    public Citoyen(String name, String p, LocalDate d, Mairie m, Naissance n) {
        id = get_id++;
        nom = name;
        prenom = p;
        date_naissance = d;
        mairie = m;
        deces = null;
        naissance = n;
    }

    public Citoyen(String name, String p, LocalDate d, Mairie m) {
        id = get_id++;
        nom = name;
        prenom = p;
        date_naissance = d;
        mairie = m;
        deces = null;
        naissance = null;
    }

    public void to_string() {
        if (this instanceof Homme) {
            System.out.println(nom + " " + prenom + " " + "Homme" + " " +
                    date_naissance + " " + mairie.nom_ville);
        } else {
            System.out.println(nom + " " + prenom + " " + "Femme" + " "
                    + date_naissance + " " + mairie.nom_ville);
        }
    }

}
