package jeu;

import structure.EtatCase;

public class AffichageTable {

    public static void afficherTable(EtatCase[][] tablejeu){
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        System.out.println("*     "+tablejeu[0][0].getAlias()+"     *     "+tablejeu[0][1].getAlias()+"     *     "+tablejeu[0][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        System.out.println("*     "+tablejeu[1][0].getAlias()+"     *     "+tablejeu[1][1].getAlias()+"     *     "+tablejeu[1][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
        System.out.println("*           *           *           * ");
        System.out.println("*     "+tablejeu[2][0].getAlias()+"     *     "+tablejeu[2][1].getAlias()+"     *     "+tablejeu[2][2].getAlias()+"     * ");
        System.out.println("*           *           *           * ");
        System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  * ");
    }
}
