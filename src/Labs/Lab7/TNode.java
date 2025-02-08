package Labs.Lab7;

public class TNode<T extends Comparable<T>> {
	private T data;
	private  TNode<T>  left;
	private  TNode<T>  right;

	public TNode(T data) {
		setData(data);
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public TNode<T> getLeft() {
		return left;
	}

	public void setLeft( TNode<T>  left) {
		this.left = left;
	}

	public TNode<T> getRight() {
		return right;
	}

	public void setRight( TNode<T>  right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return (left == null && right == null);
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public String toString() {
		return "[" + data + "]";
	}
}