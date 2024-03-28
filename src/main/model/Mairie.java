package main.model;

import java.util.*;
import java.time.LocalDate;
import main.exceptions.*;

public class Mairie {
    protected String nom_ville;
    public ArrayList<Citoyen> citoyen;
    public ArrayList<Mariage> mariage;
    public ArrayList<Naissance> naissance;
    public ArrayList<Deces> mort;
    public ArrayList<Divorce> divorce;

    public Mairie(String ville){
        nom_ville = ville;
        citoyen = new ArrayList<Citoyen>();
        mariage = new ArrayList<Mariage>();
        naissance = new ArrayList<Naissance>();
        mort = new ArrayList<Deces>();
        divorce = new ArrayList<Divorce>();
    }

    public Citoyen trouver_citoyen_par_id(int id_citoyen) throws PersonneInexistante{
        for(Citoyen citoyen: citoyen){
            if(citoyen.id == id_citoyen){
                return citoyen;
            }
        }
        throw new PersonneInexistante(id_citoyen);
    }

    public boolean est_marie(int id_personne){
        for(Mariage mariage: mariage){
            if(
              (mariage.partenaire1.id == id_personne || 
               mariage.partenaire2.id == id_personne) && 
              mariage.divorce == null){
                return true;
            }
        }
        return false;
    }

    public Mariage obtenir_mariage(int id_personne) throws PasMarie{
        for(Mariage mariage: mariage){
            if(
              (mariage.partenaire1.id == id_personne || 
               mariage.partenaire2.id == id_personne) && 
              mariage.divorce == null){
                return mariage;
            }
        }
        throw new PasMarie(id_personne);
    }

    public void enregistrer_mariage(int id_partenaire1, int id_partenaire2) throws DejaMarie, PersonneInexistante{
        for(Mariage mariage: mariage){
            if(est_marie(id_partenaire1)){
                throw new DejaMarie(id_partenaire1);
            } else if(est_marie(id_partenaire2)){
                throw new DejaMarie(id_partenaire2);
            }
        }
        LocalDate date = LocalDate.now();
        Citoyen partenaire1 = trouver_citoyen_par_id(id_partenaire1);
        Citoyen partenaire2 = trouver_citoyen_par_id(id_partenaire2);
        Mariage m = new Mariage(date, this, partenaire1, partenaire2);
        mariage.add(m);
    }

    public void enregistrer_divorce(int id_personne) throws PersonneInexistante{
        Citoyen citoyen = trouver_citoyen_par_id(id_personne);
        LocalDate date = LocalDate.now();
        for(Mariage mariage: mariage){
            if(mariage.partenaire1.equals(citoyen) || mariage.partenaire2.equals(citoyen)){
                Divorce d = new Divorce(date, mariage, this);
                divorce.add(d);
                mariage.divorce = d;
            }
        }
    }
    
//représente sexe avec un string, peut changer à l'avenir en fonction 
//implémentation de l'interface
    public void enregistrer_naissance(int p1, int p2, LocalDate date_naissance, String nom, String prenom, String sexe) throws PersonneInexistante{
        Citoyen parent1 = trouver_citoyen_par_id(p1);
        Citoyen parent2 = trouver_citoyen_par_id(p2);
        Naissance n = new Naissance(date_naissance, this, Citoyen.get_id, parent1, parent2);
        naissance.add(n);
        //changer cette déclaration avec le bon sexe à la fin
        Citoyen c = new Citoyen(nom, prenom, date_naissance, this, n);
        citoyen.add(c);
    }

    public void ajouter_citoyen(Integer p1, Integer p2, 
            LocalDate date_naissance, String nom, String prenom, String sexe) throws PersonneInexistante{
        Citoyen parent1 = trouver_citoyen_par_id(p1);
        Citoyen parent2 = trouver_citoyen_par_id(p2);
        Naissance n = new Naissance(date_naissance, this, Citoyen.get_id, parent1, parent2);
        naissance.add(n);
        //changer cette déclaration avec le bon sexe à la fin
        Citoyen c = new Citoyen(nom, prenom, date_naissance, this, n);
        citoyen.add(c);
    }

    public void ajouter_citoyen(Integer p1, 
            LocalDate date_naissance, String nom, String prenom, String sexe) throws PersonneInexistante{
        Citoyen parent1 = trouver_citoyen_par_id(p1);
        Naissance n = new Naissance(date_naissance, this, Citoyen.get_id, parent1);
        naissance.add(n);
        //changer cette déclaration avec le bon sexe à la fin
        Citoyen c = new Citoyen(nom, prenom, date_naissance, this, n);
        citoyen.add(c);
    }

    public void ajouter_citoyen(LocalDate date_naissance, String nom, String prenom, String sexe){
        Naissance n = new Naissance(date_naissance, this, Citoyen.get_id);
        naissance.add(n);
        //changer cette déclaration avec le bon sexe à la fin
        Citoyen c = new Citoyen(nom, prenom, date_naissance, this, n);
        citoyen.add(c);
    }
}
