package structure;

/**
 * Enumération pour l'état possible des cases
 * @author HOUY Ethan - KHABBAZ Amine
 */
public enum EtatCase {
    ROUGE('R', "ROUGE"),
    BLEU('B', "BLEU"),
    NEUTRE('W', "NEUTRE"),
    LIBRE(' ', " ");

    /** Raccourcis/Alias utilisé par une couleur pour l'affichage de la table */
    private char alias;
    /** Nom de la couleur utilisé pour définir le nom du joueur */
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

    /**
     * Permet d'obtenir le nom de la couleur pour une couleur donnée
     * @return nomPiece : le nom de la couleur, de la pièce
     */
    public String getNomPiece() {
        return nomPiece;
    }
}