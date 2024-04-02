package main.model;

import java.time.LocalDate;

public class Citoyen {
    static int get_id = 0;
    public int id;
    public String nom;
    public String prenom;
    public LocalDate date_naissance;
    public Mairie mairie;
    public Deces deces;
    public Naissance naissance;

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
