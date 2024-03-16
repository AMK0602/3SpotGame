import jeu.Jeu;

/**
 * Classe principale du jeu
 * @author HOUY Ethan - KHABBAZ Amine
 */
public class Main {

    /**
     * Fonction main, permet de créer le jeu
     * @param args : les arguments si il y en a
     */
    public static void main (String[] args){
        Jeu jeu = new Jeu();
        System.out.println("Hello world !");
        jeu.jouerJeu();
    }
}
