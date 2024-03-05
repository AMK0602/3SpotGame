package tests;

import org.junit.jupiter.api.Test;
import structure.EtatCase;
import structure.Joueur;
import structure.Pion;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InitialiserTest {

    @Test
    void testInitJoueurs() {
        /*ArrayList<Joueur> listejoueur = new ArrayList<Joueur>();
        Joueur j1 = new Joueur(EtatCase.NEUTRE);
        Joueur j2 = new Joueur(EtatCase.NEUTRE);
        assertNull(j1.getColor());
        assertNull(j2.getColor());
        assertEquals(j1.getScore(),0);
        assertEquals(j2.getScore(),0);
        listejoueur.add(j1);
        listejoueur.add(j2);
        assertEquals(listejoueur.size(),2);*/
    }

    @Test
    void testSaisirCouleur() {
        /*Joueur j1 = new Joueur(EtatCase.NEUTRE);
        Joueur j2 = new Joueur(EtatCase.NEUTRE);
        assertNull(j1.getColor());
        assertNull(j2.getColor());
        j1.setColor(EtatCase.BLEU);
        j2.setColor(EtatCase.ROUGE);
        assertNotNull(j1.getColor());
        assertNotNull(j2.getColor());
        assertNotEquals(j1.getColor(),j2.getColor());*/
    }

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

    @Test
    void testInitPion() {
        Pion[] listepion = new Pion[3];
        Pion pion1 = new Pion(0,2, listepion);
        Pion pion2 = new Pion(1,2, listepion);
        Pion pion3 = new Pion(2,2, listepion);


        assertNotEquals(pion1.getX(),pion3.getX());
        assertEquals(pion1.getY(),pion2.getY(),pion3.getY());
        assertEquals(pion2.getX(),1);
        assertEquals(listepion[0],pion1);
        assertNotEquals(listepion[1],listepion[2]);
    }
}