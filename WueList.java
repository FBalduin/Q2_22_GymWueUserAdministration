public class WueList {

    protected Knoten first;
    protected Knoten last;
    protected Knoten current;

    // Konstruktor
    public WueList() {
        setFirst(null);
        setLast(null);
        setCurrent(null);
    }

    // insert first
    public void insertFirst(User user) {

        Knoten newKnoten = new Knoten(user);

        // Liste ist leer
        if (getFirst() == null) {
            this.setFirst(newKnoten);
            this.setCurrent(newKnoten);
            this.setLast(newKnoten);
        }

        // Liste hat Objekte
        else {
            newKnoten.setNext(this.getFirst());
            this.setFirst(newKnoten);
        }

    }

    // append
    public void append(User user) {

        Knoten newKnoten = new Knoten(user);

        // Liste ist leer
        if (getFirst() == null) {
            this.setFirst(newKnoten);
            this.setCurrent(newKnoten);
            this.setLast(newKnoten);
        }

        // Liste hat Objekte
        else {
            this.getLast().setNext(newKnoten);
            this.setLast(newKnoten);
        }

    }

    // remove first
    public void removeFirst() {

        // Liste ist leer
        if (getFirst() == null) {
            return;
        }

        // Liste hat Objekte
        else {
            this.setFirst(this.getFirst().getNext());
        }

    }

    // remove first
    public void removeCurrent() {

        // Liste ist leer
        if (getFirst() == null) {
            return;
        }

        // Liste hat Objekte
        else {
            if (this.getCurrent() == this.getFirst()) {

                this.setFirst(this.getCurrent().getNext());
                this.setCurrent(this.getFirst());

            } else {

                this.setCurrent(this.getBefore());
                this.getCurrent().setNext(this.getCurrent().getNext().getNext());

                if (!this.getCurrent().hasNext()) {
                    this.setLast(this.getCurrent());
                }

            }
        }

    }

    // remove last
    public void removeLast() {

        // Liste ist leer
        if (getFirst() == null) {
            return;
        }

        // Liste hat Objekte
        else {
            this.get(this.getLength() - 1).setNext(null);
            this.setLast(this.get(this.getLength()));
        }

    }

    // print list
    public void printList() {
        this.setCurrent(this.getFirst());

        while (this.getCurrent() != null) {
            System.out.println(this.getCurrent().getUser().toString());
            this.setCurrent(this.getCurrent().getNext());
        }
    }
	
	// Gebe Index vom Current-Knoten zurück 
    public int getIndex() {
        Knoten temp = this.getFirst();

        int i = 0;
        while (temp.hasNext()) {
            if (temp.equals(this.getCurrent())) {
                return i;
            }

            i++;
            temp = temp.getNext();
        }

        return 0;
    }

    // Getters und Setters
    public Knoten get(int position) {
        if (position > this.getLength()) {
            return null;
        }

        this.setCurrent(this.getFirst());

        for (int i = 0; i < position; i++) {
            this.setCurrent(this.getCurrent().getNext());
        }

        return this.getCurrent();
    }
	
	// Gebe Knoten vorher zurück
    public Knoten getBefore() {
        Knoten knoten = this.getFirst();
        while (knoten.hasNext()) {
            if (knoten.getNext() == this.getCurrent()) {
                return knoten;
            }

            knoten = knoten.getNext();
        }

        return null;
    }

    // Länge der Liste
    public int getLength() {
        this.setCurrent(this.getFirst());

        int i = 0;
        while (this.getCurrent().hasNext()) {
            i++;
            this.setCurrent(this.getCurrent().getNext());
        }

        return i;
    }

	// Parse Liste in ein Array
    public User[] toArray() {
        User[] userArray = new User[this.getLength()];

        this.setCurrent(this.getFirst());

        int i = 0;
        while (this.getCurrent().hasNext()) {
            userArray[i] = this.getCurrent().getUser();

            this.setCurrent(this.getCurrent().getNext());
            i++;
        }

        return userArray;
    }
	
	// Gebe erstes Element zurück
    public Knoten getFirst() {
        return first;
    }
	
	// Setze erstes Element auf Übergabeparameter
    public void setFirst(Knoten first) {
        this.first = first;
    }
	
	// gebe letzten Knoten zurück
    public Knoten getLast() {
        return last;
    }

	// Setze erstes Last auf Übergabeparameter
    public void setLast(Knoten last) {
        this.last = last;
    }

	// Gebe Current zurück
    public Knoten getCurrent() {
        return current;
    }

	// Setze erstes Current auf Übergabeparameter
    public void setCurrent(Knoten current) {
        this.current = current;
    }
}
