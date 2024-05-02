package fr.clement.exceptions;

public class PasMarie extends Exception {
    private int numero_citoyen;

    public PasMarie() {
        super("Cette personne n'est pas marié(e)");
    }

    public PasMarie(int num_citoyen) {
        super("Le citoyen ayant le numéro" + " " + num_citoyen + " " + "n'est pas marié(e)");
        numero_citoyen = num_citoyen;
    }

    public String to_string() {
        return "Le citoyen ayant le numéro" + " " + numero_citoyen + " " + "n'est pas marié(e)";
    }
}
