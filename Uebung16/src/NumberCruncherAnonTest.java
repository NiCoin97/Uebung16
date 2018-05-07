import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testklasse: NumberCruncherAnonTest
 * 
 * @author Nico Spanier, Matthias Tritt
 *
 */
public class NumberCruncherAnonTest {
    
    private NumberCruncherAnon nca;
    private float[] testArray;
    
    /**
     * setUp-Methode, wird vor jedem Test einmal durchlaufen
     */
    @Before
    public void setUp() {
	testArray = new float[10];
	for(int i = 0; i < 4; i++) {
	    testArray[i] = i;
	}
	nca = new NumberCruncherAnon(testArray);
    }

    
    /**
     * Testet, ob der Konstruktor das Array richtig initialisiert.
     */
    @Test
    public void konstruktorTest() {
	int laenge = 10;
	nca = new NumberCruncherAnon(laenge);
	int testLaenge = nca.getLaengeArray();
	assertEquals("Die Array-Laenge wurde nicht richtig initialisiert", laenge, testLaenge);
    }
    
    /**
     * Testet, ob die sum-Methode das Array richtig verändert.
     */
    @Test 
    public void sumTest() {
	String[]  testOp = {"sum"};
	nca.crunch(testOp);
	testArray[0] = 0;
	testArray[1] = 1;
	testArray[2] = 3;
	testArray[3] = 6;
	float[] arr = nca.getFloatArray();
	assertEquals("Die Sum-Methode funktioniert nicht!", arr, testArray);
    }
    
    /**
     * Testet, ob die divide-Methode das Array richtig verändert.
     */
    @Test
    public void divideTest() {
	//Weil durch 0 nicht geteilt werden darf
	testArray[0] = 1;
	nca = new NumberCruncherAnon(testArray);
	String[] testOp = {"divide"};
	nca.crunch(testOp);
	testArray[3] = 4 / 1;
	testArray[2] = 3 / 1;
	float[] arr = nca.getFloatArray();
	assertEquals("Die Divide-Methode funktioniert nicht!", arr, testArray);
    }
    
    /**
     * Testet, ob die substract-Methode das Array richtig verändert.
     */
    @Test
    public void substractTest() {
	testArray[0] = 0;
	testArray[1] = -1;
	testArray[2] = -3;
	testArray[3] = -6;
	String[] testOp = {"substract"};
	nca.crunch(testOp);
	float[] arr = nca.getFloatArray();
	assertEquals("Die Substract-Methode funkioniert nicht!", arr, testArray);
    }
    
    /**
     * Testet, ob die average-Methode das Array richtig verändert.
     */
    @Test
    public void average() {
	testArray[3] = (0+1+2+3)/4;
	String[] testOp = {"average"};
	nca.crunch(testOp);
	float[] arr = nca.getFloatArray();
	assertEquals("Die average-Methode funktioniert nicht!", arr, testArray);
    }
    
    

}
