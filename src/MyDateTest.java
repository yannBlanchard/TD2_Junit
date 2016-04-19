import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Yann on 18/04/2016.
 */
public class MyDateTest{


    private MyDate date;

    @Before
    public void initialize() {
        date = null;
    }


    @org.junit.Test
    public void MyDate() throws Exception {
        /*      Test à faire :
            La date créée n'esty pas null.
            La jour de la date est bien égale à celui mit lors de la création.
            La mois de la date est bien égale à celui mit lors de la création.
            L'année de la date est bien égale à celui mit lors de la création.
         */
        date = new MyDate(15,4,2016);
        assertNotNull(date);
        assertEquals("Jour créé correct",15,date.getDay());
        assertEquals("Mois créé correct",4,date.getMonth());
        assertEquals("Année créée correct",2016,date.getYear());
    }

    @org.junit.Test
    public void checkData() throws Exception {
    /* Jeux de test pour la fonction checkData
        Jour < 1
        Jour > 31
        Mois < 1
        Mois > 12
        Année < 1000
        Année > 3000
        Cas bon
     */
        //Jour < 1
        date = new MyDate(0,1,2016);
        assertFalse("Jour < 1",date.checkData());
        //Jour > 31
        date = new MyDate(32,1,2016);
        assertFalse("Jour > 31",date.checkData());
        //Mois < 1
        date = new MyDate(1,0,2016);
        assertFalse("Mois < 1",date.checkData());
        //Mois > 12
        date = new MyDate(1,13,2016);
        assertFalse("Mois > 12",date.checkData());
        //Cas bon
        assertTrue("Cas bon",date.checkData());
        /* Décommenter le bloc si l'on modifie la condition du code year <1 et si on rajoute la condition
            year > 3000
        Année < 1000
        date = new MyDate(1,1,999);
        assertFalse("Année < 1000",date.checkData());
        //Année > 3000
        date = new MyDate(1,1,3001);
        assertFalse("Année > 3000",date.checkData());
        */

    }

    @org.junit.Test
    public void nextDay() throws Exception {
        /*Jeux de test pour la fonction lendemain apres s'implification "Don't care"
            Mois 4 variants :
            M1 = 1,3,5,7,8,10
            M2 = 4,6,9,11
            M3 = 2
            M4 = 12
            Jours 5 variants
            J1 = {1 à 27}
            J2 = 28
            J3 = 29
            J4 = 30
            J5 = 31
            Année 2 variants
            Y1 = bissextile
            Y2 = non bissextile
        */
        MyDate expectedDate = null;
        //Cas M1,J1-4
        date = new MyDate(2,1,2016);
        date.nextDay();
        expectedDate = new MyDate(3,1,2016);
        assertEquals("Cas M1,J1-4",expectedDate,date);
        //Cas M1,J5
        date = new MyDate(31,1,2016);
        date.nextDay();
        expectedDate = new MyDate(1,2,2016);
        assertEquals("Cas M1,J5",expectedDate,date);
        //Cas M2,J1-3
        date = new MyDate(28,4,2016);
        date.nextDay();
        expectedDate = new MyDate(29,4,2016);
        assertEquals("Cas M2,J1-3",expectedDate,date);
        //Cas M2,J4
        date = new MyDate(30,4,2016);
        date.nextDay();
        expectedDate = new MyDate(1,5,2016);
        assertEquals("Cas M2,J4",expectedDate,date);
        //Cas M2,J5  Erreur
        date = new MyDate(31,4,2016);
        date.nextDay();
        assertFalse("Cas M2,J5",date.checkData());
        //Cas M3,J1
        date = new MyDate(1,2,2016);
        date.nextDay();
        expectedDate = new MyDate(2,2,2016);
        assertEquals("Cas M3,J1",expectedDate,date);
        //Cas M3,J2,Y1
        date = new MyDate(28,2,2016);
        date.nextDay();
        expectedDate = new MyDate(29,2,2016);
        assertEquals("Cas M3,J2,Y1",expectedDate,date);
        //Cas M3,J2,Y2
        date = new MyDate(28,2,2017);
        date.nextDay();
        expectedDate = new MyDate(1,3,2017);
        assertEquals("Cas M3,J2,Y2",expectedDate,date);
        //Cas M3,J3,Y1
        date = new MyDate(29,2,2016);
        date.nextDay();
        expectedDate = new MyDate(1,3,2016);
        assertEquals("Cas M3,J3,Y1",expectedDate,date);
        //Cas M3,J3,Y2  Erreur
        date = new MyDate(29,2,2017);
        assertFalse("Cas M3,J3,Y2",date.checkData());
        //Cas M3,J4-5 Erreur
        date = new MyDate(30,2,2017);
        assertFalse("Cas M3,J4-5",date.checkData());
        //Cas M4,J1-4
        date = new MyDate(1,12,2016);
        date.nextDay();
        expectedDate = new MyDate(2,12,2016);
        assertEquals("Cas M4,J1-4",expectedDate,date);
        //Cas M4,J5
        date = new MyDate(31,12,2016);
        date.nextDay();
        expectedDate = new MyDate(1,1,2017);
        assertEquals("Cas M4-J5",expectedDate,date);
    }

}