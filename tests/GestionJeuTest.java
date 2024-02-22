package tests;

import org.junit.jupiter.api.Test;
import structure.EtatCase;
import structure.Joueur;

import java.util.ArrayList;

import static jeu.AffichageTable.afficherTable;
import static jeu.Initialiser.*;
import static jeu.MouvementsJoueurs.afficherDeplacements;
import static jeu.MouvementsJoueurs.calcDeplacementPossible;
import static org.junit.jupiter.api.Assertions.*;

class GestionJeuTest {

    /** Test de la création de deux joueurs avec 2 couleurs différentes **/
    @Test
    public void testCreationJoueur(){
        ArrayList<Joueur> listejoueur = new ArrayList<Joueur>();
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        j1.setColor(EtatCase.ROUGE);
        j2.setColor(EtatCase.ROUGE);
        assertEquals(j1.getColor(),j2.getColor());
        j2.setColor(EtatCase.BLEU);
        assertNotEquals(j1.getColor(),j2.getColor());
        listejoueur.add(j1);
        listejoueur.add(j2);
        for(int i=0; i<listejoueur.size();++i){
            System.out.println(listejoueur.get(i).getColor().toString());
        }
    }
    @Test
    public void testAffichageTable(){
        EtatCase[][] tablejeu;
        tablejeu = initTable();
        afficherTable(tablejeu);
    }

    @Test
    public void testCalcMovement(){
        EtatCase[][] tablejeu;
        tablejeu = initTable();
        ArrayList<Joueur> listejoueur = new ArrayList<Joueur>();
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        j1.setColor(EtatCase.ROUGE);
        j2.setColor(EtatCase.BLEU);
        listejoueur.add(j1);
        listejoueur.add(j2);
        afficherDeplacements(calcDeplacementPossible(tablejeu, j1));
    }
}