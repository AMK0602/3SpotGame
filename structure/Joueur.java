package structure;

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

    /** Constructeur de la Class */
    public Joueur() {
        this.identifiant = ++nbJoueur;
        this.score = 0;
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
     * Fonction qui permet de vérifier si un joueur à gagner contre un autre joueur.
     * @param j2 : Le joueur avec qui on souhaite comparer le score
     * @return true si c'est le cas (score a 12 pour le premier joueur et score > 6 pour le second).
     */
    public boolean aGagneContre(Joueur j2){
        if(score >= 12 && j2.getScore() >=6){
            return true;
        } else return score < 6 && j2.getScore() >= 12;
    }

    /**
     * l'utilisateur choisi un numéro et le déplacement est effectué en fonction de ce déplacement
     * @param table : table de jeu
     * @param listCombinaison : la liste des combinaisons possible pour le mouvement
     */
    public void deplacerPiece(EtatCase[][] table, LinkedList<Combinaison> listCombinaison) {
        // afficher table des mouvements possibles
        Scanner sc = new Scanner(System.in);

        System.out.print("Quel déplacement souhaitez-vous faire ? ");
        String resultat = sc.next();
        int numero = Integer.parseInt(resultat)-1;
        if(numero <= listCombinaison.size() && numero >= 0){
            for(int i =0;i<table.length;i++){
                for(int j=0;j<table.length;j++){
                    if(table[i][j] == this.getColor()){
                        table[i][j] = EtatCase.LIBRE;
                    }
                }
            }
            table[listCombinaison.get(numero).getX1()][listCombinaison.get(numero).getY1()] = this.getColor();
            table[listCombinaison.get(numero).getX2()][listCombinaison.get(numero).getY2()] = this.getColor();
        }else {
            this.deplacerPiece(table, listCombinaison);
        }
    }
}