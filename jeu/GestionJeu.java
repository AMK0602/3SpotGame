package jeu;

import structure.Combinaison;
import structure.EtatCase;
import structure.Joueur;
import structure.Pion;

import java.util.LinkedList;

import static jeu.Affichage.afficherTable;
import static jeu.Initialiser.*;
import static jeu.MouvementsPiece.*;

public class GestionJeu {
    /** La listes des mouvements possibles avec les positions des cases */
    private static LinkedList<Combinaison> listeCombinaison;
    /** La table de jeu */
    private static EtatCase[][] tablejeu;
    /** La liste des pions rapportant des points */
    private static Pion[] listePion;
    /** La liste des joueurs */
    private static Joueur[] listeJoueur;


    /**
     * Fonction principale qui permet de gérer le bon déroulement du jeu, d'une partie
     */
    public void jouerJeu(){
        Calcul calcul = new Calcul();
        Affichage affichage = new Affichage();
        //TODO: créer une instance avec Initialiser pour pouvoir appeler les fonctions de manières plus opti
        tablejeu = initTable();
        listeJoueur = initJoueurs();
        listePion = initPion();

        while(!jeuTermine()){
            for(int i=0; i<listeJoueur.length-1;++i){
                listeCombinaison = calcul.calcDeplacementPossible(tablejeu, listeJoueur[i]);
                System.out.println("JOUEUR "+ listeJoueur[i].getColor().getNomPiece()+ " PIECE" + listeJoueur[i].getColor().getAlias());
                afficherTable(tablejeu, listeCombinaison);
                affichage.afficherDeplacements(listeCombinaison);
                listeJoueur[i].deplacerPiece(tablejeu, listeCombinaison);
                calcul.calculerPointGagne(tablejeu, listePion, listeJoueur[i]);

                System.out.println("JOUEUR "+ listeJoueur[i].getColor().getNomPiece()+ " PIECE" + listeJoueur[i].getColor().getAlias());
                listeCombinaison = calcul.calcDeplacementPossible(tablejeu, listeJoueur[2]);
                afficherTable(tablejeu,listeCombinaison);
                affichage.afficherDeplacements(listeCombinaison);
                listeJoueur[2].deplacerPiece(tablejeu, listeCombinaison);

            }
            System.out.println(" ");
            System.out.println("-------------------------------------");
            System.out.println("Score du joueur "+ listeJoueur[0].getColor().getAlias() +" : "+ listeJoueur[0].getScore());
            System.out.println("Score du joueur "+ listeJoueur[1].getColor().getAlias() +" : "+ listeJoueur[1].getScore());
            System.out.println("-------------------------------------");
            System.out.println(" ");
        }
        compareScore(listeJoueur[0], listeJoueur[1]);
    }

    /**
     * Permet de comparer le score de deux joueurs
     * @param joueur1 : le premier joueur
     * @param joueur2 : le deuxième joueur
     */
    private static void compareScore(Joueur joueur1, Joueur joueur2) {
        if(joueur1.aGagneContre(joueur2)){ // J1 WIN
            System.out.println("Victoire du joueur 1");
        } else if (joueur2.aGagneContre(joueur1)){ // J2 WIN
            System.out.println("Victoire du joueur 2");
        }
    }

    /**
     * Fonction qui vérifie si le jeu est terminé, si un des 2 joueurs à gagné contre l'autre
     * @return true si un joueur à gagné la portie
     */
    public static boolean jeuTermine(){
        if(listeJoueur[0].aGagneContre(listeJoueur[1])){
            return true;
        } else return listeJoueur[1].aGagneContre(listeJoueur[0]);
    }
}
