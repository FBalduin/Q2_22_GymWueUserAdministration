public class Lehrer extends User  {
    
    boolean sek1;
    boolean sek2; 

    // Konstruktor Schüler
    public Lehrer(String vorname, String nachname, String geb, boolean sek1, boolean sek2)    {
        // Gebe Werte weiter an Vaterklasse
        super(vorname, nachname, geb);
        this.sek1 = sek1;
        this.sek2 = sek2;
    }

    // GETTER/SETTER
    public boolean getSek1() {
        return this.sek1;
    }

    public void setSek1(boolean sek1) {
        this.sek1 = sek1;
    }

    public boolean getSek2() {
        return this.sek2;
    }
    
    
    public void setSek2(boolean sek2) {
        this.sek2 = sek2;
    }


}
