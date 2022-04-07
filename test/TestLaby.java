
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class TestLaby {

    //CLASSE POSITION
    @Test
    public void test_creerPosition() {

        //Méthode testée
        Position p = new Position(1,2);

        //Vérification
        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
    }

    @Test
    public void test_changerPosition() {
        //Préparation des données
        Position p = new Position(1,2);

        //Méthodes testées
        p.setX(3);
        p.setY(4);

        //Vérification
        assertEquals(3, p.getX());
        assertEquals(4, p.getY());
    }

    //CLASSE LABYRINTHE

    @Test
    public void test_chargerLabyrinthe() throws Exception{
        //Méthode testé
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //Vérification
        assertEquals(l.getChar(0,0),Labyrinthe.MUR);
        assertEquals(l.getChar(1,1),Labyrinthe.SORTIE);
        assertEquals(l.getChar(2,3),Labyrinthe.PJ);
        assertEquals(l.getChar(2,1),Labyrinthe.VIDE);
    }

    @Test
    public void test_chargerLabyrinthe_fichierInexistant() {
        //Méthode testée
        try {
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby_inexistant.txt");
        } catch (FichierIncorrectException | IOException e) {
            assertTrue(true);
        }
    }

    @Test
    public void test_getSuivant() throws ActionInconnueException, FichierIncorrectException, IOException {
        //Préparation des données
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // Méthode testée
        int[] res;
        int[] res2;
        int[] res3;
        int[] res4;
        res = Labyrinthe.getSuivant(1,1,Labyrinthe.HAUT);
        res2 = Labyrinthe.getSuivant(1,1,Labyrinthe.BAS);
        res3 = Labyrinthe.getSuivant(1,1,Labyrinthe.DROITE);
        res4 = Labyrinthe.getSuivant(1,1,Labyrinthe.GAUCHE);

        //Vérifications
        assertEquals(res[0],0);
        assertEquals(res[1],1);
        assertEquals(res2[0],2);
        assertEquals(res2[1],1);
        assertEquals(res3[0],1);
        assertEquals(res3[1],2);
        assertEquals(res4[0],1);
        assertEquals(res4[1],0);
    }

    @Test
    public void test_deplacerPerso() throws ActionInconnueException, FichierIncorrectException, IOException {
        //Préparation des données
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //Méthode testée
        l.deplacerPerso("haut");

        //Vérification
        assertEquals(Labyrinthe.PJ,l.getChar(1,3));
        assertEquals(Labyrinthe.VIDE,l.getChar(1,4));
    }

    @Test
    public void test_deplacerPerso_actionInconnue() throws ActionInconnueException, FichierIncorrectException, IOException {
        //Préparation des données
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //Méthode testée
        try {
            l.deplacerPerso("x");
        } catch (ActionInconnueException e) {
            assertTrue(true);
        }
    }

    @Test
    public void test_deplacerPerso_passerSurSortie() throws ActionInconnueException, FichierIncorrectException, IOException {
        //Préparation des données
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby2.txt");

        //Méthode testée
        l.deplacerPerso("haut");

        //Vérification
        assertFalse(l.etreFini());
    }

    @Test
    public void test_etreFini() throws ActionInconnueException, FichierIncorrectException, IOException {
        //Préparation des données
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        l.deplacerPerso("haut");
        l.deplacerPerso("gauche");
        boolean b = false;

        //Méthode testée
        b = l.etreFini();

        //Vérification
        assertTrue(b);
    }
}
