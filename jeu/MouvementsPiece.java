package jeu;

import structure.Combinaison;
import structure.EtatCase;
import structure.Joueur;

import java.util.LinkedList;
import java.util.Scanner;

public class MouvementsPiece {

    /**
     * l'utilisateur choisi un numéro et le déplacement est effectué en fonction de ce déplacement
     * @param table : table de jeu
     * @param joueur :
     */
    public static void deplacerPiece(EtatCase[][] table, Joueur joueur, LinkedList<Combinaison> listCombinaison) {
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
            deplacerPiece(table, joueur, listCombinaison);
        }
    }



}
