package jeu;

import structure.CombinaisonPossible;
import structure.EtatCase;

import java.util.ArrayList;

public class AffichageTable {

    public static void afficherTable(EtatCase[][] tablejeu, ArrayList<CombinaisonPossible> listeMouvement){
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        for(int i=0; i< tablejeu.length;++i){
            if(listeMouvement.size() >0){
                for(int j=0;j<listeMouvement.size();++j){
                    // compte nb combi par case
                    int nbMouvement = compteNbCombiParCase(listeMouvement,0,j);
                    if(nbMouvement==1){
                        System.out.print("*     "+getMooveIndex(listeMouvement,0,j)+"     ");
                    } else if (nbMouvement>1) {
                        System.out.print("*     2     ");
                    }
                }
            } else {
                System.out.print("*     "+tablejeu[0][i].getAlias()+"     ");
            }
        }
        System.out.println("*");

        //System.out.println("*     "+tablejeu[0][0].getAlias()+"     *     "+tablejeu[0][1].getAlias()+"     *     "+tablejeu[0][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        for(int i=0; i< tablejeu.length;++i){
            if(!listeMouvement.isEmpty()){
                for(int j=0;j<listeMouvement.size();++j){
                    // compte nb combi par case
                    int nbMouvement = compteNbCombiParCase(listeMouvement,1,j);
                    if(nbMouvement==1){
                        System.out.print("*     "+getMooveIndex(listeMouvement,1,j)+"     ");
                    } else if (nbMouvement>1) {
                        System.out.print("*     2     ");
                    }
                }
            } else {
                System.out.print("*     "+tablejeu[1][i].getAlias()+"     ");
            }
        }
        System.out.print("*");
        System.out.println(" ");
        //System.out.println("*     "+tablejeu[1][0].getAlias()+"     *     "+tablejeu[1][1].getAlias()+"     *     "+tablejeu[1][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        for(int i=0; i< tablejeu.length;++i){
            if(!listeMouvement.isEmpty()){
                for(int j=0;j<listeMouvement.size();++j){
                    // compte nb combi par case
                    int nbMouvement = compteNbCombiParCase(listeMouvement,2,j);
                    if(nbMouvement==1){
                        System.out.print("*     "+getMooveIndex(listeMouvement,2,j)+"     ");
                    } else if (nbMouvement>1) {
                        System.out.print("*     2     ");
                    }
                }
            } else {
                System.out.print("*     "+tablejeu[2][i].getAlias()+"     ");
            }
        }
        System.out.print("*");
        System.out.println(" ");
        //System.out.println("*     "+tablejeu[2][0].getAlias()+"     *     "+tablejeu[2][1].getAlias()+"     *     "+tablejeu[2][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
    }

    public static int compteNbCombiParCase(ArrayList<CombinaisonPossible> listeCombinaison, int x, int y){
        int compteur=0;
        for (int i=0; i<listeCombinaison.size();++i){
            if(listeCombinaison.get(i).getX1() == x && listeCombinaison.get(i).getY1() == y){
                ++compteur;
            }
        }
        return compteur;
    }
    public static int getMooveIndex(ArrayList<CombinaisonPossible> listeCombinaison, int x, int y){
        for (int i=0; i<listeCombinaison.size();++i){
            if(listeCombinaison.get(i).getX1() == x && listeCombinaison.get(i).getY1() == y){
                return i+1;
            }
        }
        return x;
    }
}
