public class BSTdist{

	public static class BST{
		int data;
		BST left;
		BST right;

		BST(int d){
			this.data = d;
			this.left = null;
			this.right = null;
		}

	}

	
	public static BST insert(BST r, int n){
		
		if(r==null){
			r= new BST(n);
		}else{
			if(r.data>n){
				if(r.left==null){
					r.left = new BST(n);
				}else{
					insert(r.left,n);
				}
				
			}else{
				if(r.right==null){
					r.right = new BST(n);
				}else{
					insert(r.right,n);
				}
			}
		}
		return r;
	}
	public static BST buildBST(int[] data){
		int n = data.length;
		BST root = null;
		for(int i=0;i<n;i++){
			root = insert(root,data[i]);
			// System.out.println("entered: "+root.data);
		}
		return root;
	}
	public static void printBST(BST root){
		if(root!=null){
			printBST(root.left);
			System.out.println(root.data);
			printBST(root.right);
		}else 
		return;
	}
	public static int findDist(BST root, int n1, int n2){
        BST lca = findLeastCommonAncestor(root, n1, n2);	
		int distance = findDistanceFromLCA(lca,n1)+findDistanceFromLCA(lca,n2);
		return distance;
    }
	public static int findDistanceFromLCA(BST lca, int i) {
		int distanceSum= 0;
		while(true){
			if(lca!=null){
				if(lca.data==i)
					return distanceSum;
				else if(lca.data<i){
					distanceSum++;
					lca = lca.right;
				}
				else if(lca.data>i){
					distanceSum++;
					lca = lca.left;
				}
			}
			else 
				return distanceSum;
		}		
	}

	public static BST findLeastCommonAncestor(BST root, int i, int j) {
		while(true){
			if(root.data>i && root.data>j){
				root = root.left;
			}
			else if(root.data<i && root.data<j){
				root = root.right;
			}
			else{
				return root;
			}
		}		
	}

	public static void main(String[] args) {
		int[] input = {3,4,1,2};
		int n1 = 2;
		int n2 = 4;		
		//BSTdist ob = new BSTdist();
		BST root = buildBST(input);
		System.out.println("entered: "+root.data);
		printBST(root);        
		int d = findDist(root, n1,n2);
		System.out.println("Distance: "+d);
	}
}