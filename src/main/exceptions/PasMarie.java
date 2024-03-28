package main.exceptions;

public class PasMarie extends Exception{
    public PasMarie(){
        super("Cette personne n'est pas marié(e)");
    }

    public PasMarie(int num_citoyen){
        super("Le citoyen ayant le numéro" + num_citoyen + "n'est pas marié(e)");
    }
}
