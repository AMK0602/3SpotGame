package jeu;

import structure.EtatCase;
import structure.Joueur;

import java.util.ArrayList;

import static jeu.AffichageTable.afficherTable;
import static jeu.Initialiser.initJoueurs;
import static jeu.Initialiser.initTable;

public class GestionJeu {
    private static EtatCase[][] tablejeu;
    private static ArrayList<Joueur> listejoueur;
    /**
     * Fonction principale qui permet de gérer le bon déroulement du jeu
     */
    public static void jouerJeu(){
        //TODO: créer une instance avec Initialiser pour pouvoir appeler les fonctions de manières plus opti
        tablejeu = initTable();
        listejoueur = initJoueurs();
        afficherTable(tablejeu);
        for(int i=0; i<listejoueur.size();++i){
            System.out.println(listejoueur.get(i).getColor().toString());
        }
    }

    /*public static void afficherTable(){
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        System.out.println("*     "+tablejeu[0][0].getAlias()+"     *     "+tablejeu[0][1].getAlias()+"     *     "+tablejeu[0][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        System.out.println("*     "+tablejeu[1][0].getAlias()+"     *     "+tablejeu[1][1].getAlias()+"     *     "+tablejeu[1][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        System.out.println("*     "+tablejeu[2][0].getAlias()+"     *     "+tablejeu[2][1].getAlias()+"     *     "+tablejeu[2][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
    }*/
}
