public class Datum {
    private int tag;
    private int monat;
    private int jahr;

    public Datum(int tag, int monat, int jahr) {
        this.setTag(tag);
        this.setMonat(monat);
        this.setJahr(jahr);
    }

    public Datum(String datum) {

        String[] splitDatum = datum.split("\\.");

        if (splitDatum.length != 3) {
            System.out.println("Bitte gib das Datum im Format TT.MM.YYYY an.");
            return;
        }

        this.setTag(Integer.parseInt(splitDatum[0]));
        this.setMonat(Integer.parseInt(splitDatum[1]));
        this.setJahr(Integer.parseInt(splitDatum[2]));

    }

    public String getTTMM() {
        return getZweistellig(this.getTag()) + getZweistellig(this.getMonat());
    }

    private String getZweistellig(int zahl) {
        if (zahl > 0 && zahl < 10) {
            return "0" + Integer.toString(zahl).substring(0, 1);
        } else if (zahl >= 10) {
            return Integer.toString(zahl).substring(0, 2);
        } else {
            return "00";
        }
    }

    private String getVierstellig(int zahl) {
        if (zahl > 0 && zahl < 10) {
            return "000" + Integer.toString(zahl).substring(0, 1);
        } else if (zahl >= 10 && zahl < 100) {
            return "00" + Integer.toString(zahl).substring(0, 2);
        } else if (zahl >= 100 && zahl < 1000) {
            return "0" + Integer.toString(zahl).substring(0, 3);
        } else if (zahl >= 1000) {
            return Integer.toString(zahl).substring(0, 4);
        } else {
            return "0000";
        }
    }

    public String toString() {
        return getZweistellig(getTag()) + "." + getZweistellig(getMonat()) + "." + getVierstellig(getJahr());
    }

    protected int getTag() {
        return this.tag;
    }

    protected int getMonat() {
        return this.monat;
    }

    protected int getJahr() {
        return this.jahr;
    }

    protected void setTag(int tag) {
        this.tag = tag;
    }

    protected void setMonat(int monat) {
        this.monat = monat;
    }

    protected void setJahr(int jahr) {
        this.jahr = jahr;
    }
}
