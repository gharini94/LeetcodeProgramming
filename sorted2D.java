import java.util.*;
public class sorted2D{
	public static boolean bSearch(int[] arr,int res){
		int low =0;
		int high = arr.length-1;
		while(low<=high){
			int mid = (low+high-1)/2;
			if(arr[mid]==res){
				System.out.println("found: c"+(mid+1));
				return true;
			}else if(arr[mid]>res){
				high = mid-1;
			}else{
				low=mid+1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		//int[][] mat = {{10, 20, 30, 40},{15, 25, 35, 45},{27, 29, 37, 48},{32, 33, 39, 50}};
		//int ele =29;
		// for(int i=0;i<4;i++){			
		// 	boolean res = bSearch(mat[i],ele);
		// 	if(res){
		// 		System.out.println("found at: "+i+1);
		// 		break;
		// 	}
		// }

		int[][] mat = {{1,3,5,7},{10, 11, 16, 20},{23, 30, 34, 50},{51,52,53,54}};
		int ele =16;
		for(int i =0; i<3;i++){
			System.out.println("ele at: "+mat[0][i]);
			if(mat[i][0]<ele&&mat[i+1][0]>ele){
				boolean res = bSearch(mat[i],ele);
				if(res){
					System.out.println("found at: "+(i+1));
					break;
				}
			}
		}
	}
}