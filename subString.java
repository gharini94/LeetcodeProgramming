import java.util.*;
public class subString{
	static boolean isUniqueChars(String str) {
	 if (str.length() > 128) return false;
	   boolean[] char_set = new boolean[128];
	   for (int i= 0; i < str.length(); i++) {
	     int val= str.charAt(i);
	     if (char_set[val]) {
	       return false;
	      }
	    char_set[val] = true;
	   }
	  return true;
	}
	public static void main(String[] args) {
		String s="awaglknagawunagwkwagl";
		int k=4;
		HashSet hs = new HashSet<String>();

		for(int i=0;i<s.length()-k;i++){//n
			String t = s.substring(i,i+k);
			if(isUniqueChars(t)){//k
				hs.add(t);
			}
		}
		System.out.println(hs);
	}
}