package jeu;

import structure.CombinaisonPossible;
import structure.EtatCase;

import java.util.ArrayList;
import java.util.LinkedList;

public class AffichageTable {

    public static void afficherTable(EtatCase[][] tablejeu, LinkedList<CombinaisonPossible> listeMouvement){
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
                System.out.print("*     "+tablejeu[0][i].getAlias()+"     ");
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
                System.out.print("*     "+tablejeu[1][i].getAlias()+"     ");
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
                System.out.print("*     "+tablejeu[2][i].getAlias()+"     ");
            }
        }
        System.out.print("*");
        System.out.println(" ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
    }

    public static int compteNbCombiParCase(LinkedList<CombinaisonPossible> listeCombinaison, int x, int y){
        int compteur=0;
        for (CombinaisonPossible combinaisonPossible : listeCombinaison) {
            if (combinaisonPossible.getX1() == x && combinaisonPossible.getY1() == y) {
                ++compteur;
            }
        }
        return compteur;
    }
    public static int getMooveIndex(LinkedList<CombinaisonPossible> listeCombinaison, int x, int y){
        for (int i=0; i<listeCombinaison.size();++i){
            if(listeCombinaison.get(i).getX1() == x && listeCombinaison.get(i).getY1() == y){
                return i+1;
            }
        }
        return x;
    }
}
