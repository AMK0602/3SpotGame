import jeu.GestionJeu;

public class Jeu {

    /**
     * Fonction main, permet de créer le jeu
     * @param args : les arguments si il y en a
     */
    public static void main (String[] args){
        GestionJeu jeu = new GestionJeu();
        System.out.println("Hello world !");
        jeu.jouerJeu();
    }
}
