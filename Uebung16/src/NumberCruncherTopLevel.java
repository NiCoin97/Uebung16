import java.util.Arrays;
import java.util.Random;


/**
 * Klasse NumberCruncherTopLevel
 * 
 * @author Nico Spanier, Matthias Tritt
 * @version 08.05.18
 */
public class NumberCruncherTopLevel {
    private static float[] floatArray;
    private static Random rnd;
    private static int laengeArray;
    
    
    /**
     * Konstruktor für die Klasse NumberCruncherTopLevel
     * 
     * @param floatArr		wird als das floatArray der Klasse initialisiert
     */
    public NumberCruncherTopLevel(float[] floatArr) {
	laengeArray = floatArr.length;
	floatArray = floatArr;
    }
    
  
    /**
     * Konstruktor für die Klasse NumberCruncherTopLevel
     * 
     * Füllt das Array mit zufälligen Werten und legt eine übergebene Länge fest.
     * 
     * @param laenge	die Laenge des Arrays
     */
    public NumberCruncherTopLevel(int laenge) {
	laengeArray = laenge;
	floatArray = new float[laengeArray];
	for (int i = 0; i < laengeArray; i++) {
	    rnd = new Random();
	    floatArray[i] = rnd.nextFloat() + 1;
	}
    }
    
    /**
     * Führt eine beliebige Folge an Operationen an dem floatArray durch.
     * 
     * @param operations		ein Array mit den durchzuführenden Operationen
     */
    public void crunch(String[] operations) {
	for(String operation : operations) {
	    switch (operation) {
	    case "sum":
		Sum.sumM();
		break;
	    case "swirl":
		Swirl.swirlM();
		break;
	    case "divide":
		Divide.divideM();
		break;
	    case "substract":
		Substract.subtractM();
		break;
	    case "average":
		Average.averageM();
		break;
	    }
	}
	
	
    }


    /**
     * Klasse Sum
     * beinhaltet die Operation: sum
     *
     */
    public static class Sum {
	public static float[] sumM() {
	    for (int i = 1; i < floatArray.length; i++) {
		floatArray[i] += floatArray[i - 1];
	    }
	    return floatArray;
	}

    }

    /**
     * Klasse Swirl
     * beinhaltet die Operation: swirl
     *
     */
    public static class Swirl {
	public static float[] swirlM() {
	    for (int i = 0; i < laengeArray; i++) {
		int randomIndex1 = rnd.nextInt(laengeArray);
		int randomIndex2 = rnd.nextInt(laengeArray);

		float temp = floatArray[randomIndex1];
		floatArray[randomIndex1] = floatArray[randomIndex2];
		floatArray[randomIndex2] = temp;
	    }
	    return floatArray;
	}
    }

    /**
     * Klasse Divide
     * beinhaltet die Operation: divide
     *
     */
    public static class Divide {
	public static float[] divideM() {
	    float[] sortedArray = floatArray.clone();
	    Arrays.sort(sortedArray);

	    for (int i = 0; i < laengeArray/2; i++) {
		floatArray[i] = sortedArray[laengeArray - i - 1] / sortedArray[i];
	    }
	    return floatArray;
	}
    }

    /**
     * Klasse Substract
     * beinhaltet die Operation: substract
     * 
     */
    public static class Substract {
	public static float[] subtractM() {
	    for (int i = 1; i < floatArray.length; i++) {
		floatArray[i] -= floatArray[i - 1];
	    }
	    return floatArray;
	}
    }

    /**
     * Klasse Average
     * beinhaltet die Operation: average
     *
     */
    public static class Average {
	public static float[] averageM() {
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
	    return floatArray;
	}
    }

    /**
     * to-String-Methode der Klasse NumberCruncherTopLevel
     * 
     * bereitet das floatArray als String auf.
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
     * get-Methode der Laenge des Arrays
     * @return langeArray
     */
    public int getLaengeArray() {
	return laengeArray;
    }
}