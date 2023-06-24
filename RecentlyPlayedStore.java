package Test;


	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	public class RecentlyPlayedStore {
	    private int capacity;
	    private Map<String, List<String>> recentlyPlayed;

	    public RecentlyPlayedStore(int initialCapacity) {
	        capacity = initialCapacity;
	        recentlyPlayed = new HashMap<>();
	    }

	    public void addSong(String user, String song) {
	        if (!recentlyPlayed.containsKey(user)) {
	            recentlyPlayed.put(user, new ArrayList<>());
	        }

	        List<String> songs = recentlyPlayed.get(user);
	        if (songs.size() == capacity) {
	            songs.remove(0);
	        }

	        songs.add(song);
	    }

	    public List<String> getRecentlyPlayedSongs(String user) {
	        return recentlyPlayed.getOrDefault(user, new ArrayList<>());
	    }

	    public static void main(String[] args) {
	        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
	        store.addSong("user1", "S1");
	        store.addSong("user1", "S2");
	        store.addSong("user1", "S3");
	        System.out.println(store.getRecentlyPlayedSongs("user1"));

	        store.addSong("user1", "S4");
	        System.out.println(store.getRecentlyPlayedSongs("user1"));

	        store.addSong("user1", "S2");
	        System.out.println(store.getRecentlyPlayedSongs("user1"));

	        store.addSong("user1", "S1");
	        System.out.println(store.getRecentlyPlayedSongs("user1"));
	    }
	}


