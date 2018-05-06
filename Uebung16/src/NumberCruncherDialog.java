import java.util.ArrayList;
import java.util.Scanner;

public class NumberCruncherDialog {

    // --------Klassenkonstanten-------

    private String[] operationsNamen = { "sum", "swirl", "divide", "substract", "average" };

    // ----int-Werte-----

    private static final int NEUES_ARRAY = 1;
    private static final int ARRAY_AUSGEBEN = 2;
    private static final int CRUNCH = 3;
    private static final int BEENDEN = 0;

    private static final int SUM = 1;
    private static final int SWIRL = 2;
    private static final int DIVIDE = 3;
    private static final int SUBSTRACT = 4;
    private static final int AVERAGE = 5;

    // ---Strings----

    private static final String menue = NEUES_ARRAY + ". Neues Array\n" + ARRAY_AUSGEBEN + ". Array ausgeben\n" + CRUNCH
	    + ". Crunch\n" + BEENDEN + ". Beenden";

    private static final String operationAuswahl = SUM + ". sum\n" + 
	    SWIRL + ". swirl\n" + DIVIDE + ". divide\n"
	    + SUBSTRACT + ". substract\n" + AVERAGE + 
	    ". average\n" + BEENDEN + ". Fertig\n";

    private ArrayList<String> operationsList;

    private NumberCruncherAnon nca;
    private Scanner input;

    public NumberCruncherDialog() {
	input = new Scanner(System.in);
    }

    public static void main(String[] args) {
	new NumberCruncherDialog().funktionAusfuehren();
    }

    private int funktionAuswaehlen() {
	int funktion = -1;

	while (funktion < 0 || funktion > 6) {
	    System.out.println(menue);
	    funktion = input.nextInt();
	    if (funktion < 0 || funktion > 5) {
		System.out.println("Ungültige Eingabe!");
	    }
	}
	return funktion;

    }

    private void funktionAusfuehren() {
	int funktion = funktionAuswaehlen();
	while (funktion != BEENDEN) {
	    switch (funktion) {
	    case NEUES_ARRAY:
		int laenge = erfasseInt("Wie groß soll das Array sein?");
		nca = new NumberCruncherAnon(laenge);
		System.out.println("Das Array wurde erstellt!");
		break;
	    case ARRAY_AUSGEBEN:
		System.out.println(nca);
		break;
	    case CRUNCH:
		String[] operationsArr = crunchOperations();
		System.out.println("Es werden folgende Operationen nacheinaner ausgeführt: ");
		gebeArrayAus(operationsArr);
		nca.crunch(operationsArr);
		break;
	    }
	    funktion = funktionAuswaehlen();
	}
    }

    private String[] crunchOperations() {
	
	String[] operationen;
	System.out.println("Welche Operationen sollen ausgeührt werden?");
	int operation = -1;
	operationsList = new ArrayList<String>();
	while (operation != BEENDEN) {
	    gebeArrayListAus(operationsList);
	    operation = erfasseInt(operationAuswahl);

	    if (operation == 0)
		continue;

	    if (operation >= 0 && operation <= 5) {
		operationsList.add(operationsNamen[operation - 1]);
	    } else {
		System.out.println("Falsche Eingabe!");
	    }
	    System.out.println("Weitere Operationen hinzufügen?");
	}
	operationen = new String[operationsList.size()];
	return operationsList.toArray(operationen);
    }

    private void gebeArrayAus(String[] arr) {
	System.out.println();
	for (int i = 0; i < arr.length; i++) {
	    System.out.print(arr[i]);
	    if (i < arr.length - 1)
		System.out.print(", ");
	}
	System.out.println("\n");
    }

    private void gebeArrayListAus(ArrayList<String> arrL) {
	System.out.println();
	for (int i = 0; i < arrL.size(); i++) {
	    System.out.print(arrL.get(i));
	    if (i < arrL.size() - 1)
		System.out.print(", ");
	}
	System.out.println("\n");
    }

    // ----------------------erfasse-Methoden---------------------------

    /**
     * Fordert den Benutzer auf einen String einzugeben und gibt diesen dann zurück
     * 
     * @param prompt
     *            Aufforderung, was der Benutzer eingeben soll
     * @return zeichenkette als String
     */
    private String erfasseString(String prompt) {
	System.out.println(prompt);
	return input.nextLine();
    }

    /**
     * Fordert den Benutzer auf eine Zahl einzugeben und gibt diesen dann zurück
     * 
     * @param prompt
     *            Aufforderung, was der Benutzer eingeben soll
     * @return Zahl als int
     */
    private int erfasseInt(String prompt) {
	System.out.println(prompt);
	return input.nextInt();
    }

}
