package structure;

/**
 * Enumération pour les messages types du jeu
 * @author HOUY Ethan - KHABBAZ Amine
 */
public enum MessageType {
    ERR_COULEUR_UTILISE("Couleur déjà utilisé ! Saisissez une couleur valide ! "),
    ERR_COULEUR_INEXISTANTE("Couleur incorrect, ré-essayez : "),
    CHOIX_COULEUR("Quelle couleur voulez vous choisir ? ROUGE ou BLEU : "),
    LISTE_COMBI("Voici les mouvement possibles :\n"),
    SAISIR_DEPLACEMENT("Saisissez le numéro de votre mouvement : "),
    SEPARATEUR("-------------------------------------\n"),
    SCORE_JOUEUR("Score du joueur "),
    VICTOIRE_JOUEUR("Victoire du joueur ");

    /** Message associé au code */
    private String message;

    /** Constructeur de la classe */
    MessageType(String message){
        this.message = message;
    }

    /**
     * Permet d'afficher le message correspondant pour un code de message donné
     */
    public void afficherMessage(){
        System.out.print(this.message);
    }

    /**
     * Permet de récupérer le message pour le réutiliser pour un code de message donné
     * @return this.message : la valeur du message associé au code
     */
    public String getMessage(){
        return this.message;
    }
}
