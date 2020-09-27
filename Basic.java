import java.util.LinkedList;
public class Basic{

	static int k = 3;
	static LinkedList<Integer> cache = new LinkedList<Integer>();
	static int[] page = {1,2,3,4,1,2,5,1,2,3,4,5};
	static int pf =0;

	public static boolean checkCache(int p){
		return cache.contains(p);
	}

	public static void moveFront(Integer p){
		cache.remove(p);
		cache.offerFirst((int)p);
	}

	public static void removeEle(){
		cache.pollLast();
	}

	public static void addFront(int p){		
		cache.offerFirst(p);
	}

	public static boolean cacheFull(){
		return cache.size()==k;
	}

	public static void main(String[] args) {
		for(int i=0;i<page.length;i++){
			int c = page[i];
			System.out.println("cur: "+c+" p/a: "+ checkCache(c));
			if(checkCache(c)){				
				moveFront(c);
			}else{

				pf++;
				if(cacheFull()){
					removeEle();
				}
				addFront(c);
			}
			System.out.println(" frame: "+cache.toString());
		}
		System.out.println(pf);
	}
}