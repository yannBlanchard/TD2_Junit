import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Yann on 18/04/2016.
 */
public class MyDateTest{
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
    A1 = bissextile
    A2 = non bissextile
    */

    private MyDate date;

    @Before
    public void initialize() {
        date = null;
    }

    @org.junit.Test
    public void checkData() throws Exception {

    }

    @org.junit.Test
    public void nextDay() throws Exception {
        MyDate expectedDate = null;
        //Cas M1,J1-4
        date = new MyDate(2,1,2016);
        date.nextDay();
        expectedDate = new MyDate(3,1,2016);
        assertTrue("Cas M1,J1-4",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
        //Cas M1,J5
        date = new MyDate(31,1,2016);
        date.nextDay();
        expectedDate = new MyDate(1,2,2016);
        assertTrue("Cas M1,J5",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
        //Cas M2,J1-3
        date = new MyDate(28,4,2016);
        date.nextDay();
        expectedDate = new MyDate(29,4,2016);
        assertTrue("Cas M2,J1-3",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
        //Cas M2,J4
        date = new MyDate(30,4,2016);
        date.nextDay();
        expectedDate = new MyDate(1,5,2016);
        assertTrue("Cas M2,J4",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );

        //Cas M2,J5  Erreur

        //Cas M3,J1
        date = new MyDate(1,2,2016);
        date.nextDay();
        expectedDate = new MyDate(2,2,2016);
        assertTrue("Cas M3,J1",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
        //Cas M3,J2,Y1
        date = new MyDate(28,2,2016);
        date.nextDay();
        expectedDate = new MyDate(29,2,2016);
        assertTrue("Cas M3,J2,Y1",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
        //Cas M3,J2,Y2
        date = new MyDate(28,2,2016);
        date.nextDay();
        expectedDate = new MyDate(1,3,2016);
        assertTrue("Cas M3,J2,Y2",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
        //Cas M3,J3,Y1 Erreur

        //Cas M3,J3,Y2
        date = new MyDate(29,2,2016);
        date.nextDay();
        expectedDate = new MyDate(1,3,2016);
        assertTrue("Cas M3,J3,Y2",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
        //Cas M3,J4-5 Erreur

        //Cas M4,J1-4
        date = new MyDate(1,12,2016);
        date.nextDay();
        expectedDate = new MyDate(2,12,2016);
        assertTrue("Cas M4,J1-4",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
        //Cas M4-J5
        date = new MyDate(31,12,2016);
        date.nextDay();
        expectedDate = new MyDate(1,1,2015);
        assertTrue("Cas M4-J5",expectedDate._day == date._day &&
                expectedDate._month == date._month &&
                expectedDate._year == date._year );
    }

}