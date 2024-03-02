package jeu;

import structure.CombinaisonPossible;
import structure.EtatCase;
import structure.Joueur;
import structure.Pion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MouvementsJoueurs {
    private static LinkedList<CombinaisonPossible> listCombinaison;

    /**
     * Fonction qui permet de vérifier qu'un mouvement est possible entre 2 cases
     * @param table : la table de jeu
     * @param x1 : ligne de la première case
     * @param y1 : colonne de la première case
     * @param x2 : ligne de la deuxième case
     * @param y2 : colonne de la deuxième case
     * @param joueur : le joueur a qui ont va récupérer la couleur
     * @return
     */
    public static boolean combiExist(EtatCase[][] table, int x1, int y1, int x2, int y2, Joueur joueur){
        int lim_x = table.length;
        int lim_y = table[0].length;
        return (estAdjacent(table, x1, y1, x2, y2) &&
                ((x1 >= 0 && x1 < lim_x) && (y1 >= 0 && y1 < lim_y)) && // limite
                    ((x2 >= 0 && x2 < lim_x) && (y2 >= 0 && y2 < lim_y))) && // limite
                ((table[x1][y1] == EtatCase.LIBRE && (table[x2][y2] == EtatCase.LIBRE || table[x2][y2] == joueur.getColor())) ||
                    (table[x1][y1] == joueur.getColor() && table[x2][y2] == EtatCase.LIBRE ));
    }

    /**
     * Vérifier que 2 cases sont bien adjacente pour vérifier le mouvement
     * @param table : la table de jeu
     * @param x1 : ligne de la première case
     * @param y1 : colonne de la première case
     * @param x2 : ligne de la deuxième case
     * @param y2 : colonne de la deuxième case
     * @return true si les cases sont adjacente, false si elles ne le sont pas
     */
    public static boolean estAdjacent(EtatCase[][] table, int x1, int y1, int x2, int y2){
        return (x2 == x1 + 1 && y2 == y1) || (x2 == x1 && y2 == y1 + 1);
    }


    /*public static boolean isMvtPossible(EtatCase[][] table, int ligne, int colonne, Joueur joueur) {
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
    }*/

    /**
     * Permet de numérotter sur la case les déplacement possible
     * @param table : table de jeu
     * @param joueur : le joueur dont on souhaite calculer les déplacement possibles
     */
    public static LinkedList<CombinaisonPossible> calcDeplacementPossible(EtatCase[][] table, Joueur joueur) {
        listCombinaison = new LinkedList<>();
        int compteur = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                // Retenir le couple du mouvement possible sous forme ([0][0], [0][1])
                if (combiExist(table, i, j, i, j + 1, joueur)) {
                    CombinaisonPossible combinaison = new CombinaisonPossible(i,j,i,j+1);
                    listCombinaison.add(combinaison);
                    ++compteur;
                }
                if (combiExist(table, i, j, i + 1, j, joueur)) {
                    CombinaisonPossible combinaison = new CombinaisonPossible(i,j,i+1,j);
                    listCombinaison.add(combinaison);
                    ++compteur;
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

        System.out.print("Quel déplacement souhaitez-vous faire ? ");
        String resultat = sc.next();
        int numero = Integer.parseInt(resultat)-1;
        if(numero <= listCombinaison.size() && numero >= 0){
            for(int i =0;i<table.length;i++){
                for(int j=0;j<table.length;j++){
                    if(table[i][j] == joueur.getColor()){
                        table[i][j] = EtatCase.LIBRE;
                    }
                }
            }
            table[listCombinaison.get(numero).getX1()][listCombinaison.get(numero).getY1()] = joueur.getColor();
            table[listCombinaison.get(numero).getX2()][listCombinaison.get(numero).getY2()] = joueur.getColor();
        }else {
            deplacerPiece(table, joueur);
        }
    }

    public static void calculerPointGagne(EtatCase[][] tablejeu, Pion[] listePion, Joueur joueur) {
        for (int i=0; i< tablejeu.length;++i){
            for (int j=0; j< tablejeu.length;++j){
                if(tablejeu[i][j]== joueur.getColor()){
                    for(int k=0; k<listePion.length;++k){
                        if(listePion[k].getX() == i && listePion[k].getY() ==j){
                            joueur.incrementScore();
                        }
                    }
                }
            }
        }
    }

    public static void afficherDeplacements(LinkedList<CombinaisonPossible> tableau) {
        //System.out.println("Couples de déplacements possibles : ");
        for (int i = 0; i < tableau.size(); ++i) {
            int id_mouv = i+1;
            System.out.println("Le mouvement "+id_mouv+" est : ([" + tableau.get(i).getX1() + "][" + tableau.get(i).getY1() + "], [" + tableau.get(i).getX2() + "][" + tableau.get(i).getY2() + "])");
        }
    }

}
