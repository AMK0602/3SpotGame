package tests;

import org.junit.jupiter.api.Test;
import structure.EtatCase;
import structure.Joueur;
import structure.Pion;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class des tests unitaires relatifs aux diverses initialisations
 * @author HOUY Ethan - KHABBAZ Amine
 */
class InitialiserTest {

    /** Test de la création de deux joueurs avec 2 couleurs différentes **/
    @Test
    public void testCreationJoueur(){
        Joueur j1 = new Joueur(EtatCase.ROUGE);
        Joueur j2 = new Joueur(EtatCase.ROUGE);
        Joueur j3 = new Joueur();
        assertEquals(j1.getColor(),j2.getColor());
        assertNotEquals(j1.getColor(),j3.getColor());
        assertNotNull(j3.getColor());
        assertEquals(j3.getColor(), EtatCase.NEUTRE);
        j2.setColor(EtatCase.BLEU);
        assertEquals(j1.getScore(),0);
        assertEquals(j2.getScore(),0);
        assertEquals(j3.getScore(),0);
        assertNotEquals(j1.getColor(),j2.getColor());
    }

    /** Test de la création et du remplissage de la table de jeu */
    @Test
    void testInitTable() {
        EtatCase[][] table = new EtatCase[3][3];
        assertEquals(table.length, 3);
        assertNull(table[0][0]);
        assertNull(table[2][2]);
        table[0][0] = EtatCase.LIBRE;
        table[0][1] = EtatCase.ROUGE;
        table[0][2] = EtatCase.ROUGE;
        table[1][0] = EtatCase.LIBRE;
        table[1][1] = EtatCase.NEUTRE;
        table[1][2] = EtatCase.NEUTRE;
        table[2][0] = EtatCase.LIBRE;
        table[2][1] = EtatCase.BLEU;
        table[2][2] = EtatCase.BLEU;

        assertNotNull(table[2][2]);
        assertNotEquals(table[0][0], EtatCase.ROUGE);
        assertEquals(table[1][1], EtatCase.NEUTRE);
        assertEquals(table[0][0].getAlias(), ' ');
    }

    /** Test de création des pions rapportant des points */
    @Test
    void testInitPion() {
        Pion pion1 = new Pion(0,2);
        Pion pion2 = new Pion(1,2);
        Pion pion3 = new Pion(2,2);
        assertNotEquals(pion1.getX(),pion3.getX());
        assertEquals(pion1.getY(),pion2.getY(),pion3.getY());
        assertEquals(pion2.getX(),1);
    }
}