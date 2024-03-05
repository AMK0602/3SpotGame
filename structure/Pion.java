package structure;

public class Pion {
    /** Ligne de la case */
    private int x;
    /** colonne de la case */
    private int y;
    /** Compteur de pion dans la liste de pion */
    private static int nbPion = 0;

    /** Constructeur de la Class */
    public Pion(int x, int y, Pion[] listePion){
        this.x = x;
        this.y = y;
        listePion[nbPion] = this;
        ++nbPion;
    }

    /**
     * Permet de récupérer la ligne de la case où se situe le pion
     * @return x : la ligne de la case
     */
    public int getX() { return x; }

    /**
     * Permet de récupérer la colonne de la case où se situe le pion
     * @return y : la colonne de la case
     */
    public int getY() { return y; }
}
