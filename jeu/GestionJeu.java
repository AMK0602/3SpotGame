package jeu;

import structure.Combinaison;
import structure.EtatCase;
import structure.Joueur;
import structure.Pion;

import java.util.LinkedList;

import static jeu.Initialiser.*;

public class GestionJeu {
    /**
     * Fonction principale qui permet de gérer le bon déroulement du jeu, d'une partie
     */
    public void jouerJeu(){
        /** La table de jeu */
        EtatCase[][] tablejeu = initTable();
        /** La liste des joueurs */
        Joueur[] listeJoueur = initJoueurs();
        /** La liste des pions rapportant des points */
        Pion[]listePion = initPion();


        Calcul calcul = new Calcul();
        Affichage affichage = new Affichage();
        while(!jeuTermine(listeJoueur)){
            for(int i=0; i<listeJoueur.length-1;++i){
                /** La listes des mouvements possibles avec les positions des cases */
                LinkedList<Combinaison> listeCombinaison = calcul.calcDeplacementPossible(tablejeu, listeJoueur[i]);
                System.out.println("Joueur "+ listeJoueur[i].getColor().getNomPiece()+ " - Piece " + listeJoueur[i].getColor().getAlias());
                affichage.afficherTable(tablejeu, listeCombinaison, listePion);
                affichage.afficherDeplacements(listeCombinaison);
                listeJoueur[i].deplacerPiece(tablejeu, listeCombinaison);
                calcul.calculerPointGagne(tablejeu, listePion, listeJoueur[i]);

                System.out.println("Joueur "+ listeJoueur[i].getColor().getNomPiece()+ " - Piece " + listeJoueur[2].getColor().getAlias());
                listeCombinaison = calcul.calcDeplacementPossible(tablejeu, listeJoueur[2]);
                affichage.afficherTable(tablejeu,listeCombinaison,listePion);
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
    public static boolean jeuTermine(Joueur[] listeJoueur){
        if(listeJoueur[0].aGagneContre(listeJoueur[1])){
            return true;
        } else return listeJoueur[1].aGagneContre(listeJoueur[0]);
    }
}
