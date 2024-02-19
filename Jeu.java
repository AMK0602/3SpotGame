import jeu.EtatCase;
import structure.Joueur;

public class Jeu {

    public static void main (String[] args){
        System.out.println("Hello world !");
        // Exemple génération de joueur
        // EtatCase.valueOf permet de convertir la saisie utilisateur en EtatCase. donc "ROUGE" to ROUGE
        // ajouter assert pour verifier que c'est bien UNIQUEMENT BLEU OU ROUGE
        Joueur etat = new Joueur(EtatCase.valueOf("ROUGE"));
    }
}
