public class disconnectedComp{
    static final int ROW = 5, COL = 5;

    public static int countComponents(int n, int[][] edges) {
        int count = n;
     
        int[] root = new int[n];
        // initialize each node is an island
        for(int i=0; i<n; i++){
            root[i]=i;        
        }
     
        for(int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
     
            int xRoot = getRoot(root, x);
            int yRoot = getRoot(root, y);
     
            if(xRoot!=yRoot){
                count--;
                root[xRoot]=yRoot;
            }     
        }     
        return count;
    }
     
    public static int getRoot(int[] arr, int i){
        while(arr[i]!=i){
            arr[i]= arr[arr[i]];
            i=arr[i];
        }
        return i;
    }
    public static void main(String[] args) {
        // int M[][] ={{ 0,1 }, 
        //                           { 1,2 }, 
        //                           { 3,4 }};
                                  
        // int n=5;
        int[][] M ={{0,1},{1,0}};
        int n=2;
        System.out.println(countComponents(n,M));
    }
}