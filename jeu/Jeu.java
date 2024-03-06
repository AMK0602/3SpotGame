package jeu;

import structure.*;

import java.util.LinkedList;

import static jeu.Initialiser.*;

public class Jeu {
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

                //TODO FONCTION JOUERCOUP (joueur index, tablejeu, listecombi,listepion)
                System.out.println("Joueur "+ listeJoueur[i].getColor().getNomPiece()+ " - Piece " + listeJoueur[i].getColor().getAlias());
                affichage.afficherTable(tablejeu, listeCombinaison, listePion);
                affichage.afficherDeplacements(listeCombinaison);
                listeJoueur[i].deplacerPiece(tablejeu, listeCombinaison);
                calcul.calculerPointGagne(tablejeu, listePion, listeJoueur[i]);

                //TODO FONCTION JOUERCOUP
                System.out.println("Joueur "+ listeJoueur[i].getColor().getNomPiece()+ " - Piece " + listeJoueur[2].getColor().getAlias());
                listeCombinaison = calcul.calcDeplacementPossible(tablejeu, listeJoueur[2]);
                affichage.afficherTable(tablejeu,listeCombinaison,listePion);
                affichage.afficherDeplacements(listeCombinaison);
                listeJoueur[2].deplacerPiece(tablejeu, listeCombinaison);

            }
            //TODO FONCTION AFFICHER SCORE (joueur 1, joueur 2)
            affichage.afficherScores(listeJoueur[0], listeJoueur[1]);

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
            System.out.println(MessageType.VICTOIRE_JOUEUR.getMessage()+ joueur1.getIdentifiant());
        } else if (joueur2.aGagneContre(joueur1)){ // J2 WIN
            System.out.println(MessageType.VICTOIRE_JOUEUR.getMessage()+ joueur2.getIdentifiant());
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
