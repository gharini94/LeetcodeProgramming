public class DFS{
	static final int ROW = 5, COL = 5;

	static boolean isSafe(int m[][], int r, int c, boolean v[][]){
		return(r>=0&&r<ROW&&c>=0&&c<COL&&m[r][c]==1&&!v[r][c]);
	}
	static void DFS(int m[][], int r, int c, boolean v[][]){
		int[] rn = {-1,-1,-1,0,0,1,1,1};
		int[] cn = {-1,0,1,1,-1,-1,0,1};

		v[r][c]=true;
		for(int i=0;i<rn.length;i++){
			if(isSafe(m,r+rn[i],c+cn[i],v))
				DFS(m,r+rn[i],c+cn[i],v);
		}
	}
	static int countIslands(int m[][]){
		boolean visit[][] = new boolean[ROW][COL];
		int c =0;
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COL;j++){
				if(m[i][j]==1&&!visit[i][j]){
					DFS(m,i,j,visit);
					c++;
				}
			}
		}
		return c;
	}
	public static void main(String[] args) {
		int M[][] ={{ 1, 1, 1, 1, 0 }, 
                                  { 1, 1, 0, 1, 0 }, 
                                  { 1, 1, 0, 0, 0 }, 
                                  { 0, 0, 0, 0, 0 }, 
                                  { 0, 0, 1, 0, 1 } };
		System.out.println(countIslands(M));
	}
}