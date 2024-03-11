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
    private Affichage affichage;
    private Calcul calcul;

    /**
     * Fonction principale qui permet de gérer le bon déroulement du jeu, d'une partie
     */
    public void jouerJeu(){
        tableJeu = initTable();
        listeJoueur = initJoueurs();
        listePion = initPion();

        Calcul calcul = new Calcul(this);
        affichage = new Affichage(this);

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
        System.out.println(getGagnant(listeJoueur[0],listeJoueur[1]));
        affichage.afficherGagnant(getGagnant(listeJoueur[0],listeJoueur[1]));
    }

    /**
     * Fonction permettant de jouer un coup
     * @param joueur Le joueur à qui c'est le tour
     * @param calcul fait référence à notre classe Calcul
     * @param tableJeu notre table de jeu
     * @param affichage fait référence à notre classe Affichage
     */
    public static void jouerCoup(Joueur joueur, Calcul calcul, EtatCase[][] tableJeu, Affichage affichage){
        /** La listes des mouvements possibles avec les positions des cases */
        LinkedList<Combinaison> listeCombinaison = calcul.calcDeplacementPossible(tableJeu, joueur);
        affichage.afficherTable(listeCombinaison);
        affichage.afficherDeplacements(listeCombinaison);
        deplacerPiece(tableJeu, calcul, listeCombinaison,joueur.saisirDeplacement(),joueur);
    }

    /**
     * Fonction qui vérifie si le jeu est terminé, si un des 2 joueurs à gagné contre l'autre
     * @return true si un joueur à gagné la portie
     */
    public static boolean jeuTermine(Joueur[] listeJoueur){
        return listeJoueur[0].getScore() >= MAX_POINT || listeJoueur[1].getScore() >= MAX_POINT;
    }

    /**
     * Permet de récupérer le joueur qui à gagner entre les deux joueurs
     * @param joueur1 le premier joueur
     * @param joueur2 le second joueur
     * @return joueur1 ou joueur2 en fonction du vainqueur
     */
    public static Joueur getGagnant(Joueur joueur1, Joueur joueur2){
        if((joueur1.getScore() >= MAX_POINT && joueur2.getScore() >= MIN_ENNEMI_POINT) || (joueur2.getScore()>=MAX_POINT && joueur1.getScore()<MIN_ENNEMI_POINT)){
            return joueur1;
        } else {
            return joueur2;
        }
    }

    /**
     * Fonction qui permet d'effectuer le déplacement pour un mouvement donné
     * @param tableJeu notre table de jeu
     * @param calcul fait référence à notre classe Calcul
     * @param listeCombinaison la liste contenant les déplacement possibles du joueur
     * @param noDeplacement le numéro du mouvement indiqué
     * @param joueur le joueur à qui c'est le tour
     */
    public static void deplacerPiece(EtatCase[][] tableJeu, Calcul calcul,LinkedList<Combinaison> listeCombinaison, int noDeplacement, Joueur joueur) {
        if(calcul.isDeplacementPossible(noDeplacement,listeCombinaison)){
            for (int i = 0; i < tableJeu.length; i++) {
                for (int j = 0; j < tableJeu.length; j++) {
                    if (tableJeu[i][j] == joueur.getColor()) {
                        tableJeu[i][j] = EtatCase.LIBRE;
                    }
                }
            }
            tableJeu[listeCombinaison.get(noDeplacement).getX1()][listeCombinaison.get(noDeplacement).getY1()] = joueur.getColor();
            tableJeu[listeCombinaison.get(noDeplacement).getX2()][listeCombinaison.get(noDeplacement).getY2()] = joueur.getColor();
        } else {
            deplacerPiece(tableJeu, calcul, listeCombinaison,joueur.saisirDeplacement(),joueur);
        }
    }

    /**
     * Permet de récupérer notre table de jeu
     * @return tablejeu : la table de jeu
     */
    public EtatCase[][] getTableJeu(){ return tableJeu; }

    /**
     * Permet de récupérer la liste des joueurs qui jouent
     * @return listeJoueur : la liste des joueurs qui jouent
     */
    public Joueur[] getListeJoueur(){ return listeJoueur; }

    /**
     * Permet de récupérer la liste qui contient les pions rapportant des points
     * @return listePion : la liste des pions
     */
    public Pion[] getListePion(){ return listePion; }

}
