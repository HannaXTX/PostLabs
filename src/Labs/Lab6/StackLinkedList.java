package Labs.Lab6;

public class StackLinkedList<T extends Comparable<T>> {
	private Node<T> topNode;

	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(topNode);
		topNode = newNode;
	}

	public Node<T> pop() {
		Node<T> toDel = topNode;
		if (topNode != null)
			topNode = topNode.getNext();
		return toDel;
	}

	public Node<T> peek() {
		return topNode;
	}

	public int length() {
		int length = 0;
		Node<T> curr = topNode;
		while (curr != null) {
			length++;
			curr = curr.getNext();
		}
		return length;
	}

	public boolean isEmpty() {
		return (topNode == null);
	}

	public void clear() {
		topNode = null;
	}
}
