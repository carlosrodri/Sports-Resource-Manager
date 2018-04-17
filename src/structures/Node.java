package structures;

public class Node <T>{

	private Node<T> next;
	private T information;
	
	public Node(T information) {
		this.information = information;
	}

	public T getInformation() {
		return information;
	}

	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return information.toString();
	}
}