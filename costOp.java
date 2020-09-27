import java.util.*;
public class costOp {
	public static void main(String[] args) {
		int[] arr = {2,3,4,10};
		int n =arr.length;
		Stack<Integer> st = new Stack<>();
		int cost=0;
		for(int i=0;i<n;i++){
			if(st.isEmpty())
				st.push(arr[i]);
			else{
				int ele = st.pop();
				cost =cost+ele+arr[i];
				st.push(ele+arr[i]);
			}
		}
		System.out.println(cost);
	}
}