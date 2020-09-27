import java.util.*;
public class Zombies{
	static final int ROW = 4, COL = 5;
	static Queue<int[]> queue = new LinkedList<>();
	static int turnZombie(int m[][], int humans){
		int c = 0;
		int[][] next = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
		while(!queue.isEmpty()&&humans>0){
			int size = queue.size();
			for(int i=0;i<size;i++){
				int[] z = queue.poll();
				for(int j=0;j<4;j++){
					int[] t = next[j];
					int nx = z[0]+t[0];
					int ny = z[1]+t[1];

					if(nx>=0&&nx<ROW&&ny>=0&&ny<COL&&m[nx][ny]==0){
						m[nx][ny]=1;
						queue.offer(new int[]{nx,ny});
						humans--;
					}
				}
			}
			c++;
		}
		return c;
	}
	
	static void countHumans(int m[][]){
		//boolean visit[][] = new boolean[ROW][COL];
		int humans =0;
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COL;j++){
				if(m[i][j]==1){
					queue.offer(new int[]{i,j});
				}else{
					humans++;
				}
			}
		}
		//System.out.println("sc"+c);
		System.out.println(" res "+turnZombie(m,humans));
		//return c;
	}
	public static void main(String[] args) {
		int M[][] ={{0, 1, 1, 0, 1},
		 {0, 1, 0, 1, 0},
		 {0, 0, 0, 0, 1},
		 {0, 1, 0, 0, 0}};
		countHumans(M);
	}
}