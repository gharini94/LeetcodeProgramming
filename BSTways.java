import java.util.*;
public class BSTways{

	public static int[][] finddp(int m, int n){
		int[][] dp = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				dp[i][j]=0;
			}
		}
		for(int i=0;i<=m;i++){
			dp[i][0]=1;
		}
		for(int i=0;i<=n;i++){
			dp[0][i]=1;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp;
	} 
        
    public static int findWay(int[] arr, int[][] dp){
    	int len = arr.length;
    	if(len==0){
    		return 1;
    	}
    	//
    	List<Integer> big = new ArrayList<>();
    	List<Integer> small = new ArrayList<>();
    	for(int i=1;i<len;i++){
    		if(arr[i]>arr[0]){
    			big.add(arr[i]);
    		}else if(arr[i]<arr[0]){
    			small.add(arr[i]);
    		}
    	}

    	int ans = dp[big.size()][small.size()];
    	System.out.println(big+" "+small+" ans: "+ans);
    	int x=1;
    	
    	if(big.size()>0){
    		x = findWay(big.stream().mapToInt(i->i).toArray(), dp);
    		System.out.println("big"+big+ " x: "+x);
    	}
    	if(small.size()>0){
    		x = findWay(small.stream().mapToInt(i->i).toArray(), dp);
    		System.out.println("big"+big+ " x: "+x);
    	}
    	ans*=x;
    	return ans;
    } 

	public static void main(String[] args) {
		int[] arr = {3,4,5,1,2};
		int n =arr.length;
		int[][] dp = finddp(n,n);
		for(int i=0;i<=n;i++){
			for(int j=0;j<=n;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
		int ways = findWay(arr,dp);
		System.out.println(ways%(Math.pow(10,9)+7)-1);
	}
}