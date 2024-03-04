package structure;

public enum EtatCase {
    ROUGE('R', "ROUGE"),
    BLEU('B', "BLEU"),
    NEUTRE('N', "NEUTRE"),
    LIBRE(' ', " ");

    /** Raccourcis/Alias utilisé par une couleur pour l'affichage de la table */
    private char alias;
    private String nomPiece;

    /** Constructeur de l'Enumération */
    EtatCase(char alias, String nomPiece){
        this.alias = alias;
        this.nomPiece = nomPiece;
    }

    /**
     * Permet de récupérer l'alias d'une couleur donnée
     * @return alias : l'alias de la couleur
     */
    public char getAlias(){ return alias;}

    public String getNomPiece() {
        return nomPiece;
    }
}
