public class Knoten {

	protected User user;
	protected Knoten next;

	public Knoten(User user) {
		this.setUser(user);
		this.setNext(null);
	}

	public Knoten(User user, Knoten next) {
		this.setUser(user);
		this.setNext(next);
	}

	public boolean hasNext() {
		return this.getNext() != null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Knoten getNext() {
		return next;
	}

	public void setNext(Knoten next) {
		this.next = next;
	}
}
