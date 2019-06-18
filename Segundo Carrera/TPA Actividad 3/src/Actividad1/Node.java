package Actividad1;
public class Node {
	int data;
	Node left;
	Node right;

	Node(int val) {
		this.data = val;
		right = null;
		left = null;
	}

	Node(int val, Node left, Node right) {
		this.data = val;
		this.right = right;
		this.left = left;
	}

	Node getLeft() {
		return left;
	}

	void setLeft(Node left) {
		this.left = left;
	}

	Node getRight() {
		return right;
	}

	void setRight(Node right) {
		this.right = right;
	}
	public String toString() {
		return "[" + data + "]";
	}
}