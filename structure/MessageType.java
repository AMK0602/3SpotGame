package structure;

public enum MessageType {
    ERR_COULEUR_UTILISE("Couleur déjà utilisé ! Saisissez une couleur valide ! "),
    ERR_COULEUR_INEXISTANTE("Couleur incorrect, ré-essayez : "),
    CHOIX_COULEUR("Quelle couleur voulez vous choisir ? ROUGE ou BLEU : "),
    LISTE_COMBI("Voici les mouvement possibles :\n"),
    SAISIR_DEPLACEMENT("Saisissez le numéro de votre mouvement : ");

    private String message;

    MessageType(String message){
        this.message = message;
    }

    public void afficherMessage(){
        System.out.print(this.message);
    }
    //TODO FONCTION SPECIFIQUE AFFICHAGE ERREUR
}
