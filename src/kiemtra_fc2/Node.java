package kiemtra_fc2;

public class Node {
	int data;
	Node next;
	Node(int x){
		data = x;
		next = null;
	}
	Node(int x, Node t){
		data= x;
		next = t;
	}
	public String toString() {
		return data+" => ";
	}
}
