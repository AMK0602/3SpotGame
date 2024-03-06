package jeu;
import java.util.Scanner;

import structure.MessageType;
import structure.EtatCase;
import structure.Joueur;
import structure.Pion;

public class Initialiser {

    //TODO FAIRE CONSTANTES

    /**
     * Initialiser 2 joueurs pour jouer au jeu
     * Permet également de choisir leurs couleurs
     * @return listejoueur : la liste des joueurs qu'on a rempli.
     */
    public static Joueur[] initJoueurs(){
        Joueur[] listeJoueur = new Joueur[Jeu.NB_MAX_JOUEUR+1];
        MessageType.CHOIX_COULEUR.afficherMessage();
        listeJoueur[0] = new Joueur(saisirCouleur());
        listeJoueur[2] = new Joueur(EtatCase.NEUTRE);
        if(listeJoueur[0].getColor() == EtatCase.ROUGE){
            listeJoueur[1] = new Joueur(EtatCase.BLEU);
        } else {
            listeJoueur[1] = new Joueur(EtatCase.ROUGE);
        }
        //TODO RESOUDRE ICI
        /*while(j2.hasSameColor(j1)){
            MessageType.ERR_COULEUR_UTILISE.afficherMessage();
            j2.setColor(saisirCouleur());
        }*/

        return listeJoueur;
    }

    /**
     * Permet au joueur en question de saisir sa couleur
     * @return une couleur de l'énumération des cases possibles: rouge ou bleu
     * @return si la couleur n'est pas une couleur valide alors on resaisie une couleur
     */
    public static EtatCase saisirCouleur(){
        Scanner sc = new Scanner(System.in) ;
        String couleur = sc.next();
        if(!doesColorExist(couleur)){
            MessageType.ERR_COULEUR_INEXISTANTE.afficherMessage();
            return saisirCouleur(); // appel récursif pour nous forcer a saisir une couleur correct
        } else {
            return getColor(couleur);
            //TODO return getColor(couleur);
            /*if(couleur.equalsIgnoreCase("rouge") || couleur.equalsIgnoreCase("r")){
                return EtatCase.ROUGE;
            } else if (couleur.equalsIgnoreCase("bleu") || couleur.equalsIgnoreCase("b")){
                return EtatCase.BLEU;
            }*/
        }
    }

    /**
     * Permet d'initialiser le plateau de jeu avec les différentes pièces placées
     * @return table : la table de jeu qu'on a rempli
     */
    public static EtatCase[][] initTable(){
        EtatCase[][] table = new EtatCase[Jeu.SIZE_MAX_TABLE][Jeu.SIZE_MAX_TABLE];
        table[0][0] = EtatCase.LIBRE;
        table[0][1] = EtatCase.ROUGE;
        table[0][2] = EtatCase.ROUGE;

        table[1][0] = EtatCase.LIBRE;
        table[1][1] = EtatCase.NEUTRE;
        table[1][2] = EtatCase.NEUTRE;

        table[2][0] = EtatCase.LIBRE;
        table[2][1] = EtatCase.BLEU;
        table[2][2] = EtatCase.BLEU;
        return table;
    }

    /**
     * Permet de créer les pions qui donne des points et de les placer dans une liste qu'on renvoie.
     * @return listepion : la liste des pions qu'on a remplie
     */
    public static Pion[] initPion(){
        Pion[] listepion = new Pion[Jeu.NB_MAX_PION];
        listepion[0] = new Pion(0,2);
        listepion[1] = new Pion(1,2);
        listepion[2] = new Pion(2,2);

        return listepion;
    }

    /**
     * Vérifie si la couleur est une couleur valide
     * @param couleur : la couleur saisie par le joueur
     * @return true si la couleur est valide, false si la couleur est invalide
     */
    private static boolean doesColorExist(String couleur) {
        return couleur.equalsIgnoreCase("rouge") || couleur.equalsIgnoreCase("bleu") || couleur.equalsIgnoreCase("r") || couleur.equalsIgnoreCase("b");
    }

    public static EtatCase getColor(String couleur){
        if(couleur.equalsIgnoreCase("rouge") ||couleur.equalsIgnoreCase("r")){
            return EtatCase.ROUGE;
        } else {
            return EtatCase.BLEU;
        }
    }
}
