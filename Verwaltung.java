import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

 class  Verwaltung	{
	
	public static WueList myWueList; // globale statische Variable für Array von Usern
	public static WueList lehrerListe = new WueList(); // globale statische Variable für Array von Usern

	public static User[] myWueArray; // globale statische Variable für List von Usern
	
	public static void main(String[] args)	{	
			// Lese aus CSV-Daten in Liste ein...
            myWueList = csv2UserList("userdata.csv");	
            // Lade GUI
			// Gui wv = new Gui("WueVerwaltung - WV");
			
			Lehrer l1 = new Lehrer("Felix", "Balduin", "14.02.89", true, true);
			Lehrer l2 = new Lehrer("Karl", "Adler", "06.02.74", true, true);
			
			// Füge Lehrer-Objekte in beide Listen rein
			myWueList.insertFirst(l1);
			myWueList.insertFirst(l2);
			
			lehrerListe.insertFirst(l1);
			lehrerListe.insertFirst(l2);
			
			// Durchsuche myWueList und gebe alle Lehrer aus.
			myWueList.setCurrent(myWueList.getFirst());	// Setze Zeiger auf First
			while(myWueList.getCurrent()!=null)	{
				if(myWueList.getCurrent().getUser() instanceof Lehrer)	{
					myWueList.getCurrent().getUser().printDefaultData();
				}
				myWueList.setCurrent(myWueList.getCurrent().getNext());
			}
			
			String geschichte = "Geschichte [Ge]";
			String informatik = "Informatik [Ge]";
			// ... wie kann ich nun diese Fächer in eine dynamische Liste einfügen?
			
			// OLD
			WueList cooleAlteListe = new WueList();
			cooleAlteListe.insertFirst(new Lehrer("Felix", "Balduin", "14.02.89", true, true));
			
			//NEW 
			List<User> cooleUserList = new List<User>();
			cooleUserList.insert(new Lehrer("Felix", "Balduin", "14.02.89", true, true));
			cooleUserList.insert(l1);
			
			List<String> cooleListe = new List<String>();
			cooleListe.insert(geschichte);
			cooleListe.insert("Sowi");
	}
	
	/**
     *  Methode die ein User-Array aufsteigend sortiert
     * 
     * @param - Eingabe: unsortiertes Array
     * @return - Ausgabe: sortiertes Array
     */
	public static User[] bubbleSortArrayNachname(User[] unsortArray)	{
			int n = unsortArray.length; // Speichere aktuelle Arraylänge
			User temp;	// Objektvariable zur Zwischenspeicherung
			for (int i = 0; i < n; i++) {		// äußere Schleife
			  for (int j = 1; j < (n - i); j++) {	// innere Schleife
				if (unsortArray[j - 1].getNachname().compareTo(unsortArray[j].getNachname())>0) {
				  // Tausche Elemente mit Zwischenspeicher - z.B. Holzbring mit Artal
				  temp = unsortArray[j - 1];
				  unsortArray[j - 1] = unsortArray[j];
				  unsortArray[j] = temp;
				}
			  }
			}
			// Array ist nun nach Nachname sortiert - gebe es zurück
			return unsortArray;
	}
    
    /**
     *  Methode liest aus CSV Userdaten ein und parsed diese in Array von Userobjekten
     * 
     * @param - Eingabe: unsortiertes Array
     * @return - Ausgabe: sortiertes Array
     */
    public static User[] csv2UserArray(String filepath)	{
        // Lege Array an...
        User[] usernames = new User[800076]; // PROBLEM: was ist wenn die CSV-Datei andere Zeilen hat
        try
        {
            // lese Zeilenweise CSV-Datei ein
            Scanner scanner = new Scanner(new File(filepath));
            Scanner dataScanner = null;	//Objekt zum lesen eines Datensatzes
            // solange es einen nächste Zeile mit Text gibt, führe Schleife aus
            int i = 0;
            while(scanner.hasNext()==true)	{
                dataScanner = new Scanner(scanner.nextLine());	//nehme nächste Zeile in Objekt
                dataScanner.useDelimiter(";");	// Trennungszeichen zwischen Daten 
                // lege Array an der Größe 3 an.... 
                String data[] = new String[3];
                // speichere ersten Wert an Stelle 0
                data[0] = dataScanner.next();
                // speichere zweiten Wert an Stelle 1
                data[1] = dataScanner.next();
                // speichere zweiten Wert an Stelle 2
                data[2] = dataScanner.next();
                
                usernames[i] = new Schueler(data[1], data[0], data[2]);           
                i++;	// Zähle Variable entsprechend hoch...
            }
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
        // Gebe befülltes Array zurück...
        return usernames;
    }

	/**
     *  Methode liest aus CSV Userdaten ein und parsed diese in GymWueList von Userobjekten
     * 
     * @param - Eingabe: unsortiertes Array
     * @return - Ausgabe: sortiertes Array
     */
	public static WueList csv2UserList(String filepath){
		// Lege Array an...
        WueList userList = new WueList(); 
        try
        {
            // lese Zeilenweise CSV-Datei ein
            Scanner scanner = new Scanner(new File(filepath));
            Scanner dataScanner = null;	//Objekt zum lesen eines Datensatzes
            // solange es einen nächste Zeile mit Text gibt, führe Schleife aus
            int i = 0;
            while(scanner.hasNext()==true)	{
                dataScanner = new Scanner(scanner.nextLine());	//nehme nächste Zeile in Objekt
                dataScanner.useDelimiter(";");	// Trennungszeichen zwischen Daten 
                // lege Array an der Größe 3 an.... 
                String data[] = new String[3];
                // speichere ersten Wert an Stelle 0
                data[0] = dataScanner.next();
                // speichere zweiten Wert an Stelle 1
                data[1] = dataScanner.next();
                // speichere zweiten Wert an Stelle 2
                data[2] = dataScanner.next();
                
                userList.insertFirst(new Schueler(data[1], data[0], data[2]));           
                i++;	// Zähle Variable entsprechend hoch...
            }
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
        // Gebe befülltes Array zurück...
        return userList;
	}
}
