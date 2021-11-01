import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {
	private Node<E> start;
	private Node<E> end;
	private int size;
	
	public DoubleLinkedList() {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	// ���߿��Ḯ��Ʈ�� ��� ũ�⸦ �̸� �������� �ʱ� ������ �����Ͱ� ���� ���ִ����� �Ǻ����ִ� Isfull() ���� �Ұ���
	
	public int size() { // ũ�⸦ ��ȯ
		return size;
	}
	
	public boolean IsEmpty() { // ����ִ� ��� true�� ��ȯ
		return size == 0;
	}
	
	public Node<E> searchIndex(int idx) { // idx ��ġ�� ��带 ��ȯ
		if(idx <= size / 2) {
			Node<E> node = start;
			
			for(int i = 0; i < idx; i++) {
				node = node.getNext();
			}
			return node;
		}
		else {
			Node<E> node = end;
			
			for(int i = size-1; i > idx; i--) {
				node = node.getPrev();
			}
			return node;
		}
	}
	
	public void addFirst(E data) { // �� �տ� ���� �߰�
		Node<E> node = new Node<E>(data);
		node.setNext(start);
		if(start != null) {
			start.setPrev(node);
		}
		start = node;
		size++;
		if(start.getNext() == null) {
			end = start;
		}
	}
	
	public void add(E data) { // �� �������� ���� �߰�
		if(size == 0) {
			addFirst(data);
			return;
		}
		
		Node<E> node = new Node<E>(data);
		end.setNext(node);
		node.setPrev(end);
		end = node;
		size++;
	}
	
	public E removeLast() { // �� �������� ���� ���� �� ��ȯ
		if(size == 0) {
			throw new NoSuchElementException();
		}
		E temp = end.getItem();
		Node<E> prev_node = end.getPrev();
		end.setItem(null);
		end.setPrev(null);
		if(prev_node != null) {
			prev_node.setNext(null);
		}
		end = prev_node;
		size--;
		
		if(size == 0) {
			start = null;
		}
		return temp;
	}
	
	public E remove() { // �� ���� ���� ���� �� ��ȯ
		if(size == 0) {
			throw new NoSuchElementException();
		}
		E temp = start.getItem();
		Node<E> next_node = start.getNext();
		start.setItem(null);
		start.setNext(null);
		if(next_node != null) {
			next_node.setPrev(null);
		}
		start = next_node;
		size--;
		
		if(size == 0) {
			end = null;
		}
		return temp;
	}
	
	public E remove(int idx) { // idx ��ġ�� ���� ���� �� ��ȯ
		if(size == 0) {
			throw new NoSuchElementException();
		}
		if(idx == 0) {
			return remove();
		}
		if(idx == size-1) {
			return removeLast();
		}
		
		Node<E> prev_node = searchIndex(idx-1);
		Node<E> node = prev_node.getNext();
		Node<E> next_node = node.getNext();
		E temp = node.getItem();
		prev_node.setNext(next_node);
		next_node.setPrev(prev_node);
		node.setNext(null);
		node.setPrev(null);
		size--;
		return temp;
	}
	
	public E getLast() { // �� �������� ���� ��ȯ
		if(size == 0) {
			throw new NoSuchElementException();
		}
		return end.getItem();
	}
	
	public E get() { // �� ���� ���� ��ȯ
		if(size == 0) {
			throw new NoSuchElementException();
		}
		return start.getItem();
	}
	
	public E get(int idx) { // idx ��ġ�� ��带 ��ȯ
		if(size == 0) {
			throw new NoSuchElementException();
		}
		return searchIndex(idx).getItem();
	}
}

