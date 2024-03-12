package tests;

import jeu.Calcul;
import jeu.Jeu;
import org.junit.jupiter.api.Test;
import structure.Combinaison;
import structure.EtatCase;
import structure.Joueur;

import java.util.LinkedList;

import static jeu.Calcul.calcDeplacementPossible;
import static jeu.Initialiser.*;
import static org.junit.jupiter.api.Assertions.*;

class JeuTest {

    /** Fonction pour vérifier le calcul des mouvements possibles par joueur */
    @Test
    public void testCalcMovement(){
        EtatCase[][] tablejeu = initTable();
        Joueur j1 = new Joueur(EtatCase.ROUGE);
        Joueur j2 = new Joueur(EtatCase.BLEU);
        j1.setColor(EtatCase.ROUGE);
        j2.setColor(EtatCase.BLEU);
        LinkedList<Combinaison> listCombinaisonJ1 = calcDeplacementPossible(tablejeu, j1);
        LinkedList<Combinaison> listCombinaisonJ2 = calcDeplacementPossible(tablejeu, j2);
        assertNotEquals(listCombinaisonJ1, listCombinaisonJ2);
        assertEquals(listCombinaisonJ1.size(),3);
        assertEquals(listCombinaisonJ2.size(),3);
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