import java.util.*;
public class nextPtr{
	class Node{
		int val;
	    Node left;
	    Node right;
	    Node next;
	    
	    Node(int _val) {
	        val = _val;
	    }
	    Node(){}
	}
	Node root = null;
	Node buildBT(int[] a, Node r, int i, int n){
		if(i<n){
			Node tmp = new Node(a[i]);
			r = tmp;
			r.left = buildBT(a, r.left,(2*i)+1,n);
			r.right = buildBT(a, r.right, (2*i)+2,n);
		}
		return r;
	}
	void levelOrder(Node r){
		Queue<Node> q = new LinkedList<>();
		q.offer(r);
		Node cur = r;
		while(!q.isEmpty()&&q.peek()!=null){
			if(cur.left!=null){
				q.offer(cur.left);
			}
			if(cur.right!=null){
				cur.left.next = cur.right; 
				q.offer(cur.right);
			}
			Node t = q.poll();
			System.out.println(t.val);
			if(t.next!=null)
				System.out.println(t.val+ " next: "+t.next.val);
			cur = q.peek();
		}
		return;
	}
	void printBT(Node r){
		if(r!=null){			
			System.out.println(r.val);
			printBT(r.left);
			printBT(r.right);
		}
		return;
	}
	
	public static void main(String[] args) {
		int[] inp = {1,2,3,4,5,6,7};
		nextPtr ob = new nextPtr();
		ob.root = ob.buildBT(inp,ob.root,0,7);
		//ob.printBT(ob.root);
		ob.levelOrder(ob.root);
	}
}