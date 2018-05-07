import java.util.Arrays;
import java.util.Random;

/**
 * Beschreiben Sie hier die Klasse NumberCruncherAnon.
 * 
 * @author Nico Spanier, Matthias Tritt
 * @version 05.05.18
 */
public class NumberCruncherAnon {
    private float[] floatArray;
    private Random rnd;
    private int laengeArray;
    
    
    /**
     * Konstruktor für die Klasse NumberCruncherAnon
     * 
     * @param floatArr		wird als das floatArray der Klasse initialisiert
     */
    public NumberCruncherAnon(float[] floatArr) {
	laengeArray = floatArr.length;
	floatArray = floatArr;
    }

    /**
     * Konstruktor für die Klasse NumberCruncherAnon
     * 
     * Füllt das Array mit zufälligen Werten und legt eine übergebene Länge fest.
     * 
     * @param laenge	die Laenge des Arrays
     */
    public NumberCruncherAnon(int laenge) {
	if (laenge <= 0) 
	    throw new RuntimeException("Die Länge muss mindestens 1 sein!");
	
	laengeArray = laenge;
	floatArray = new float[laengeArray];
	for (int i = 0; i < laengeArray; i++) {
	    rnd = new Random();
	    floatArray[i] = rnd.nextFloat() + 1;
	}

    }

    /**
     * Interface Operation
     * 
     * hat eine Methode doOperation
     *      
     */
    interface Operation {
	void doOperation();
    }

    
    /**
     * Führt eine beliebige Folge an Operationen an dem floatArray durch.
     * 
     * @param operations		ein Array mit den durchzuführenden Operationen
     */
    public void crunch(String[] operations) {
	Operation op = new Operation() {
	    @Override
	    public void doOperation() {
	    }
	};
	for (String operation : operations) {
	    switch (operation) {
	    case "sum":
		op = new Operation() {
		    @Override
		    public void doOperation() {
			for (int i = 1; i < floatArray.length; i++) {
			    floatArray[i] += floatArray[i - 1];
			}
		    }
		};
		break;
	    case "swirl":
		op = new Operation() {
		    @Override
		    public void doOperation() {
			for (int i = 0; i < laengeArray; i++) {
			    int randomIndex1 = rnd.nextInt(laengeArray);
			    int randomIndex2 = rnd.nextInt(laengeArray);

			    float temp = floatArray[randomIndex1];
			    floatArray[randomIndex1] = floatArray[randomIndex2];
			    floatArray[randomIndex2] = temp;
			}
		    }
		};
		break;
	    case "divide":
		op = new Operation() {
		    @Override
		    public void doOperation() {
			float[] sortedArray = floatArray.clone();
			Arrays.sort(sortedArray);

			for (int i = 0; i < laengeArray / 2; i++) {
			    floatArray[i] = sortedArray[laengeArray - i - 1] / sortedArray[i];
			}
		    }
		};
		break;
	    case "substract":
		op = new Operation() {
		    @Override
		    public void doOperation() {
			for (int i = 1; i < floatArray.length; i++) {
			    floatArray[i] -= floatArray[i - 1];
			}
		    }
		};
		break;
	    case "average":
		op = new Operation() {
		    @Override
		    public void doOperation() {
			float biggest = 0.0F;
			float averageCount = 0.0F;
			int indexOfBiggest = 0;

			for (int i = 0; i < floatArray.length; i++) {
			    if (biggest < floatArray[i]) {
				biggest = floatArray[i];
				indexOfBiggest = i;
			    }
			    averageCount += floatArray[i];
			}
			averageCount /= (laengeArray);
			floatArray[indexOfBiggest] = averageCount;
		    }
		};
		break;
	    }
	    op.doOperation();
	}
    }

    /**
     * toString-Methode der Klasse
     * 
     * bereitet das Array als String auf
     */
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("");
	sb.append("Das floatArray mit einer Größe von " + laengeArray + ":" + "\n");
	for (int i = 0; i < laengeArray; i++) {
	    sb.append(i + ": " + floatArray[i] + "\n");
	}
	return sb.toString();
    }
    
    /**
     * get-Methode des floatArray
     * @return floatArray
     */
    public float[] getFloatArray() {
	return floatArray;
    }

    /**
     * get-Methode des Laenge des Arrays
     * @return laengeArray
     */
    public int getLaengeArray() {
	return laengeArray;
    }

}
