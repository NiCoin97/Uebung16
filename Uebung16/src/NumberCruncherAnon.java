import java.util.Arrays;
import java.util.Random;

/**
 * Beschreiben Sie hier die Klasse NumberCruncherAnon.
 * 
 * @author Nico Spanier, Matthias Tritt
 * @version 05.05.18
 */
public class NumberCruncherAnon {
    float[] floatArray;
    Random rnd;
    int laengeArray;

    public NumberCruncherAnon(int laenge) {
	laengeArray = laenge;
	floatArray = new float[laengeArray];
	for (int i = 0; i < laengeArray; i++) {
	    rnd = new Random();
	    floatArray[i] = rnd.nextFloat() + 1;
	}

    }

    interface Operation {
	void doOperation();
    }

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

			for (int i = 0; i < laengeArray/2; i++) {
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
	    default:
		System.out.println("Leere oder ungültige Eingabe");
		break;
	    }
	    op.doOperation();
	}
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
