public class copyLL{
	static class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	public static void print(Node head){
		while(head!=null){
			System.out.println("val: "+head.val);
			if(head.random!=null){
				System.out.println("random: "+head.random.val);
			}		
			head = head.next;
		}
		return;
	}
	public static Node makeCopy(Node head1){
		if(head1==null){
			return null
		}
		Node head2 = null;
		Node tmp = head2;
		while(head!=null){
			System.out.println("val: "+head.val);
			tmp.val=head.val;
			
			if(head.random!=null){
				System.out.println("random: "+head.random.val);
			}		
			head = head.next;
		}

	}
	public static void main(String[] args) {
		//[7,null],[13,0],[11,4],[10,2],[1,0]

		Node head = new Node(7);		
		head.next = new Node(13);		
		head.next.next = new Node(11);		
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(1);
		head.random = null;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;

		print(head);

		Node copy = makeCopy(head);

	}
}