package structure;

public class Joueur {
    /** Identifiant du joueur */
    private int identifiant;
    /** Score du joueur*/
    private int score;
    /** Couleur du joueur, correspondant a un Etat de case */
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
     * Permet de récupérer la couleur d'un joueur donnée
     * @return score : La couleur du joueur indiqué
     */
    public EtatCase getColor(){return this.couleur;}

    /**
     * Permet de définir la couleur de la pièce de quelqu'un
     * @param color : la couleur choisi par le joueur
     */

    public void setColor(EtatCase color){ this.couleur = color; }

    /**
     * Fonction qui permet d'incrémenter de 1 le score du joueur
     */
    public void incrementScore(){
        this.score+=1;
    }

    /**
     * Vérification si un joueur a pris une couleur déjà choisi
     * @param j : le joueur à comparer
     * @return true : si la couleur a déjà été choisi.
     */
    public boolean hasSameColor(Joueur j) {
        return this.couleur == j.couleur;
    }

    /**
     * Fonction qui permet de vérifier si un joueur à gagner contre un autre joueur.
     * @param j2 : Le joueur avec qui on souhaite comparer le score
     * @return true si c'est le cas (score a 12 pour le premier joueur et score > 6 pour le second).
     */
    public boolean aGagneContre(Joueur j2){
        if(score >= 12 && j2.getScore() >=6){
            return true;
        } else return score < 6 && j2.getScore() >= 12;
    }
}