package structure;

public enum EtatCase {
    ROUGE('R'),
    BLEU('B'),
    NEUTRE('N'),
    LIBRE(' ');

    /** Raccourcis/Alias utilisé par une couleur pour l'affichage de la table */
    private char alias;
    EtatCase(char alias){
        this.alias = alias;
    }

    /**
     * Permet de récupérer l'alias d'une couleur donnée
     * @return alias : l'alias de la couleur
     */
    public char getAlias(){ return alias;}
}
