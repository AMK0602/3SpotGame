package tests;

import jeu.Jeu;
import org.junit.jupiter.api.Test;
import structure.EtatCase;
import structure.Joueur;

import java.util.ArrayList;
import static jeu.Initialiser.*;
import static org.junit.jupiter.api.Assertions.*;

class GestionJeuTest {

    /** Test de la création de deux joueurs avec 2 couleurs différentes **/
    @Test
    public void testCreationJoueur(){
        Joueur j1 = new Joueur(EtatCase.ROUGE);
        Joueur j2 = new Joueur(EtatCase.ROUGE);
        assertEquals(j1.getColor(),j2.getColor());
        j2.setColor(EtatCase.BLEU);
        assertNotEquals(j1.getColor(),j2.getColor());
    }

    @Test
    public void testCalcMovement(){
        /*EtatCase[][] tablejeu;
        tablejeu = initTable();
        ArrayList<Joueur> listejoueur = new ArrayList<Joueur>();
        Joueur j1 = new Joueur(EtatCase.ROUGE);
        Joueur j2 = new Joueur(EtatCase.BLEU);
        j1.setColor(EtatCase.ROUGE);
        j2.setColor(EtatCase.BLEU);
        listejoueur.add(j1);
        listejoueur.add(j2);*/
        //afficherDeplacements(calculcalcDeplacementPossible(tablejeu, j1));
    }

    /**
     * Fonction pour vérifier qui à gagner la partie
     */
    @Test
    public void testFinJeu(){
        Joueur j1 = new Joueur(EtatCase.ROUGE);
        Joueur j2 = new Joueur(EtatCase.BLEU);
        for (int i=0; i<12;++i)
            j1.incrementScore();
        for (int i=0; i<5;++i)
            j2.incrementScore();
        assertEquals(Jeu.getGagnant(j1,j2),j2);
        j2.incrementScore();
        assertEquals(Jeu.getGagnant(j1,j2),j1);
    }
}