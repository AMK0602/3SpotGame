package structure;

public class CombinaisonPossible {
    /** Ligne de la première case */
    private int x1;
    /** Colonne de la première case */
    private int y1;
    /** Ligne de la deuxième case */
    private int x2;
    /** Colonne de la deuxième case */
    private int y2;

    /** Constructeur de la Class */
    public CombinaisonPossible(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /**
     * Permet de récupérer la ligne de la première case
     * @return x1 : la ligne de la case
     */
    public int getX1(){ return x1;}

    /**
     * Permet de récupérer la ligne de la deuxième case
     * @return x2 : la ligne de la case
     */
    public int getX2() {
        return x2;
    }

    /**
     * Permet de récupérer la colonne de la première case
     * @return y1 : la colonne de la case
     */
    public int getY1() {
        return y1;
    }

    /**
     * Permet de récupérer la colonne de la première case
     * @return y2 : la colonne de la case
     */
    public int getY2() {
        return y2;
    }
}
