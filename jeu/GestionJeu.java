package jeu;

import structure.EtatCase;

import static jeu.Initialiser.initJoueurs;
import static jeu.Initialiser.initTable;

public class GestionJeu {

    /**
     * Fonction principale qui permet de gérer le bon déroulement du jeu
     */
    public static void jouerJeu(){
        // Initialisation de la table de jeu 3x3
        EtatCase[][] tablejeu = new EtatCase[3][3];

        //TODO: créer une instance avec Initialiser pour pouvoir appeler les fonctions de manières plus opti
        initTable(tablejeu);
        initJoueurs();
    }
}
