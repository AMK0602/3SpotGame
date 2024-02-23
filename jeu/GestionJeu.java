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
    public void jouerJeu(){
        //TODO: créer une instance avec Initialiser pour pouvoir appeler les fonctions de manières plus opti
        tablejeu = initTable();
        listejoueur = initJoueurs();
        afficherTable(tablejeu);
        for(int i=0; i<listejoueur.size();++i){
            System.out.println(listejoueur.get(i).getColor().toString());
        }
        for(int i=0; i<listejoueur.size()-1;++i){
            listejoueur.get(i).jouerTour();
            listejoueur.get(2).jouerTour();

        }
        while(!jeuTermine()){

        }
    }

    public static boolean jeuTermine(){
        // check des points
        return true;
    }
    public static EtatCase[][] getTableJeu() { return tablejeu;}
}
