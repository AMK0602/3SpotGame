package tests;

import org.junit.jupiter.api.Test;
import structure.Joueur;

import static jeu.Initialiser.saisirCouleur;
import static org.junit.jupiter.api.Assertions.*;

class GestionJeuTest {

    /** Test de la création de deux joueurs avec 2 couleurs différentes **/
    @Test
    public void testCreationJoueur(){
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        j1.setColor(saisirCouleur());
        j2.setColor(saisirCouleur());
        assertNotEquals(j1.getColor(), j2.getColor());
    }

}