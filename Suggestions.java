import java.util.*;
import java.util.regex.*;
import java.lang.*;
public class Suggestions{
	public static String[] order(String[] words){
		int n = words.length;
		for(int i = 0; i < n-1; ++i) {
	      for (int j = i + 1; j < n; ++j) {
	        if (words[i].compareTo(words[j]) > 0) {
	          String temp = words[i];
	          words[i] = words[j];
	          words[j] = temp;
	        }
	      }
	    }
		return words;
	}

	public static void findSugg(String s, String[] pr){
		List<String> sug = new ArrayList<String>();
		String[] res = new String[3];
		int n = pr.length;
		//System.out.println(s);
		String regex = "^"+s;
		//Compiling the regular expression
		Pattern pattern = Pattern.compile(regex);
		//Retrieving the matcher object
		for(int i=0;i<n;i++){
			Matcher matcher = pattern.matcher(pr[i]);
			if(matcher.find()) {
				sug.add(pr[i]);			 
			}
		}
		System.out.println(sug);
	}

	public static void main(String[] args) {
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String search = "mouse";

		products = order(products);
		for(int i=1;i<=search.length();i++){
			findSugg(search.substring(0,i), products);
		}

	}
}