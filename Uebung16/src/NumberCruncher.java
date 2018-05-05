import java.util.Arrays;
import java.util.Random;

/**
 * Beschreiben Sie hier die Klasse NumberCruncher.
 * 
 * @author Nico Spanier, Matthias Tritt
 * @version 05.05.18
 */
public class NumberCruncher {
    float[] floatArray;
    Random rnd;
    int laengeArray;

    public NumberCruncher(int[] args) {
	laengeArray = args[0];
	floatArray = new float[laengeArray];
	for (int i = 0; i < laengeArray; i++) {
	    rnd = new Random();
	    floatArray[i] = rnd.nextFloat() + 1;
	}

    }

    public void crunch(String[] operations) {
	for (String operation : operations) {
	    switch (operation) {
	    case "sum":
		sum();
		break;
	    case "swirl":
		swirl();
		break;
	    case "divide":
		divide();
		break;
	    case "subtract":
		subtract();
		break;
	    case "average":
		average();
		break;
	    default:
		System.out.println("Leere oder ungültige Eingabe");
		break;
	    }

	}

    }

    public void sum() {
	for (int i = 1; i < floatArray.length; i++) {
	    floatArray[i] += floatArray[i - 1];
	}
    }

    public void swirl() {
	for (int i = 0; i < laengeArray; i++) {
	    int randomIndex1 = rnd.nextInt(laengeArray);
	    int randomIndex2 = rnd.nextInt(laengeArray);

	    float temp = floatArray[randomIndex1];
	    floatArray[randomIndex1] = floatArray[randomIndex2];
	    floatArray[randomIndex2] = temp;
	}
    }

    public void divide() {
	float[] sortedArray = floatArray.clone();
	Arrays.sort(sortedArray);

	for (int i = 0; i < laengeArray; i++) {
	    floatArray[i] = sortedArray[laengeArray - i - 1] / sortedArray[i];
	}

    }

    public void subtract() {
	for (int i = 1; i < floatArray.length; i++) {
	    floatArray[i] -= floatArray[i - 1];
	}
    }

    public void average() {
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

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("");
	sb.append("Das floatArray mit einer Größe von " + laengeArray + ":" + "\n");
	for (int i = 0; i < laengeArray; i++) {
	    sb.append(i + ": " + floatArray[i] + "\n");
	}
	return sb.toString();
    }

}
