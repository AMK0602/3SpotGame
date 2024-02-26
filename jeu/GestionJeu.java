package jeu;

import structure.EtatCase;
import structure.Joueur;

import java.util.ArrayList;

import static jeu.AffichageTable.afficherTable;
import static jeu.Initialiser.*;
import static jeu.MouvementsJoueurs.*;

public class GestionJeu {
    private static EtatCase[][] tablejeu;
    private static ArrayList<Pion> listePion;
    private static ArrayList<Joueur> listejoueur;
    /**
     * Fonction principale qui permet de gérer le bon déroulement du jeu
     */
    public void jouerJeu(){
        //TODO: créer une instance avec Initialiser pour pouvoir appeler les fonctions de manières plus opti
        tablejeu = initTable();
        listejoueur = initJoueurs();
        listePion = initPion();

        while(!jeuTermine()){
            for(int i=0; i<listejoueur.size()-1;++i){
                System.out.println("JOUEUR "+listejoueur.get(i).getColor().getAlias());
                afficherTable(tablejeu);
                afficherDeplacements(calcDeplacementPossible(tablejeu, listejoueur.get(i)));
                deplacerPiece(tablejeu, listejoueur.get(i));
                calculerPointGagne(tablejeu, listePion, listejoueur.get(i));

                afficherTable(tablejeu);
                afficherDeplacements(calcDeplacementPossible(tablejeu, listejoueur.get(2)));
                deplacerPiece(tablejeu, listejoueur.get(2));

            }
            System.out.println(" ");
            System.out.println("-------------------------------------");
            System.out.println("Score du joueur "+ listejoueur.get(0).getColor().getAlias() +" : "+ listejoueur.get(0).getScore());
            System.out.println("Score du joueur "+ listejoueur.get(1).getColor().getAlias() +" : "+ listejoueur.get(1).getScore());
            System.out.println("-------------------------------------");
            System.out.println(" ");
        }
        compareScore(listejoueur.get(0), listejoueur.get(1));
    }


    private static void compareScore(Joueur joueur1, Joueur joueur2) {
        if(joueur1.aGagneContre(joueur2)){ // J1 WIN
            System.out.println("Victoire du joueur 1");
        } else if (joueur2.aGagneContre(joueur1)){ // J2 WIN
            System.out.println("Victoire du joueur 2");
        }
    }


    //TODO faire la doc et message quand le joueur a terminé la partie
    public static boolean jeuTermine(){
        if(listejoueur.get(0).aGagneContre(listejoueur.get(1))){
            return true;
        } else return listejoueur.get(1).aGagneContre(listejoueur.get(0));
    }

    public static EtatCase[][] getTableJeu() { return tablejeu;}
}
