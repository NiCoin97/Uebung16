/**
 * Personenklasse erweitert um Konstruktoren
 * @author Nico Spanier, Matthias Tritt
 */
public class Person {
    public Person() {}
    

    public Person( String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    /**
     * Person auf die Standardausgabe ausgeben
     *
     */
    public void ausgeben() {
        System.out.print(name + ", " + vorname);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }
    
	@Override
    public String toString() {
    	return name + ", " + vorname;
    }

    private String name;
    private String vorname;
}