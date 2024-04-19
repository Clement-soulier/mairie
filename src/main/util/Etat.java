package main.util;

import main.exceptions.PasMarie;
import main.exceptions.PersonneInexistante;
import main.model.Citoyen;
import main.model.Mairie;

public class Etat {
    public Etat_personne obtenir_etat(Mairie m, int id) throws PersonneInexistante {
        try {
            Citoyen citoyen = m.trouver_citoyen_par_id(id);
            Etat_citoyen etat_citoyen = citoyen.obtenir_etat();
            Mariage mariage = m.obtenir_mariage_util(id);
            if (mariage.partenaire1 == citoyen) {
                Etat_citoyen etat_conjoint = mariage.partenaire2.obtenir_etat();
                String nom_prenom_conjoint = etat_conjoint.nom + " " + etat_conjoint.prenom;
                return new Etat_personne(id, etat_citoyen.nom, etat_citoyen.prenom, etat_citoyen.sexe,
                        etat_citoyen.date_naissance, nom_prenom_conjoint);
            } else {
                Etat_citoyen etat_conjoint = mariage.partenaire1.obtenir_etat();
                String nom_prenom_conjoint = etat_conjoint.nom + " " + etat_conjoint.prenom;
                return new Etat_personne(id, etat_citoyen.nom, etat_citoyen.prenom, etat_citoyen.sexe,
                        etat_citoyen.date_naissance, nom_prenom_conjoint);
            }
        } catch (PersonneInexistante e) {
            throw new PersonneInexistante(id);
        } catch (PasMarie e) {
            Citoyen citoyen = m.trouver_citoyen_par_id(id);
            Etat_citoyen etat_citoyen = citoyen.obtenir_etat();
            return new Etat_personne(id, etat_citoyen.nom, etat_citoyen.prenom, etat_citoyen.sexe,
                    etat_citoyen.date_naissance, "");
        }
    }
}
