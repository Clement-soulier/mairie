package main.model;

import java.util.*;
import java.time.LocalDate;
import main.exceptions.*;

public class Mairie {
    public String nom_ville;
    public ArrayList<Citoyen> citoyen;
    public ArrayList<Mariage> mariage;
    public ArrayList<Naissance> naissance;
    public ArrayList<Deces> mort;
    public ArrayList<Divorce> divorce;

    public Mairie(String ville) {
        nom_ville = ville;
        citoyen = new ArrayList<Citoyen>();
        mariage = new ArrayList<Mariage>();
        naissance = new ArrayList<Naissance>();
        mort = new ArrayList<Deces>();
        divorce = new ArrayList<Divorce>();
    }

    public Citoyen trouver_citoyen_par_id(int id_citoyen) throws PersonneInexistante {
        for (Citoyen citoyen : citoyen) {
            if (citoyen.id == id_citoyen) {
                return citoyen;
            }
        }
        throw new PersonneInexistante(id_citoyen);
    }

    public Homme trouver_homme_par_id(int id_citoyen) throws PersonneInexistante, java.lang.IllegalArgumentException {
        for (Citoyen citoyen : citoyen) {
            if (citoyen.id == id_citoyen) {
                if (citoyen instanceof Homme) {
                    return (Homme) citoyen;
                } else {
                    throw new java.lang.IllegalArgumentException();
                }
            }
        }
        throw new PersonneInexistante(id_citoyen);
    }

    public Femme trouver_femme_par_id(int id_citoyen) throws PersonneInexistante, java.lang.IllegalArgumentException {
        for (Citoyen citoyen : citoyen) {
            if (citoyen.id == id_citoyen) {
                if (citoyen instanceof Femme) {
                    return (Femme) citoyen;
                } else {
                    throw new java.lang.IllegalArgumentException();
                }
            }
        }
        throw new PersonneInexistante(id_citoyen);
    }

    public boolean est_marie(int id_personne) {
        for (Mariage mariage : mariage) {
            if ((mariage.partenaire1.id == id_personne ||
                    mariage.partenaire2.id == id_personne) &&
                    mariage.divorce == null) {
                return true;
            }
        }
        return false;
    }

    public Mariage obtenir_mariage(int id_personne) throws PasMarie {
        for (Mariage mariage : mariage) {
            if ((mariage.partenaire1.id == id_personne ||
                    mariage.partenaire2.id == id_personne) &&
                    mariage.divorce == null) {
                return mariage;
            }
        }
        throw new PasMarie(id_personne);
    }

    public void enregistrer_mariage(int id_partenaire1, int id_partenaire2, LocalDate date)
            throws DejaMarie, PersonneInexistante, Mort {
        if (est_marie(id_partenaire1)) {
            throw new DejaMarie(id_partenaire1);
        } else if (est_marie(id_partenaire2)) {
            throw new DejaMarie(id_partenaire2);
        }
        Citoyen partenaire1 = trouver_citoyen_par_id(id_partenaire1);
        Citoyen partenaire2 = trouver_citoyen_par_id(id_partenaire2);
        if (partenaire1.deces != null) {
            throw new Mort(id_partenaire1);
        }
        if (partenaire2.deces != null) {
            throw new Mort(id_partenaire2);
        }
        Mariage m = new Mariage(date, this, partenaire1, partenaire2);
        mariage.add(m);
    }

    public void enregistrer_divorce(int id_personne) throws PersonneInexistante, PasMarie, Mort {
        Citoyen citoyen = trouver_citoyen_par_id(id_personne);
        if (citoyen.deces != null) {
            throw new Mort(id_personne);
        }
        LocalDate date = LocalDate.now();
        Mariage mariage = obtenir_mariage(id_personne);
        Divorce d = new Divorce(date, mariage, this);
        divorce.add(d);
        mariage.divorce = d;
    }

    public void enregistrer_naissance(int id_pere, int id_mere, LocalDate date_naissance, String nom, String prenom,
            String sexe)
            throws PersonneInexistante, Mort, java.lang.IllegalArgumentException {
        Homme parent1 = trouver_homme_par_id(id_pere);
        Femme parent2 = trouver_femme_par_id(id_mere);
        if (parent1.deces != null) {
            throw new Mort(id_pere);
        }
        if (parent2.deces != null) {
            throw new Mort(id_mere);
        }
        Citoyen c;
        if (sexe.equals("Homme")) {
            c = new Homme(nom, prenom, date_naissance, this);
        } else {
            c = new Femme(nom, prenom, date_naissance, this);
        }
        Naissance n = new Naissance(date_naissance, this, c, parent1, parent2);
        c.naissance = n;
        citoyen.add(c);
        naissance.add(n);
    }

    public void ajouter_citoyen(LocalDate date_naissance, String nom, String prenom, String sexe) {
        Citoyen c;
        if (sexe.equals("Homme")) {
            c = new Homme(nom, prenom, date_naissance, this);
        } else {
            c = new Femme(nom, prenom, date_naissance, this);
        }
        citoyen.add(c);
    }

    public void enregistrer_deces(int id_citoyen, LocalDate date) throws PersonneInexistante {
        Citoyen c = trouver_citoyen_par_id(id_citoyen);
        Deces d = new Deces(date, c, this);
        mort.add(d);
        c.deces = d;
    }
}
