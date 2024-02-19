package jeu;
import java.util.Scanner;
import structure.EtatCase;
import structure.Joueur;

public class Initialiser {
    public static EtatCase saisirCouleur(){
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Quelle couleur voulez vous choisir ? ROUGE ou BLEU : ");
        String couleur = sc.next();
        return EtatCase.valueOf(couleur);
    }
}
