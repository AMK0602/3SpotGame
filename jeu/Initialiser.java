package jeu;
import java.util.Scanner;
import structure.EtatCase;
import structure.Joueur;

public class Initialiser {

    /**
     * Initialiser 2 joueurs pour jouer au jeu
     * Permet également de choisir leurs couleurs
     */
    public static void initJoueurs(){
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        j1.setColor(saisirCouleur());
        j2.setColor(saisirCouleur());
    }

    /**
     * Permet au joueur en question de saisir sa couleur
     * @return une couleur de l'énumération des cases possibles: rouge ou bleu
     */
    public static EtatCase saisirCouleur(){
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Quelle couleur voulez vous choisir ? ROUGE ou BLEU : ");
        String couleur = sc.next();
        assert(couleur == "ROUGE" || couleur == "BLEU");
        return EtatCase.valueOf(couleur);
    }

    /**
     * Permet d'initialiser le plateau de jeu avec les différentes pièces placées
     */
    public static void initTable(EtatCase[][] table){ // remplacer par non-static void par la suite
        table[0][0] = EtatCase.LIBRE;
        table[0][1] = EtatCase.ROUGE;
        table[0][2] = EtatCase.ROUGE;

        table[1][0] = EtatCase.LIBRE;
        table[1][1] = EtatCase.NEUTRE;
        table[1][2] = EtatCase.NEUTRE;

        table[2][0] = EtatCase.LIBRE;
        table[2][1] = EtatCase.BLEU;
        table[2][2] = EtatCase.BLEU;
    }
    /*public enum Status{ROUGE,BLEU,BLANC,LIBRE}
    Status[][] table = new Status[3][3];

    public void InitPosition(Status[][] table){

    }*/
}
