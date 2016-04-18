import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Yann on 18/04/2016.
 */
public class MyDateTest {
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
        date = new MyDate(2,1,2016);
        date.nextDay();
        expectedDate = new MyDate(3,1,2016);
        assertTrue(expectedDate.equals(date));
    }

}