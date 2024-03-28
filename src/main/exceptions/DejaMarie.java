package main.exceptions;

public class DejaMarie extends Exception{
    public DejaMarie(){
        super("Cette personne est déjà marié(e)");
    }

    public DejaMarie(int num_citoyen){
        super("Le citoyen ayant le numéro" + num_citoyen + "est déjà marié(e)");
    }
}
