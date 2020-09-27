import java.util.Comparator;
import java.util.*;
public class logs {
    public static String[] reorderLogFiles(String[] logs) {
    	Comparator<String> logComp = new Comparator<String>(){
    		@Override
    		public int compare(String log1, String log2){
    			String[] split1 = log1.split(" ",2);
    			String id1 = split1[0];
    			String ct1 = split1[1];

    			String[] split2 = log2.split(" ",2);
    			String id2 = split2[0];
    			String ct2 = split2[1];

    			boolean isAlpha1 = Character.isAlphabetic(ct1.charAt(0));
    			boolean isAlpha2 = Character.isAlphabetic(ct2.charAt(0));

    			if(isAlpha1&&isAlpha2){
    				int r = ct1.compareTo(ct2);
    				if(r==0){
    					return id1.compareTo(id2);
    				}
    				return r;
    			}
    			if(isAlpha1&&!isAlpha2){
    				return -1;
    			}
    			else if(!isAlpha1&&isAlpha2){
    				return 1;
    			}
    			else{
    				return 0;
    			}
    		}
    	};
    	Arrays.sort(logs, logComp);
        return logs;
    }
    public static void main(String[] args) {
    	String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    	logs = reorderLogFiles(logs);
    	for(String s: logs){
    		System.out.println(s);
    	}
    }
}