import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class Gui extends JFrame {

    private JList<User> listNutzer;
    private DefaultListModel<User> dlm;

    private JLabel labelVorname;
    private JLabel labelNachname;
    private JLabel labelGebdat;

    private JTextField fieldVorname;
    private JTextField fieldName;
    private JTextField fieldGebdat;
    private JTextField fieldEreignis; // gebe Nutzer hiermit Rückmeldung

    private JButton buttonAdd; // Nutzer einfügen
    private JButton buttonEdit; // Nutzer editieren
    private JButton buttonDelete; // Nutzer löschen

    private JButton arrowFirstElement; // <<
    private JButton arrowLastElement; // >>
    private JButton arrowPreviousElement; // <
    private JButton arrowNextElement; // >
    private JPanel contentPane;

    protected int widthList = 200;

    public Gui(String title) {
        setTitle(title); // Titel setzen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit-Buttons oben rechts
        setBounds(100, 150, 400 + widthList, 400); // Fenstergrösse

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.decode("#247BA0"));
        contentPane.setLayout(null);

        initViews();

        // ganz zum Schluss erst
        setResizable(false);
        setVisible(true); // Fenster sichtbar machen
    }
	
	// Initialisiere Liste und Felder neben Eingabefeldern
    protected void initViews() {
        // Liste Nutzer
        dlm = new DefaultListModel<>();
        listNutzer = new JList<User>(dlm);
        JScrollPane scrollNutzer = new JScrollPane(listNutzer);

        initList();

        listNutzer.addListSelectionListener(e -> {
            int index = listNutzer.getSelectedIndex();
            Verwaltung.myWueList.setCurrent(Verwaltung.myWueList.get(index));
            showUser();
        });

        scrollNutzer.setBounds(0, 0, 200, 400);
        contentPane.add(scrollNutzer);

        // Label Vorname
        labelVorname = new JLabel("Vorname: ");
        labelVorname.setBounds(25 + widthList, 15, 350, 20);
        labelVorname.setForeground(Color.decode("#FAFAFF"));
        contentPane.add(labelVorname);

        // Inputfield Vorname
        fieldVorname = new JTextField();
        fieldVorname.setBounds(25 + widthList, 35, 350, 25);
        contentPane.add(fieldVorname);

        // Label Nachname
        labelNachname = new JLabel("Nachname: ");
        labelNachname.setBounds(25 + widthList, 70, 350, 20);
        labelNachname.setForeground(Color.decode("#FAFAFF"));
        contentPane.add(labelNachname);

        // Inputfield Nachname
        fieldName = new JTextField();
        fieldName.setBounds(25 + widthList, 95, 350, 25);
        contentPane.add(fieldName);

        // Label Gebdat
        labelGebdat = new JLabel("Geburtsdatum: ");
        labelGebdat.setBounds(25 + widthList, 125, 350, 20);
        labelGebdat.setForeground(Color.decode("#FAFAFF"));
        contentPane.add(labelGebdat);

        // Inputfield Gebdat
        fieldGebdat = new JTextField();
        fieldGebdat.setBounds(25 + widthList, 150, 350, 25);
        contentPane.add(fieldGebdat);

        // Hinzufügen
        buttonAdd = new JButton("add");
        buttonAdd.setBackground(Color.decode("#FFFFFF"));
        buttonAdd.setForeground(Color.decode("#000000"));
        // Was passiert beim Drücken des Buttons
        buttonAdd.addActionListener(e -> {
            // Füge neuen Schüler in List...
            Schueler s = new Schueler(fieldVorname.getText(), fieldName.getText(), fieldGebdat.getText());
            Verwaltung.myWueList.append(s);
            fieldEreignis.setText("Nutzer eingefügt");
            // Verwaltung.myWueList.getFirst().getUser().printDefaultData();
        });
        // platziere Button im Fenster
        buttonAdd.setBounds(260 + widthList, 280, 120, 25);
        contentPane.add(buttonAdd);

        // Bearbeiten
        buttonEdit = new JButton("edit");
        buttonEdit.setBackground(Color.decode("#FFFFFF"));
        buttonEdit.setForeground(Color.decode("#000000"));
        buttonEdit.addActionListener(e -> {
            Schueler s = new Schueler(fieldVorname.getText(), fieldName.getText(), fieldGebdat.getText());
            Verwaltung.myWueList.getCurrent().setUser(s);

            fieldEreignis.setText("Nutzer bearbeitet.");
        });
        // platziere Button im Fenster
        buttonEdit.setBounds(140 + widthList, 280, 120, 25);
        contentPane.add(buttonEdit);

        // Löschen
        buttonDelete = new JButton("delete");
        buttonDelete.setBackground(Color.decode("#FFFFFF"));
        buttonDelete.setForeground(Color.decode("#000000"));
        buttonDelete.addActionListener(e -> {
            Verwaltung.myWueList.removeCurrent();

            showUser();
        });
        buttonDelete.setBounds(25 + widthList, 280, 120, 25);
        contentPane.add(buttonDelete);

        // First
        arrowFirstElement = new JButton("<<");
        arrowFirstElement.setToolTipText("Erstes Element");
        arrowFirstElement.setBackground(Color.decode("#FFFFFF"));
        arrowFirstElement.setForeground(Color.decode("#000000"));
        arrowFirstElement.addActionListener(e -> {
            Verwaltung.myWueList.setCurrent(Verwaltung.myWueList.getFirst());

            showUser();
        });
        arrowFirstElement.setBounds(25 + widthList, 190, 70, 25);
        contentPane.add(arrowFirstElement);

        // Previous
        arrowPreviousElement = new JButton("<");
        arrowPreviousElement.setToolTipText("Vorheriges Element");
        arrowPreviousElement.setBackground(Color.decode("#FFFFFF"));
        arrowPreviousElement.setForeground(Color.decode("#000000"));
        arrowPreviousElement.addActionListener(e -> {
            if (Verwaltung.myWueList.getCurrent() == null) {
                Verwaltung.myWueList.setCurrent(Verwaltung.myWueList.getFirst());
            } else {
                Verwaltung.myWueList.setCurrent(Verwaltung.myWueList.getBefore());
            }

            showUser();
        });
        arrowPreviousElement.setBounds(95 + widthList, 190, 50, 25);
        contentPane.add(arrowPreviousElement);

        // Next
        arrowNextElement = new JButton(">");
        arrowNextElement.setToolTipText("Nächstes Element");
        arrowNextElement.setBackground(Color.decode("#FFFFFF"));
        arrowNextElement.setForeground(Color.decode("#000000"));
        arrowNextElement.addActionListener(e -> {
            if (Verwaltung.myWueList.getCurrent() == null) {
                Verwaltung.myWueList.setCurrent(Verwaltung.myWueList.getFirst());
            } else {
                Verwaltung.myWueList.setCurrent(Verwaltung.myWueList.getCurrent().getNext());
            }

            showUser();
        });
        arrowNextElement.setBounds(145 + widthList, 190, 50, 25);
        contentPane.add(arrowNextElement);

        // Last
        arrowLastElement = new JButton(">>");
        arrowLastElement.setToolTipText("Letztes Element");
        arrowLastElement.setBackground(Color.decode("#FFFFFF"));
        arrowLastElement.setForeground(Color.decode("#000000"));
        arrowLastElement.addActionListener(e -> {
            Verwaltung.myWueList.setCurrent(Verwaltung.myWueList.getLast());

            showUser();
        });
        arrowLastElement.setBounds(195 + widthList, 190, 70, 25);
        contentPane.add(arrowLastElement);

        // Inputfield Ereignisfield
        fieldEreignis = new JTextField();
        fieldEreignis.setBounds(25 + widthList, 310, 350, 25);
        contentPane.add(fieldEreignis);

        //
        Verwaltung.myWueList.setCurrent(Verwaltung.myWueList.getFirst());
        showUser();
    }
	
	// Initialisiere Liste
    protected void initList() {
        dlm.removeAllElements();

        WueList temp = Verwaltung.myWueList;
        temp.setCurrent(temp.getFirst());
        while (temp.getCurrent().hasNext()) {
            dlm.addElement(temp.getCurrent().getUser());
            temp.setCurrent(temp.getCurrent().getNext());
        }
    }

	// Zeige User
    protected void showUser() {
		// Navigiere zum ausgewhlten Nutzer
        listNutzer.setSelectedIndex(Verwaltung.myWueList.getIndex());
		
		// Deaktiviere Pfeile First,Previous wenn man am Anfang der Liste ist
        if (Verwaltung.myWueList.getCurrent() == Verwaltung.myWueList.getFirst()) {
            arrowPreviousElement.setEnabled(false);
            arrowFirstElement.setEnabled(false);
        } 
        // Aktiviere Pfeile wenn man nicht am Anfang der Liste ist
        else {
            arrowPreviousElement.setEnabled(true);
            arrowFirstElement.setEnabled(true);
        }
		
        // Deaktiviere Pfeile Last,Next wenn man am Ende der Liste ist
        if (Verwaltung.myWueList.getCurrent() == Verwaltung.myWueList.getLast()) {
            arrowNextElement.setEnabled(false);
            arrowLastElement.setEnabled(false);
        } 
        // Aktiviere Pfeile wenn man nicht am Anfang der Liste ist
        else {
            arrowNextElement.setEnabled(true);
            arrowLastElement.setEnabled(true);
        }
        // Setze Text nach dem ersten Laden
        fieldVorname.setText(Verwaltung.myWueList.getCurrent().getUser().getVorname());
        fieldName.setText(Verwaltung.myWueList.getCurrent().getUser().getNachname());
        fieldGebdat.setText(Verwaltung.myWueList.getCurrent().getUser().getGeb().toString());
    }

}
