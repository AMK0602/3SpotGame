package jeu;

import structure.CombinaisonPossible;
import structure.EtatCase;
import structure.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

public class MouvementsJoueurs {
    private static ArrayList<CombinaisonPossible> listCombinaison;

    public static boolean combiExist(EtatCase[][] table, int x1, int y1, int x2, int y2, Joueur joueur){
        int lim_x = table.length;
        int lim_y = table[0].length;
        return (estAdjacent(table, x1, y1, x2, y2) && ((x1 >= 0 && x1 < lim_x) && (y1 >= 0 && y1 < lim_y)) && ((x2 >= 0 && x2 < lim_x) && (y2 >= 0 && y2 < lim_y))) && (table[x1][y1] == EtatCase.LIBRE && (table[x2][y2] == EtatCase.LIBRE || table[x2][y2] == joueur.getColor()));
    }
    public static boolean estAdjacent(EtatCase[][] table, int x1, int y1, int x2, int y2){
        int lim_x = table.length;
        int lim_y = table[0].length;
        // verif case adjacente
        return (x2 == x1 + 1 && y2 == y1) || (x2 == x1 && y2 == y1 + 1);
    }
    public static boolean isMvtPossible(EtatCase[][] table, int ligne, int colonne, Joueur joueur) {
        int taill_ligne = table.length;
        int taille_col = table[0].length;

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

    /**
     * Permet de numérotter sur la case les déplacement possible
     * @param table : table de jeu
     * @param joueur : le joueur dont on souhaite calculer les déplacement possibles
     */
    public static ArrayList<CombinaisonPossible> calcDeplacementPossible(EtatCase[][] table, Joueur joueur) {
        listCombinaison = new ArrayList<>();
        int compteur = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                // Retenir le couple du mouvement possible sous forme ([0][0], [0][1])
                if (isMvtPossible(table, i, j, joueur)) {
                    if (combiExist(table, i, j, i, j + 1, joueur)) {
                        CombinaisonPossible combinaison = new CombinaisonPossible(i,j,i,j+1);
                        listCombinaison.add(combinaison);
                        System.out.println(compteur+1);
                        ++compteur;
                    }
                    if (combiExist(table, i, j, i + 1, j, joueur)) {
                        CombinaisonPossible combinaison = new CombinaisonPossible(i,j,i+1,j);
                        listCombinaison.add(combinaison);
                        System.out.println(compteur+1);
                        ++compteur;
                    }
                }
            }
        }
        return listCombinaison;
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
        System.out.println("Numéro invalide !");
    }
    public static void afficherDeplacements(ArrayList<CombinaisonPossible> tableau) {
        System.out.println("Couples de déplacements possibles : ");
        for (int i = 0; i < tableau.size(); ++i) {
            int id_mouv = i+1;
            System.out.println("Le mouvement "+id_mouv+" est : ([" + tableau.get(i).getX1() + "][" + tableau.get(i).getY1() + "], [" + tableau.get(i).getX2() + "][" + tableau.get(i).getY2() + "])");
        }
    }

}
