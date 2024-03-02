package jeu;

import structure.CombinaisonPossible;
import structure.EtatCase;
import structure.Joueur;
import structure.Pion;

import java.util.LinkedList;

import static jeu.AffichageTable.afficherTable;
import static jeu.Initialiser.*;
import static jeu.MouvementsJoueurs.*;

public class GestionJeu {
    private static EtatCase[][] tablejeu;
    private static Pion[] listePion;
    private static Joueur[] listeJoueur;
    private static LinkedList<CombinaisonPossible> listeCombinaison;

    /**
     * Fonction principale qui permet de gérer le bon déroulement du jeu
     */
    public void jouerJeu(){
        //TODO: créer une instance avec Initialiser pour pouvoir appeler les fonctions de manières plus opti
        tablejeu = initTable();
        listeJoueur = initJoueurs();
        listePion = initPion();

        while(!jeuTermine()){
            for(int i=0; i<listeJoueur.length-1;++i){
                listeCombinaison = calcDeplacementPossible(tablejeu, listeJoueur[i]);
                System.out.println("JOUEUR "+ listeJoueur[i].getColor().getAlias());
                afficherTable(tablejeu, listeCombinaison);
                afficherDeplacements(listeCombinaison);
                deplacerPiece(tablejeu, listeJoueur[i]);
                calculerPointGagne(tablejeu, listePion, listeJoueur[i]);

                listeCombinaison = calcDeplacementPossible(tablejeu, listeJoueur[2]);
                afficherTable(tablejeu,listeCombinaison);
                afficherDeplacements(listeCombinaison);
                deplacerPiece(tablejeu, listeJoueur[2]);

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


    private static void compareScore(Joueur joueur1, Joueur joueur2) {
        if(joueur1.aGagneContre(joueur2)){ // J1 WIN
            System.out.println("Victoire du joueur 1");
        } else if (joueur2.aGagneContre(joueur1)){ // J2 WIN
            System.out.println("Victoire du joueur 2");
        }
    }


    //TODO faire la doc et message quand le joueur a terminé la partie

    /**
     * Fonction qui vérifie si le jeu est terminé, si un des 2 joueurs à gagné contre l'autre
     * @return true si un joueur à gagné la portie
     */
    public static boolean jeuTermine(){
        if(listeJoueur[0].aGagneContre(listeJoueur[1])){
            return true;
        } else return listeJoueur[1].aGagneContre(listeJoueur[0]);
    }

    public static EtatCase[][] getTableJeu() { return tablejeu;}
}
