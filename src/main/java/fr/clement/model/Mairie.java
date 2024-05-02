package fr.clement.model;

import java.util.*;
import java.time.LocalDate;
import fr.clement.exceptions.*;
import fr.clement.util.Etat_personne;
import java.io.Serializable;

public class Mairie implements Serializable {
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

    public void enregistrer_divorce(int id_personne, LocalDate date) throws PersonneInexistante, PasMarie, Mort {
        Citoyen citoyen = trouver_citoyen_par_id(id_personne);
        if (citoyen.deces != null) {
            throw new Mort(id_personne);
        }
        Mariage mariage = obtenir_mariage(id_personne);
        Divorce d = new Divorce(date, mariage, this);
        divorce.add(d);
        mariage.divorce = d;
    }

    public void enregistrer_naissance(int id_pere, int id_mere, LocalDate date_naissance, String nom, String prenom,
            String sexe)
            throws PersonneInexistante, Mort, MauvaisSexe {
        Citoyen parent1 = trouver_citoyen_par_id(id_pere);
        if (parent1 instanceof Femme) {
            throw new MauvaisSexe(id_pere);
        }
        Citoyen parent2 = trouver_citoyen_par_id(id_mere);
        if (parent2 instanceof Homme) {
            throw new MauvaisSexe(id_mere);
        }
        Homme pere = (Homme) parent1;
        Femme mere = (Femme) parent2;
        if (pere.deces != null) {
            throw new Mort(id_pere);
        }
        if (mere.deces != null) {
            throw new Mort(id_mere);
        }
        Citoyen c;
        if (sexe.equals("Homme")) {
            c = new Homme(nom, prenom, date_naissance, this);
        } else {
            c = new Femme(nom, prenom, date_naissance, this);
        }
        Naissance n = new Naissance(date_naissance, this, c, pere, mere);
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

    public void enregistrer_deces(int id_citoyen, LocalDate date) throws PersonneInexistante, Mort {
        Citoyen c = trouver_citoyen_par_id(id_citoyen);
        for (Deces deces : mort) {
            if (deces.citoyen == c) {
                throw new Mort(id_citoyen);
            }
        }
        Deces d = new Deces(date, c, this);
        mort.add(d);
        c.deces = d;
    }

    public Etat_personne obtenir_etat(Citoyen citoyen) {
        try {
            String sexe;
            if (citoyen instanceof Homme) {
                sexe = "Homme";
            } else {
                sexe = "Femme";
            }
            Mariage mariage = this.obtenir_mariage(citoyen.id);
            if (mariage.partenaire1 == citoyen) {
                String nom_prenom_conjoint = mariage.partenaire2.nom + " " + mariage.partenaire2.prenom;
                return new Etat_personne(citoyen.id, citoyen.nom, citoyen.prenom, sexe, citoyen.date_naissance,
                        nom_prenom_conjoint);
            } else {
                String nom_prenom_conjoint = mariage.partenaire1.nom + " " + mariage.partenaire1.prenom;
                return new Etat_personne(citoyen.id, citoyen.nom, citoyen.prenom, sexe, citoyen.date_naissance,
                        nom_prenom_conjoint);
            }
        } catch (PasMarie e) {
            String sexe;
            if (citoyen instanceof Homme) {
                sexe = "Homme";
            } else {
                sexe = "Femme";
            }
            return new Etat_personne(citoyen.id, citoyen.nom, citoyen.prenom, sexe, citoyen.date_naissance, "");
        }
    }
}
