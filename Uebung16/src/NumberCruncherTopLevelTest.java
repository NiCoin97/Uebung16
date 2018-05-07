import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testklasse: NumberCruncherTopLevelTest
 * 
 * @author Nico Spanier, Matthias Tritt
 *
 */
public class NumberCruncherTopLevelTest {
    
    private NumberCruncherTopLevel nctl;
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
	nctl = new NumberCruncherTopLevel(testArray);
    }

    
    /**
     * Testet, ob der Konstruktor das Array richtig initialisiert.
     */
    @Test
    public void konstruktorTest() {
	int laenge = 10;
	nctl = new NumberCruncherTopLevel(laenge);
	int testLaenge = nctl.getLaengeArray();
	assertEquals("Die Array-Laenge wurde nicht richtig initialisiert", laenge, testLaenge);
    }
    
    /**
     * Testet, ob die sum-Methode das Array richtig verändert.
     */
    @Test 
    public void sumTest() {
	String[]  testOp = {"sum"};
	nctl.crunch(testOp);
	testArray[0] = 0;
	testArray[1] = 1;
	testArray[2] = 3;
	testArray[3] = 6;
	float[] arr = nctl.getFloatArray();
	assertEquals("Die Sum-Methode funktioniert nicht!", arr, testArray);
    }
    
    /**
     * Testet, ob die divide-Methode das Array richtig verändert.
     */
    @Test
    public void divideTest() {
	//Weil durch 0 nicht geteilt werden darf
	testArray[0] = 1;
	nctl = new NumberCruncherTopLevel(testArray);
	String[] testOp = {"divide"};
	nctl.crunch(testOp);
	testArray[3] = 4 / 1;
	testArray[2] = 3 / 1;
	float[] arr = nctl.getFloatArray();
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
	nctl.crunch(testOp);
	float[] arr = nctl.getFloatArray();
	assertEquals("Die Substract-Methode funkioniert nicht!", arr, testArray);
    }
    
    /**
     * Testet, ob die average-Methode das Array richtig verändert.
     */
    @Test
    public void average() {
	testArray[3] = (0+1+2+3)/4;
	String[] testOp = {"average"};
	nctl.crunch(testOp);
	float[] arr = nctl.getFloatArray();
	assertEquals("Die average-Methode funktioniert nicht!", arr, testArray);
    }
    
    

}
