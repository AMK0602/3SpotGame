package jeu;

import structure.Combinaison;
import structure.EtatCase;
import structure.Pion;

import java.util.LinkedList;

public class Affichage {

    /**
     * Permet d'afficher la table avec l'Etat de la table et les mouvement possible pour chaque joueur
     * @param tablejeu : la table de jeu
     * @param listeMouvement : la liste contenant la liste des mouvements
     */
    public void afficherTable(EtatCase[][] tablejeu, LinkedList<Combinaison> listeMouvement, Pion[] listePion){
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        for(int i=0; i< tablejeu.length;++i){ // 0 ->2 : 0 1 2
            int nbMouvement = compteNbCombiParCase(listeMouvement,0,i);
            if(nbMouvement>1){
                System.out.print("*    ");
                    System.out.print(getMooveIndex(listeMouvement,0,i));
                    System.out.print("-");
                    int index2 = getMooveIndex(listeMouvement,0,i)+1;
                    System.out.print(index2);
                System.out.print("    ");
            } else if (nbMouvement==1) {
                System.out.print("*     "+getMooveIndex(listeMouvement,0,i)+"     ");
            } else {
                if (Calcul.contientPion(listePion, 0, i) && (tablejeu[0][i] != EtatCase.BLEU && tablejeu[0][i] != EtatCase.ROUGE &&tablejeu[0][i] != EtatCase.NEUTRE)) {
                    System.out.print("*     O     ");
                } else {
                    System.out.print("*     " + tablejeu[0][i].getAlias() + "     ");
                }
            }
        }
        System.out.println("*");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        for(int i=0; i< tablejeu.length;++i){ // 0 ->2 : 0 1 2
            int nbMouvement = compteNbCombiParCase(listeMouvement,1,i);
            if(nbMouvement>1){
                System.out.print("*    ");
                    System.out.print(getMooveIndex(listeMouvement,1,i));
                    System.out.print("-");
                    int index2 = getMooveIndex(listeMouvement,1,i)+1;
                    System.out.print(index2);
                System.out.print("    ");
            } else if (nbMouvement==1) {
                System.out.print("*     "+getMooveIndex(listeMouvement,1,i)+"     ");
            } else {
                if (Calcul.contientPion(listePion, 1, i ) && (tablejeu[1][i] != EtatCase.BLEU && tablejeu[1][i] != EtatCase.ROUGE &&tablejeu[1][i] != EtatCase.NEUTRE)) {
                    System.out.print("*     O     ");
                } else {
                    System.out.print("*     " + tablejeu[1][i].getAlias() + "     ");
                }
            }
        }
        System.out.print("*");
        System.out.println(" ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        for(int i=0; i< tablejeu.length;++i){ // 0 ->2 : 0 1 2
            int nbMouvement = compteNbCombiParCase(listeMouvement,2,i);
            if(nbMouvement>1){
                System.out.print("*    ");
                    System.out.print(getMooveIndex(listeMouvement,2,i));
                    System.out.print("-");
                    int index2 = getMooveIndex(listeMouvement,2,i)+1;
                    System.out.print(index2);
                System.out.print("    ");
            } else if (nbMouvement==1) {
                System.out.print("*     "+getMooveIndex(listeMouvement,2,i)+"     ");
            } else {
                if (Calcul.contientPion(listePion, 2, i) && (tablejeu[2][i] != EtatCase.BLEU && tablejeu[2][i] != EtatCase.ROUGE &&tablejeu[2][i] != EtatCase.NEUTRE)) {
                    System.out.print("*     O     ");
                } else {
                    System.out.print("*     " + tablejeu[2][i].getAlias() + "     ");
                }
            }
        }
        System.out.print("*");
        System.out.println(" ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
    }

    /**
     * permet d'afficher la liste des mouvements possibles
     * @param tableau : la liste des mouvements possibles avec les positions des cases
     */
    public void afficherDeplacements(LinkedList<Combinaison> tableau) {
        //System.out.println("Couples de déplacements possibles : ");
        for (int i = 0; i < tableau.size(); ++i) {
            int id_mouv = i+1;
            System.out.println("Le mouvement "+id_mouv+" est : ([" + tableau.get(i).getX1() + "][" + tableau.get(i).getY1() + "], [" + tableau.get(i).getX2() + "][" + tableau.get(i).getY2() + "])");
        }
    }

    /**
     * Fonction qui permet d'obtenir le nombre de mouvement possibles pour une case donné
     * @param listeCombinaison : la liste contenant les mouvements possible
     * @param x : la ligne de la case
     * @param y : la colonne de la case
     * @return compteur : le nombre de mouvements trouvés
     */
    public static int compteNbCombiParCase(LinkedList<Combinaison> listeCombinaison, int x, int y){
        int compteur=0;
        for (Combinaison combinaisonPossible : listeCombinaison) {
            if (combinaisonPossible.getX1() == x && combinaisonPossible.getY1() == y) {
                ++compteur;
            }
        }
        return compteur;
    }

    /**
     * Permet d'obtenir l'index dans le tableau de position d'un mouvement pour une ligne et une colonne donné pour l'affichage
     * @param listeCombinaison : la liste des mouvements possibles
     * @param x : la ligne du mouvement
     * @param y : la colonne du mouvement
     * @return i+1 quand on trouve le mouvement ou x si le mouvement n'est pas trouvé (cela n'arrive jamais)
     */
    public static int getMooveIndex(LinkedList<Combinaison> listeCombinaison, int x, int y){
        for (int i=0; i<listeCombinaison.size();++i){
            if(listeCombinaison.get(i).getX1() == x && listeCombinaison.get(i).getY1() == y){
                return i+1;
            }
        }
        return x;
    }
}
