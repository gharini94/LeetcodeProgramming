import java.util.*;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Iterator;
public class Articulation{

	public static HashMap<Integer, ArrayList<Integer>> deepCopyWorkAround(HashMap<Integer, ArrayList<Integer>> original)
	{
	    HashMap<Integer, ArrayList<Integer>> copy = new HashMap<>();
	    for (Map.Entry<Integer, ArrayList<Integer>> entry : original.entrySet()) {
	        copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
	    }
	    return copy;
	}
	public static void main(String[] args) {
		int nodes = 7;
		int edges = 7;

		int[][] edge ={{0,1},{0,2},{1,3},{2,3},{2,5},{5,6},{3,4}};
		HashMap<Integer, ArrayList<Integer>> init = new HashMap<Integer, ArrayList<Integer>>();
		for(int i=0;i<nodes;i++){
			ArrayList<Integer> l = new ArrayList<Integer>();
			for(int[] e:edge){
				if(e[0]==i){
					l.add(e[1]);
				}
				if(e[1]==i){
					l.add(e[0]);
				}
				//System.out.println("edge s: "+e[0]+ "e: "+e[1]);
			}
			//System.out.println("list: "+l);
			init.put(i, l);
		}
		//ArrayList<Integer>> 
		for(int i=0;i<nodes;i++){
			//int i = 0;
			
			HashMap<Integer, ArrayList<Integer>> tmp  = deepCopyWorkAround(init); 
			//HashMap<Integer, ArrayList<Integer>> tmp=new HashMap<Integer, ArrayList<Integer>>();
			// tmp=(HashMap)init.clone();
			// System.out.println("t: "+tmp);
  			boolean[] a = new boolean[nodes];
			for(int t=0;t<nodes;t++){
				a[t] =false;
			}
			tmp.remove(i);
			a[i]=true;
			System.out.println("rem: "+i);	

			for (HashMap.Entry<Integer, ArrayList<Integer>> entry : tmp.entrySet()) {					

		        System.out.print(entry.getKey()+" | ");
		        //System.out.println("before "+entry.getValue());
		        entry.getValue().remove(new Integer(i));
        		System.out.println("after "+entry.getValue());
        		for(int no : entry.getValue()){
        			a[no] =true;
        		}
		        // try{
		        // 	for(int no : entry.getValue()){
			       //  	if(no ==i){
			       //  		entry.getValue().remove(i);
			       //  		System.out.println(entry.getValue());
			       //  		continue;
			       //  	}
			       //  	a[no] =true;
			       //  }
			       //  System.out.println(entry.getValue());
		        // }catch(Exception e){
		        // 	System.out.println("exception "+e);
		        // }
		        // for(int t=0;t<nodes;t++){
		        // 	a[t]=false;
		        // }
		        System.out.println();
		    }
		        
	        for(int t=0;t<nodes;t++){
	        	if(a[t]==false){
	        		System.out.println("not presetn: "+t); 
	        	}
	        }
			//System.out.println("map: "+init.get(i).toString());
		}

		//init.put()
	}
}