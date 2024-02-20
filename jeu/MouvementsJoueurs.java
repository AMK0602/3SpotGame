package jeu;

import structure.EtatCase;
import structure.Joueur;

import java.util.Scanner;

public class MouvementsJoueurs {
    private static int[] indices; // DEFINIR UNE TAILLE AVEC UN COMPTEUR ?
    private static int compteurDeMvt= 0;
    public static boolean isMvtPossible(EtatCase[][] table, int ligne, int colonne, Joueur joueur) {
        int taill_ligne = table.length;
        int taille_col = table[0].length;

        if (ligne >= 0 && ligne < taill_ligne - 1 && colonne >= 0 && colonne < taille_col && table[ligne][colonne] == EtatCase.LIBRE &&
                (table[ligne + 1][colonne] == EtatCase.LIBRE || table[ligne + 1][colonne] == joueur.getColor())) {
            return true;
        }

        if (colonne >= 0 && colonne < taille_col - 1 && ligne >= 0 && ligne < taill_ligne && table[ligne][colonne] == EtatCase.LIBRE &&
                (table[ligne][colonne + 1] == EtatCase.LIBRE || table[ligne][colonne + 1] == joueur.getColor())) {
            return true;
        }

        return false;
    }

    public static int compteMvtPossibles(EtatCase[][] table, Joueur joueur) {

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (isMvtPossible(table, i, j, joueur)) {
                    compteurDeMvt++;
                }
            }
        }
        return compteurDeMvt;
    }

    /**
     * Permet de numérotter sur la case les déplacement possible
     * @param table : table de jeu
     */
    public static void calcDeplacementPossible(EtatCase[][] table, Joueur joueur){
        indices = new int[compteMvtPossibles(table, joueur)];
        int compteur = 0;
        for(int i =0; i<table.length;i++){
            for(int j=0;j<table[0].length;j++){
                if(isMvtPossible(table, i, j, joueur)){
                    // Mettre un num à la case sur l'affichage avec compteur
                    //TODO affichage TABLE avec les mouvement possible (compteur) a la place de LIBRE
                    //TODO retenir le couple du mouvement possible sous forme ( [0][0],[0][1] )
                    indices[compteur] = compteur+1; // retient le numero du mouvement possible
                    ++compteur;
                }
            }
        }
    }

    /**
     * l'utilisateur choisi un numéro et le déplacement est effectué en fonction de ce déplacement
     * @param table : table de jeu
     */
    public static void deplacerPiece(EtatCase[][] table, Joueur joueur){

        // afficher table des mouvement possible
        System.out.println("debug1");
        calcDeplacementPossible(table, joueur);
        for (int i=0; i<indices.length;++i){
            System.out.println(indices[i]);
        }
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Quelle deplacement souhaitez vous faire ? ");
        String resultat = sc.next();
        int numero = Integer.parseInt(resultat);
        for(int i =0; i<indices.length;++i){
            if(indices[i]==numero){
                System.out.println("ok");
                return;
                //Mettre à jour la position
            }
            else{
                System.out.println("Numéro invalide !");
            }
        }


        }

}
