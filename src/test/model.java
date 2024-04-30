package test;

import main.exceptions.*;
import main.model.*;
import java.time.LocalDate;

public class Model {
    public static void main(String[] args) {
        Mairie m = new Mairie("Feurs");
        LocalDate date = LocalDate.now();

        // ajouter Citoyen sans parent
        m.ajouter_citoyen(date, "Marteau", "Bertrand", "Homme");
        m.ajouter_citoyen(date, "Marteau", "Sophie", "Femme");
        m.ajouter_citoyen(date, "Malicieu", "Robert", "Homme");
        m.ajouter_citoyen(date, "Delaplace", "Margot", "Femme");
        m.ajouter_citoyen(date, "Bricoleur", "Bob", "Homme");
        m.ajouter_citoyen(date, "Duchamps", "Albertine", "Femme");

        // trouver_citoyen
        try {
            Citoyen c1 = m.trouver_citoyen_par_id(0);
            c1.to_string();
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        }

        // si citoyen n'existe pas
        try {
            Citoyen c2 = m.trouver_citoyen_par_id(42);
            c2.to_string();
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        }

        // mort
        try {
            m.enregistrer_deces(5, date);
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort mort_err) {
            System.out.println(mort_err.to_string());
        }

        // mariage
        try {
            m.enregistrer_mariage(0, 1, date);
        } catch (DejaMarie e) {
            System.out.println("Erreur " + e);
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        }
        m.mariage.get(0).to_string();

        // si une des personne est déjà marié
        try {
            m.enregistrer_mariage(1, 3, date);
        } catch (DejaMarie e) {
            System.out.println("Erreur " + e);
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        }

        // si une personne n'existe pas
        try {
            m.enregistrer_mariage(90, 3, date);
        } catch (DejaMarie e) {
            System.out.println("Erreur " + e);
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        }

        // si une personne est morte
        try {
            m.enregistrer_mariage(5, 3, date);
        } catch (DejaMarie e) {
            System.out.println("Erreur " + e);
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        }

        // naissance
        try {
            m.enregistrer_naissance(0, 1, date, "Marteau", "Aldebert", "Homme");
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        } catch (MauvaisSexe e) {
            System.out.println("Erreur " + e);
        }
        m.naissance.get(m.naissance.size() - 1).to_string();

        // si une personne n'existe pas
        try {
            m.enregistrer_naissance(99, 4, date, "Bricoleur", "Martine", "Femme");
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        } catch (MauvaisSexe e) {
            System.out.println("Erreur " + e);
        }

        // si une personne est morte
        try {
            m.enregistrer_naissance(4, 5, date, "Bricoleur", "Martine", "Femme");
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        } catch (MauvaisSexe e) {
            System.out.println("Erreur " + e);
        }

        // si les deux parents ne sont pas de sexe opposés
        try {
            m.enregistrer_naissance(0, 2, date, "Bricoleur", "Martine", "Femme");
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        } catch (MauvaisSexe e) {
            System.out.println("Erreur " + e);
        }

        // divorce
        try {
            m.enregistrer_divorce(0, date);
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (PasMarie e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        }
        m.mariage.get(0).to_string();
        m.divorce.get(0).to_string();

        // si pas marié
        try {
            m.enregistrer_divorce(3, date);
        } catch (PasMarie e) {
            System.out.println("Erreur " + e);
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        }

        // si n'existe pas
        try {
            m.enregistrer_divorce(90, date);
        } catch (PasMarie e) {
            System.out.println("Erreur " + e);
        } catch (PersonneInexistante e) {
            System.out.println("Erreur " + e);
        } catch (Mort e) {
            System.out.println("Erreur " + e);
        }
    }
}
