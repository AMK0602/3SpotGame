package structure;

public enum EtatCase {
    ROUGE('R'),
    BLEU('B'),
    NEUTRE('N'),
    LIBRE(' ');

    private char alias;
    EtatCase(char alias){
        this.alias = alias;
    }

    public char getAlias(){ return alias;}
}
