import java.util.*;
public class Keywords{
	public static void main(String[] args) {
		int k =2;
		List<String> kw = new ArrayList<String>();
		kw.add("anacell");
		kw.add("cetracular");
		kw.add("betacellular");
		int[] c = new int[kw.size()];

		List<String> review = new ArrayList<String>();
		review.add("Anacell provides the best services in the city");
		review.add("betacellular has awesome services");
		review.add("Best services provided by anacell, everyone should use anacell");
		int i=0;
		for(String key: kw){
			for(String rev:review){
				if(rev.toLowerCase().contains(key.toLowerCase())){
					c[i]++;
				}
			}
			i++;
		}
		Hashtable<Integer, String> tree_map = new Hashtable<Integer, String>();
		for(int j=0;j<kw.size();j++){
			tree_map.put(c[j],kw.get(j));
		}
		List<String> keysorted = new ArrayList<String>(tree_map.values());
		for(int t=0;t<k;t++){
			System.out.println(keysorted.get(t));
		}
		//System.out.println(tree_map);
	}
}