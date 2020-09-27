import java.util.*;
public class occurence{
	public static int bfSearch(int[] arr,int res){
		int low =0;
		int high = arr.length-1;
		int mid = (low+high)/2;
		while(low<=high){
			mid = (low+high)/2;
			if(arr[mid]==res){
				System.out.println("found: c"+(mid+1));
				return mid;
			}else if(arr[mid]>res){
				high = mid-1;
			}else{
				low=mid+1;
			}
		}
		return 0;
	}
	public static int bSearch(int[] arr,int res){
		int low =0;
		int high = arr.length-1;
		int mid = (low+high)/2;
		while(low<=high){
			mid = (low+high)/2;
			if(arr[mid]==res){
				System.out.println("found: c"+(mid+1));
				return mid;
			}else if(arr[mid]>res){
				high = mid-1;
			}else{
				low=mid+1;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int first = bSearch(nums,target);
		int last = bSearch(nums,10);
		System.out.println(first+" : "+last);
	}
}