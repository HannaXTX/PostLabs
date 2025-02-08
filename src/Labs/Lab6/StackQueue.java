package Labs.Lab6;

public class StackQueue<T extends Comparable<T>> {
	private final StackLinkedList<T> stack = new StackLinkedList<>();


	public T dequeue() {
		T data = null;
		if (!stack.isEmpty()) {
			data = stack.pop().getData();
		}
		return data;
	}


	public T getFront() {
		T data = null;
		if (!stack.isEmpty()) {
			data = stack.peek().getData();
		}
		return data;
	}


	public void enqueue(T data) {
		StackLinkedList<T> tempStack = new StackLinkedList<>();
		while (!stack.isEmpty()) {
			tempStack.push(stack.pop().getData());
		}
		stack.push(data);
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop().getData());
		}
	}


	public boolean isEmpty() {
		return stack.isEmpty();
	}


	public void clear() {
		if (!stack.isEmpty()) {
			stack.clear();
		}

	}


	public String toString() {
		String string = "";
		StackLinkedList<T> tempStack = new StackLinkedList<>();
		while (!stack.isEmpty()) {
			tempStack.push(stack.pop().getData());
		}
		while (!tempStack.isEmpty()) {
			Node<T> node = tempStack.pop();
			stack.push(node.getData());
			string += node.getData() + " ";
		}

		return string;
	}
}