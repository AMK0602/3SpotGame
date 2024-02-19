package structure;

public class Joueur {
    private int identifiant;
    private int score;
    private EtatCase couleur;
    private static int nbJoueur = 0;
    public Joueur() {
        this.identifiant = ++nbJoueur;
        this.score = 0;
    }
    public int getScore() {return score;}
    public void setColor(EtatCase color){ this.couleur = color; }
}
