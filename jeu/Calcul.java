package jeu;

import structure.Combinaison;
import structure.EtatCase;
import structure.Joueur;
import structure.Pion;

import java.util.LinkedList;

import static structure.Combinaison.estAdjacent;

public class Calcul {

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
        return (estAdjacent(x1, y1, x2, y2) &&
                ((x1 >= 0 && x1 < lim_x) && (y1 >= 0 && y1 < lim_y)) && // limite
                ((x2 >= 0 && x2 < lim_x) && (y2 >= 0 && y2 < lim_y))) && // limite
                ((table[x1][y1] == EtatCase.LIBRE && (table[x2][y2] == EtatCase.LIBRE || table[x2][y2] == joueur.getColor())) ||
                        (table[x1][y1] == joueur.getColor() && table[x2][y2] == EtatCase.LIBRE ));
    }

    /**
     * Permet de numérotter sur la case les déplacement possible
     * @param table : table de jeu
     * @param joueur : le joueur dont on souhaite calculer les déplacement possibles
     * @return listCombinaison : la liste des combinaison possible qu'on a rempli
     */
    public LinkedList<Combinaison> calcDeplacementPossible(EtatCase[][] table, Joueur joueur) {
        /** Liste qui stocke les mouvements possibles d'un joueur */
        LinkedList<Combinaison> listCombinaison = new LinkedList<>();
        int compteur = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                // Retenir le couple du mouvement possible sous forme ([0][0], [0][1])
                if (combiExist(table, i, j, i, j + 1, joueur)) {
                    Combinaison combinaison = new Combinaison(i,j,i,j+1);
                    listCombinaison.add(combinaison);
                    ++compteur;
                }
                if (combiExist(table, i, j, i + 1, j, joueur)) {
                    Combinaison combinaison = new Combinaison(i,j,i+1,j);
                    listCombinaison.add(combinaison);
                    ++compteur;
                }
            }
        }
        return listCombinaison;
    }
    /**
     * Fonction qui permet de calculer le nombre de point gagné par un joueur. Vérifier si sa couleur est sur un pion
     * @param tablejeu : la table de jeu
     * @param listePion : la liste de position des pions qui rapporte des points
     * @param joueur : le joueur dont on souhaite récupérer la couleur.
     */
    public void calculerPointGagne(EtatCase[][] tablejeu, Pion[] listePion, Joueur joueur) {
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

}
