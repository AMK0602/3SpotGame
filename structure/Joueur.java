package structure;

import jeu.GestionJeu;
import jeu.MouvementsJoueurs;

public class Joueur {
    /** Identifiant du joueur */
    private int identifiant;
    /** Score du joueur*/
    private int score;
    /** Couleur du joueur */
    private EtatCase couleur;
    /** Compteur du nombre de joueur dans la partie */
    private static int nbJoueur = 0;

    /** Constructeur de la Class */
    public Joueur() {
        this.identifiant = ++nbJoueur;
        this.score = 0;
    }

    /**
     * Permet de récupérer le score d'un joueur donnée
     * @return score : Le score du joueur indiqué
     */
    public int getScore() {return score;}

    /**
     * Permet de définir la couleur de la pièce de quelqu'un
     * @param color : la couleur choisi par le joueur
     */
    public void setColor(EtatCase color){ this.couleur = color; }
    /**
     * Permet de récupérer la couleur d'un joueur donnée
     * @return score : La couleur du joueur indiqué
     */
    public EtatCase getColor(){return this.couleur;}

    /**
     * Vérification si un joueur a pris une couleur déjà choisi
     * @param j : le joueur à comparer
     * @return true : si la couleur a déjà été choisi.
     */
    public boolean hasSameColor(Joueur j) {
        if(this.couleur == j.couleur){
            return true;
        } else {
            return false;
        }
    }

    public void jouerTour() {
        MouvementsJoueurs.deplacerPiece(GestionJeu.getTableJeu(), this);
    }
}