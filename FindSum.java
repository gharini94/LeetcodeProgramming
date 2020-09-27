public class FindSum{
	class Node{
		int data;
		Node left;
		Node right;

		Node(int d){
			this.data = d;
			this.left = null;
			this.right = null;
		}
	}
	public static void traverse(Node root, int sum){

	}
	public static void main(String args[]){
		Node root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		root.left.right = new Node(12);
		root.left.left = new Node(8);
		root.right.left = new Node(16);
		root.right.right = new Node(25);

		int sum = 13;

		traverse(root, sum);
	}
}