
public class Node<E> {
	private E item;
	private Node<E> next;
	private Node<E> prev;
	
	public Node(E item) {
		this.item = item;
		this.next = null;
		this.prev = null;
	}

	E getItem() {
		return item;
	}

	Node<E> getNext() {
		return next;
	}
	
	Node<E> getPrev() {
		return prev;
	}

	void setItem(E item) {
		this.item = item;
	}

	void setNext(Node<E> next) {
		this.next = next;
	}
	
	void setPrev(Node<E> prev) {
		this.prev = prev;
	}
}
