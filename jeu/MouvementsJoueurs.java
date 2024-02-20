package jeu;

import structure.EtatCase;

import java.util.Scanner;

public class MouvementsJoueurs {
    public static boolean mvt_possible(EtatCase[][] table,int l, int c) {
                return table[l][c] == EtatCase.LIBRE && table[l + 1][c] == EtatCase.LIBRE || table[l][c] == EtatCase.LIBRE && table[l][c + 1] == EtatCase.LIBRE;
    }
    int[] indices = new int[9];

    public static void deplacementPiece(EtatCase[][] table, int[] indices){
        int compteur = 1;
        for(int i =0; i<3;i++){
            for(int j=0;j<3;j++){
                if(mvt_possible(table, i, j)){
                    //Mettre un num à la case sur l'affichage avec compteur
                    indices[i] = compteur;
                    compteur++;

                }
            }
        }
    }
    public void deplacerPiece(EtatCase[][] table){
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Quelle deplacement souhaitez vous faire ? ");
        String resultat = sc.next();
        int numero = Integer.parseInt(resultat);
        for(int i =0; i<indices.length;i++){
            if(indices[i]==numero){
                //Mettre à jour la position
            }
            else{
                System.out.println("Numéro invalide !");
            }
        }


        }

}
