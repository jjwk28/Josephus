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
	
	// 이중연결리스트의 경우 크기를 미리 지정하지 않기 때문에 데이터가 가득 차있는지를 판별해주는 Isfull() 구현 불가능
	
	public int size() { // 크기를 반환
		return size;
	}
	
	public boolean IsEmpty() { // 비어있는 경우 true를 반환
		return size == 0;
	}
	
	public Node<E> searchIndex(int idx) { // idx 위치의 노드를 반환
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
	
	public void addFirst(E data) { // 맨 앞에 값을 추가
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
	
	public void add(E data) { // 맨 마지막에 값을 추가
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
	
	public E removeLast() { // 맨 마지막의 값을 삭제 후 반환
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
	
	public E remove() { // 맨 앞의 값을 삭제 후 반환
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
	
	public E remove(int idx) { // idx 위치의 값을 삭제 후 반환
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
	
	public E getLast() { // 맨 마지막의 값을 반환
		if(size == 0) {
			throw new NoSuchElementException();
		}
		return end.getItem();
	}
	
	public E get() { // 맨 앞의 값을 반환
		if(size == 0) {
			throw new NoSuchElementException();
		}
		return start.getItem();
	}
	
	public E get(int idx) { // idx 위치의 노드를 반환
		if(size == 0) {
			throw new NoSuchElementException();
		}
		return searchIndex(idx).getItem();
	}
}

