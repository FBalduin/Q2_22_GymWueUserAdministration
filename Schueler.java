public class Schueler extends User  {
    String klasse; 
    double notendurchschnitt;
    double fehlstunden;

    // Konstruktor Schüler
    public Schueler(String vorname, String nachname, String geb)    {
        // Gebe Werte weiter an Vaterklasse
        super(vorname, nachname, geb);
    }

    // GETTER/SETTER
    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public double getNotendurchschnitt() {
        return notendurchschnitt;
    }

    public void setNotendurchschnitt(double notendurchschnitt) {
        this.notendurchschnitt = notendurchschnitt;
    }

    public double getFehlstunden() {
        return fehlstunden;
    }

    public void setFehlstunden(double fehlstunden) {
        this.fehlstunden = fehlstunden;
    }
      
}
