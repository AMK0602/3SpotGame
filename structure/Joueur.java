package structure;

import jeu.Jeu;

import java.util.LinkedList;
import java.util.Scanner;

public class Joueur {
    /** Identifiant du joueur */
    private int identifiant;
    /** Score du joueur*/
    private int score;
    /** Couleur du joueur, correspondant a un Etat de case */
    private EtatCase couleur;
    /** Compteur du nombre de joueur dans la partie */
    private static int nbJoueur = 0;

    /** Constructeur de la Classe */
    public Joueur(EtatCase couleur) {
        this.score = 0;
        this.couleur = couleur;
        ++nbJoueur;
        this.identifiant = nbJoueur;
    }
    /** Constructeur de la Classe */
    public Joueur(){
        this.score = 0;
        this.couleur = EtatCase.NEUTRE;
        ++nbJoueur;
        this.identifiant = nbJoueur;
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
     * Permet de récupérer l'identifiant du joueur
     * @return this.identifiant, correspondant au score du joueur
     */
    public int getIdentifiant(){return this.identifiant;}

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
     * Fonction qui permet de saisir le numéro d'un mouvement possible
     * @return resultat si le nombre est un entier, saisirDeplacement() si il y a une erreur de format
     */
    public int saisirDeplacement(){
        Scanner sc = new Scanner(System.in);
        MessageType.SAISIR_DEPLACEMENT.afficherMessage();
        String resultat = sc.next();
        try {
            return Integer.parseInt(resultat)-1;
        } catch (NumberFormatException exception){
            saisirDeplacement();
        }
        return 0;
    }

}