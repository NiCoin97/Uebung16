import java.util.ArrayList;
import java.util.Arrays;

/**
 * Klasse PersonQueue
 *
 * @author Nico Spanier, Matthias Tritt
 * @version 25.01.2018
 */
public class PersonQueue implements Queue 
{
    private Person[] pQueue;
    private int size;
    private static final String MSG_QUEUE_VOLL = "Die Warteschlange ist bereits voll!";
    private static final String MSG_QUEUE_LEER = "Die Warteschlange ist noch  leer!";
    private static final String MSG_OBEJEKT_EXISTIERT_NICHT = "Es gibt kein Person-Objekt an dieser Stelle!";
    private static final String MSG_KEIN_PERSON_OBJEKT = "Das übergebene Objet ist kein Person-Objekt!";
    
    /**
     * Konstruktor der Klasse PersonQueue
     * @param maxSize
     */
    public PersonQueue (int maxAnzahl) {
        pQueue = new Person[maxAnzahl];
        size = 0;
    }
    
    /**
     * Interface: PersonIterator, erbt von java.util.Iterator<Person>
     *
     */
    interface PersonIterator extends java.util.Iterator<Person> { }
    
    /**
     * Private Klasse PersonInOrderIterator, implementiert das Interface PersonIterator
     *
     */
    private class PersonInOrderIterator implements PersonIterator {
	
	private int index = 0;

	/**
	 * prüft, ob nocht weitere Personen existieren
	 */
	@Override
	public boolean hasNext() {
	    return index < size;
	}

	/**
	 * gibt die nächste Person zurück
	 */
	@Override
	public Person next() {
	    Person next = pQueue[index];
	    index++;
	    return next;
	}
	
    }
    
    /**
     * Gibt die aktuelle Warteliste zurück
     * Nutzt dazu den Iterator PersonInOrderIterator
     */
    public void print() {
	PersonIterator pi = new PersonInOrderIterator();
	while (pi.hasNext()) {
	    System.out.println(pi.next());
	}
    }
    
    /**
     * Gibt den lexikalisch kleinsten Vornamen der Warteschlange zurück
     * 
     * @return kleinster Vorname
     */
    public String smallest() {
	
	PersonIterator pi = new PersonInOrderIterator();

	String kleinsterVorname = pi.next().getVorname();
	while (pi.hasNext()) {
	    String vorname = pi.next().getVorname();
	    if (kleinsterVorname.compareTo(vorname) >= 0)
		kleinsterVorname = vorname;
	}
	return kleinsterVorname;
    }
    
    
    /**
     * fuegt eine Person in die Warteschlange ein
     */
    public void addLast(Object o) {
        check ( o instanceof Person , MSG_KEIN_PERSON_OBJEKT );
        check ( !full() , MSG_QUEUE_VOLL );
        Person p = (Person) o;
        pQueue[size] = p;
        size++;
    }
    
    /**
     * entfernt das erste Element und gibt eine Referenz darauf zurueck
     * @return Person-Objekt, das entfernt wird
     */
    public Person removeFirst() {
        check ( !empty() , MSG_QUEUE_LEER );
        Person ret = pQueue[0];
        for (int i = 1; i < size; i++) {
            pQueue[i-1] = pQueue[i];
        }
        size--;
        return ret;
    }
    
    /**
     * Gibt das i-te Person-Objekt zurück
     * @return Person-Objekt
     */
    public Person get (int i) {
        check ( i < size , MSG_OBEJEKT_EXISTIERT_NICHT );
        return pQueue[i];
    }
    
    /**
     * Testet ob schon String-Objekte eingefuegt wurden
     * @return boolean empty
     */
    public boolean empty () {
        return size == 0;
    }
    
    /**
     * Testet ob noch Person-Objekte eingefügt werden können
     */
    public boolean full () {
        return size == pQueue.length;
    }
    
    /**
     * prüft ob eine bestimmte Bedingung erfüllt ist, wirft eine Exception, falls sie nicht erfüllt ist
     */
    private void check (boolean bedingung, String msg) {
        if (!bedingung) 
            throw new RuntimeException(msg);
    }
    
    /**
     * gibt die aktuelle Anzahl an Person-Objekten in der Warteschlange zurück
     * @return integer zahl size
     */
    public int size () {
        return size;
    } 
}
