package jeu;

import structure.EtatCase;
import structure.Joueur;

import java.util.Scanner;

public class MouvementsJoueurs {
    private static int[][][] listMouvement; // Tableau des combinaisons possibles.
    private static int[][] mouvementsPossibles;
    private static int[][] combiPossible;
    private static int[] indices; // DEFINIR UNE TAILLE AVEC UN COMPTEUR ?
    private static int compteurDeMvt= 0;

    public static boolean combiExist(EtatCase[][] table, int x1, int y1, int x2, int y2, Joueur joueur){
        int lim_x = table.length;
        int lim_y = table[0].length;

        if((((x1 >= 0 && x1<lim_x) && (y1>=0 && y1<lim_y)) && ((x2>=0 && x2<lim_x)&&(y2>=0 && y2<lim_y))) && table[x1][y1] == EtatCase.LIBRE && (table[x2][y2] == EtatCase.LIBRE || table[x2][y2] == joueur.getColor())){
            return true;
        }
        return false;
    }
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
        //TODO simplifier la vérification en isMvtExist > verifie la case adjacente si EtatCase=LIBRE ou COULEUR
        if (ligne >= 0 && ligne < taill_ligne - 1 && colonne >= 0 && colonne < taille_col &&
                (table[ligne][colonne] == EtatCase.LIBRE || table[ligne][colonne] == joueur.getColor()) &&
                (table[ligne + 1][colonne] == EtatCase.LIBRE || table[ligne + 1][colonne] == joueur.getColor())) {
            return true;  // Déplacement possible vers le bas
        }
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
     *
     * @param table : table de jeu
     * @param joueur : le joueur dont on souhaite calculer les déplacement possibles
     */
    public static int[][][] calcDeplacementPossible(EtatCase[][] table, Joueur joueur) {
        listMouvement = new int[compteMvtPossibles(table, joueur)][2][2];
        int compteur = 0;
        for (int i = 0; i < table.length; i++) {
            //TODO debug ici : j doit etre adjacent a i
            for (int j = 0; j < table[0].length; j++) {
                if (isMvtPossible(table, i, j, joueur)) {
                    // Retenir le couple du mouvement possible sous forme ([0][0], [0][1])
                    listMouvement[compteur][0][0] = i; // ligne1
                    listMouvement[compteur][0][1] = j; // colonne1
                    //TODO debug ici
                    if(combiExist(table, i, j,i+1,j, joueur)){
                        listMouvement[compteur][1][0] = i+1; // ligne2
                        listMouvement[compteur][1][1] = j; // colonne2
                    }
                    if(combiExist(table, i, j,i,j+1, joueur)){
                        listMouvement[compteur][1][0] = i; // ligne2
                        listMouvement[compteur][1][1] = j+1; // colonne2
                    }
                    ++compteur;
                }
            }
        }

        return listMouvement;
    }

    /**
     * l'utilisateur choisi un numéro et le déplacement est effectué en fonction de ce déplacement
     * @param table : table de jeu
     */
    public static void deplacerPiece(EtatCase[][] table, Joueur joueur) {
        // afficher table des mouvements possibles
        Scanner sc = new Scanner(System.in);
        afficherDeplacements(calcDeplacementPossible(table, joueur));  // Utilise la nouvelle fonction pour afficher les combinaisons
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
    public static void afficherDeplacements(int[][][] tableau) {
        System.out.println("Couples de déplacements possibles : ");
        for (int i = 0; i < tableau.length; ++i) {
            System.out.println("([" + tableau[i][0][0] + "][" + tableau[i][0][1] + "], [" + tableau[i][1][0] + "][" + tableau[i][1][1] + "])");
            //int ligne1 = mouvementsPossibles[i][0];
            //int colonne1 = mouvementsPossibles[i][1];
            // Vérifier si le déplacement vers le bas (ligne+1) est possible
            /*if (ligne1 < table.length - 1 && table[ligne1 + 1][colonne1] == EtatCase.LIBRE) {
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
            }*/
        }
    }
}
