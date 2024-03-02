package structure;

public class Pion {
    /** Ligne de la case */
    private int x;
    /** colonne de la case */
    private int y;

    /** Constructeur de la Class */
    public Pion(int x, int y){
        this.x = x;
        this.y = y;
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
