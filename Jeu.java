import jeu.GestionJeu;

public class Jeu {

    public static void main (String[] args){
        GestionJeu jeu = new GestionJeu();
        System.out.println("Hello world !");
        jeu.jouerJeu();
        // Exemple génération de joueur
        // EtatCase.valueOf permet de convertir la saisie utilisateur en EtatCase. donc "ROUGE" to ROUGE
        // ajouter assert pour verifier que c'est bien UNIQUEMENT BLEU OU ROUGE
        /*Joueur j1 = new Joueur();
        j1.setColor(saisirCouleur());*/
    }
}
