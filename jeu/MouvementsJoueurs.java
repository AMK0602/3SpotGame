package jeu;

import structure.EtatCase;
import structure.Joueur;

import java.util.Scanner;

public class MouvementsJoueurs {
    private static int[][] mouvementsPossibles;
    private static int[][] combiPossible;
    private static int[] indices; // DEFINIR UNE TAILLE AVEC UN COMPTEUR ?
    private static int compteurDeMvt= 0;
    public static boolean isMvtPossible(EtatCase[][] table, int ligne, int colonne, Joueur joueur) {
        int taill_ligne = table.length;
        int taille_col = table[0].length;

        /**
         *   0 1 2
         * 0 x x x
         * 1 x x x
         * 2 x x x
         * si i(ligne)=0 et j(colonne)=0
         * ( (0>=0 & 0<2 & col>=0 & col<2) &&(00=LIBRE || 00=j.COLOR) && (10=LIBRE || 10=j.COLOR) )
         */
        if (ligne >= 0 && ligne < taill_ligne - 1 && colonne >= 0 && colonne < taille_col &&
                (table[ligne][colonne] == EtatCase.LIBRE || table[ligne][colonne] == joueur.getColor()) &&
                (table[ligne + 1][colonne] == EtatCase.LIBRE || table[ligne + 1][colonne] == joueur.getColor())) {
            return true;  // Déplacement possible vers le bas
        }

        /**
         *
         */
        if (colonne >= 0 && colonne < taille_col - 1 && ligne >= 0 && ligne < taill_ligne &&
                (table[ligne][colonne] == EtatCase.LIBRE || table[ligne][colonne] == joueur.getColor()) &&
                (table[ligne][colonne + 1] == EtatCase.LIBRE || table[ligne][colonne + 1] == joueur.getColor())) {
            return true;  // Déplacement possible vers la droite
        }

        if (ligne > 0 && ligne < taill_ligne && colonne >= 0 && colonne < taille_col &&
                (table[ligne][colonne] == EtatCase.LIBRE || table[ligne][colonne] == joueur.getColor()) &&
                (table[ligne - 1][colonne] == EtatCase.LIBRE || table[ligne - 1][colonne] == joueur.getColor())) {
            return true;  // Déplacement possible vers le haut
        }

        if (colonne > 0 && colonne < taille_col && ligne >= 0 && ligne < taill_ligne &&
                (table[ligne][colonne] == EtatCase.LIBRE || table[ligne][colonne] == joueur.getColor()) &&
                (table[ligne][colonne - 1] == EtatCase.LIBRE || table[ligne][colonne - 1] == joueur.getColor())) {
            return true;  // Déplacement possible vers la gauche
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
    public static int[][] calcDeplacementPossible(EtatCase[][] table, Joueur joueur) {
        combiPossible = new int[compteMvtPossibles(table, joueur)][4]; // tableau à deux dimensions

        int compteur = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (isMvtPossible(table, i, j, joueur)) {
                    // Retenir le couple du mouvement possible sous forme ([0][0], [0][1])
                    combiPossible[compteur][0] = i; // ligne1
                    combiPossible[compteur][1] = j; // colonne1
                    combiPossible[compteur][2] = i + 1; // ligne2
                    combiPossible[compteur][3] = j; // colonne2
                    ++compteur;
                }
            }
        }

        return combiPossible;
    }

    /**
     * l'utilisateur choisi un numéro et le déplacement est effectué en fonction de ce déplacement
     * @param table : table de jeu
     */
    public static void deplacerPiece(EtatCase[][] table, Joueur joueur) {
        // afficher table des mouvements possibles


        Scanner sc = new Scanner(System.in);
        printCombi(calcDeplacementPossible(table, joueur));  // Utilise la nouvelle fonction pour afficher les combinaisons
        System.out.print("Quel déplacement souhaitez-vous faire ? ");
        String resultat = sc.next();
        int numero = Integer.parseInt(resultat);
        for (int i = 0; i < combiPossible.length; ++i) {
            for(int j = 0; j<combiPossible.length;++j){
                if (combiPossible[i][j] == numero) {
                    return;
                    // Mettre à jour la position
                }
            }
        }
        System.out.println("Numéro invalide !");
    }
    public static void afficherDeplacements(EtatCase[][] table) {
        System.out.println("Couples de déplacements possibles : ");
        for (int i = 0; i < mouvementsPossibles.length; ++i) {
            int ligne1 = mouvementsPossibles[i][0];
            int colonne1 = mouvementsPossibles[i][1];
            // Vérifier si le déplacement vers le bas (ligne+1) est possible
            if (ligne1 < table.length - 1 && table[ligne1 + 1][colonne1] == EtatCase.LIBRE) {
                int ligne2 = ligne1 + 1;
                int colonne2 = colonne1;
                System.out.println("([" + ligne1 + "][" + colonne1 + "], [" + ligne2 + "][" + colonne2 + "])");
            }
            // Vérifier si le déplacement vers la gauche (colonne-1) est possible
            if (colonne1 > 0 && table[ligne1][colonne1 - 1] == EtatCase.LIBRE) {
                int ligne2 = ligne1;
                int colonne2 = colonne1 - 1;
                System.out.println("([" + ligne1 + "][" + colonne1 + "], [" + ligne2 + "][" + colonne2 + "])");
            }
            // Vérifier si le déplacement vers la droite (colonne+1) est possible
            if (colonne1 < table[0].length - 1 && table[ligne1][colonne1 + 1] == EtatCase.LIBRE) {
                int ligne2 = ligne1;
                int colonne2 = colonne1 + 1;
                System.out.println("([" + ligne1 + "][" + colonne1 + "], [" + ligne2 + "][" + colonne2 + "])");
            }
            // Vérifier si le déplacement vers le haut (ligne-1) est possible
            if (ligne1 > 0 && table[ligne1 - 1][colonne1] == EtatCase.LIBRE) {
                int ligne2 = ligne1 - 1;
                int colonne2 = colonne1;
                System.out.println("([" + ligne1 + "][" + colonne1 + "], [" + ligne2 + "][" + colonne2 + "])");
            }


        }
    }
    public static void printCombi(int[][] combiPossible) {
        System.out.println("Couples de déplacements possibles : ");
        for (int i = 0; i < combiPossible.length; ++i) {
            int ligne1 = combiPossible[i][0]; // case 1
            int colonne1 = combiPossible[i][1]; // case 1
            int ligne2 = combiPossible[i][2]; // case 2
            int colonne2 = combiPossible[i][3]; // case 2
            System.out.println("([" + ligne1 + "][" + colonne1 + "], [" + ligne2 + "][" + colonne2 + "])");
        }
    }



}
