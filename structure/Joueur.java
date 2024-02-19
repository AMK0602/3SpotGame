package structure;

import jeu.EtatCase;

public class Joueur {
    private int identifiant;
    private int score;
    private EtatCase couleur;
    private static int nbJoueur = 0;
    public Joueur(EtatCase couleur) {
        this.identifiant = ++nbJoueur;
        this.score = 0;
        this.couleur = couleur;
    }
    public int getScore() {return score;}
}
