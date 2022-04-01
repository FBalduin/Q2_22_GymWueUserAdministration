public class User {
    private int uid;
    private String vorname;
    private String nachname;
    private String username;
    private String email;
    private Datum geb;

    // Konstruktor
    public User(String vorname, String nachname, String geb) {
        this.setNachname(nachname);
        this.setVorname(vorname);
        this.setGeb(new Datum(geb));
        this.setUsername();
    }

    protected void setUsername() {
        String username = "100";

        String vorname = usernamify(this.getVorname());
        String nachname = usernamify(this.getNachname());

        if (vorname.length() < 3) {
            username += vorname;
        } else {
            username += vorname.substring(0, 3);
        }

        if (nachname.length() <= 3) {
            username += nachname;
        } else {
            username += nachname.substring(0, 3);
        }

        username += this.getGeb().getTTMM();

        this.setUsername(username);
    }

    protected void setEmail() {
        String email = "";

        String vorname = usernamify(this.getVorname());
        String nachname = usernamify(this.getNachname());

        if (vorname.length() < 3) {
            username += vorname;
        } else {
            username += vorname.substring(0, 3);
        }

        if (nachname.length() <= 3) {
            username += nachname;
        } else {
            username += nachname.substring(0, 3);
        }

        username += this.getGeb().getTTMM();

        this.setEmail(email);
    }

    public String usernamify(String a) {
        return a.toLowerCase().replace("ä", "ae").replace("ö", "oe").replace("ü", "ue").replace("ß", "ss");
    }

    // To String
    public String toString() {
        return (this.getVorname() + " " + this.getNachname());
    }

    // GETTERS AND SETTERS

    protected int getUid() {
        return uid;
    }

    protected void setUid(int uid) {
        this.uid = uid;
    }

    protected String getVorname() {
        return vorname;
    }

    protected void setVorname(String vorname) {
        this.vorname = vorname;
    }

    protected String getNachname() {
        return nachname;
    }

    protected void setNachname(String nachname) {
        this.nachname = nachname;
    }

    protected String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected Datum getGeb() {
        return geb;
    }

    protected void setGeb(Datum geb) {
        this.geb = geb;
    }
}