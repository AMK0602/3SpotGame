package jeu;

import structure.*;

import java.util.LinkedList;

import static jeu.Initialiser.*;


public class Jeu {
    /** La taille maximale de la table de jeu */
    public static final int SIZE_MAX_TABLE = 3;
    /** Le nombre maximum de pion rapportant des points */
    public static final int NB_MAX_PION = 3;
    /** Le nombre maximale de joueur pouvant jouer */
    public static final int NB_MAX_JOUEUR = 2;
    /** Nombre de point requis pour gagner */
    public static final int MAX_POINT = 12;
    /** Nombre de point minimum que l'adversaire doit avoir */
    public static final int MIN_ENNEMI_POINT = 6;
    /** La table de jeu */
    private EtatCase[][] tableJeu;
    /** La liste des joueurs */
    private Joueur[] listeJoueur;
    /** La liste des pions rapportant des points */
    private Pion[] listePion;
    /**
     * Fonction principale qui permet de gérer le bon déroulement du jeu, d'une partie
     */
    public void jouerJeu(){
        tableJeu = initTable();
        listeJoueur = initJoueurs();
        listePion = initPion();

        Calcul calcul = new Calcul(this);
        Affichage affichage = new Affichage(this);
        while(!jeuTermine(listeJoueur)){
            for(int i=0; i<listeJoueur.length-1;++i){
                System.out.println("Joueur "+ listeJoueur[i].getColor().getNomPiece()+ " - Piece " + listeJoueur[i].getColor().getAlias());
                jouerCoup(listeJoueur[i], calcul, tableJeu, affichage);
                calcul.calculerPointGagne(tableJeu, listePion, listeJoueur[i]);
                System.out.println("Joueur "+ listeJoueur[i].getColor().getNomPiece()+ " - Piece " + listeJoueur[2].getColor().getAlias());
                jouerCoup(listeJoueur[2], calcul, tableJeu, affichage);
            }
            affichage.afficherScores(listeJoueur[0], listeJoueur[1]);

        }
        affichage.afficherGagnant();
    }

    public static void jouerCoup(Joueur joueur, Calcul calcul, EtatCase[][] tableJeu, Affichage affichage){
        //TODO a simplifier
        /** La listes des mouvements possibles avec les positions des cases */
        LinkedList<Combinaison> listeCombinaison = calcul.calcDeplacementPossible(tableJeu, joueur);
        System.out.println("access");
        affichage.afficherTable(listeCombinaison);
        affichage.afficherDeplacements(listeCombinaison);
        int deplacement = joueur.saisirDeplacement();
        deplacerPiece(tableJeu, calcul, listeCombinaison, deplacement,joueur);
    }

    /**
     * Fonction qui vérifie si le jeu est terminé, si un des 2 joueurs à gagné contre l'autre
     * @return true si un joueur à gagné la portie
     */
    public static boolean jeuTermine(Joueur[] listeJoueur){
        return listeJoueur[0].getScore() >= MAX_POINT || listeJoueur[1].getScore() >= 12;
    }

    public Joueur getGagnant(Joueur joueur1, Joueur joueur2){
        if((joueur1.getScore() >= Jeu.MAX_POINT && joueur2.getScore() >=Jeu.MIN_ENNEMI_POINT) || (joueur2.getScore()>=MAX_POINT && joueur1.getScore()<MIN_ENNEMI_POINT)){
            return joueur1;
        } else if ((joueur1.getScore() < Jeu.MIN_ENNEMI_POINT && joueur2.getScore() >= Jeu.MAX_POINT) || (joueur1.getScore()>=MAX_POINT && joueur2.getScore()<MIN_ENNEMI_POINT)){
            return joueur2;
        }
        return null;
    }
    /**
     * l'utilisateur choisi un numéro et le déplacement est effectué en fonction de ce déplacement
     * @param listCombinaison : la liste des combinaisons possible pour le mouvement
     */
    public static void deplacerPiece(EtatCase[][] tableJeu, Calcul calcul, LinkedList<Combinaison> listCombinaison, int noDeplacement, Joueur joueur) {
        if(calcul.isDeplacementPossible(noDeplacement,listCombinaison)){
            for (int i = 0; i < tableJeu.length; i++) {
                for (int j = 0; j < tableJeu.length; j++) {
                    if (tableJeu[i][j] == joueur.getColor()) {
                        tableJeu[i][j] = EtatCase.LIBRE;
                    }
                }
            }
            tableJeu[listCombinaison.get(noDeplacement).getX1()][listCombinaison.get(noDeplacement).getY1()] = joueur.getColor();
            tableJeu[listCombinaison.get(noDeplacement).getX2()][listCombinaison.get(noDeplacement).getY2()] = joueur.getColor();
        } else {
            deplacerPiece(tableJeu, calcul, listCombinaison, joueur.saisirDeplacement(),joueur);
        }
    }
    /**
     * Fonction qui permet de vérifier si un joueur à gagner contre un autre joueur.
     * @return true si c'est le cas (score a 12 pour le premier joueur et score > 6 pour le second).
     */


    public EtatCase[][] getTableJeu(){ return tableJeu; }
    public Joueur[] getListeJoueur(){ return listeJoueur; }
    public Pion[] getListePion(){ return listePion; }

}
