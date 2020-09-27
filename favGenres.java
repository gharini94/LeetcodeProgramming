import java.util.*;
public class favGenres{
	public static void main(String[] args) {
		Map<String, List<String>> userSongs = new HashMap<>();
		Map<String, List<String>> songGenres = new HashMap<>();
		List<String> tmp = new ArrayList<>();
		tmp.add("song1");
		tmp.add("song2");
		tmp.add("song3");
		tmp.add("song4");
		tmp.add("song8");
		userSongs.put("David",new ArrayList<>(tmp));
		// for(Map.Entry e: userSongs.entrySet()){
		// 	System.out.println(e.getValue());
		// }
		tmp.clear();
		tmp.add("song5");
		tmp.add("song6");
		tmp.add("song7");
		userSongs.put("Emma",new ArrayList<>(tmp));
		tmp.clear();
		tmp.add("song1");
		tmp.add("song3");
		songGenres.put("Rock",new ArrayList<>(tmp));
		tmp.clear();
		tmp.add("song7");
		songGenres.put("Dubstep",new ArrayList<>(tmp));
		tmp.clear();
		tmp.add("song2");
		tmp.add("song4");
		songGenres.put("Techno",new ArrayList<>(tmp));
		tmp.clear();
		tmp.add("song5");
		tmp.add("song6");
		songGenres.put("Pop",new ArrayList<>(tmp));
		tmp.clear();
		tmp.add("song8");
		tmp.add("song9");
		songGenres.put("Jazz",new ArrayList<>(tmp));
		System.out.println("userSongs");
		Map<String, List<String>> userGenres = new HashMap<>();
		List<String> genre = new ArrayList<>();
		for(Map.Entry e: userSongs.entrySet()){
			String song = e.getValue();	
			String user = e.getKey();	
			for(Map.Entry e: songGenres.entrySet()){
				if(song = e.getValue()){
					System.out.println(e.getKey());
					genre.add(e.getKey());
					userGenres.put(user, genre);
				}
				
			}	
			System.out.println();
		}
		System.out.println("songGenres");
		



	}
}