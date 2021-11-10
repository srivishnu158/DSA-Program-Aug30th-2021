import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class PlayList
{
	List<Integer> songsList = new ArrayList<>();
	Map<Integer,Integer> map = new HashMap<>(); // key: songId , value : index
	Random r = new Random();

	/*
		Time Complexity : O(1)
	*/

	public boolean addSong(int songId)
	{
		if(map.containsKey(songId))
		{
			return false;
		}
		songsList.add(songId);
		map.put(songId,songsList.size()-1);
		return true;
	}

	/*
		Time Complexity : O(1)
	1) Get currentSongIndex From Map.
	2) Swap currentSongIndex  within ArrayList with the LastIndexValue
	3) Update the lastIndexSongId index in the map with the current RemovedSongIndex
	4) Remove the LastIndex from the ArrayList.
	5) Remove currentSongId from Map.
O(1)  + O(1) + O(1) + O(1)+ O(1) = O(1)
	*/

	public boolean removeSong(int songId)
	{
		if(map.containsKey(songId))
		{
			int currentSongIndex = map.get(songId);
			int lastIndex = songsList.size()-1;
			int lastSongId = songsList.get(lastIndex);

			songsList.set(currentSongIndex,lastSongId);
			songsList.remove(lastIndex);

			map.put(lastSongId,currentSongIndex);
			map.remove(songId);

				return true;
		}
		
		return false;
	}

	/*
		Time Complexity : O(1)
// We need to apply visitedNodes concept here, when the period comes  
in Random Generator.
// You can optimise either by writing your own Random class with perfect analysis
  			(OR)
   maintain Set<Integer> has playedSongIds
	*/

	public int getRandom()
	{
		int randomIndex = r.nextInt(songsList.size());
		return songsList.get(randomIndex);
	}

	public List<Integer> getSongsList()
	{
		return songsList;
	}
}


public class DesignShufflePlayList
{
 
 /*
 addSong(7); => true
addSong(15); => true
addSong(3); => true
getRandom(); => can return 7 or 15 or 3
addSong(15) => false
removeSong(15); => true
getRandom(); => can return 7 or 3 
removeSong(15); => false
 */
 public static void main(String args[])
 {
 	PlayList p = new PlayList();

 	System.out.println( " addSong(7) => "+p.addSong(7));
 	
 	System.out.println( " addSong(15) => "+p.addSong(15));

 	System.out.println( " addSong(3) => "+p.addSong(3));

 	System.out.println( " addSong(17) => "+p.addSong(17));
 	
 	System.out.println( " addSong(26) => "+p.addSong(26));

 	System.out.println( " addSong(11) => "+p.addSong(11));

 		System.out.println(" \nAfter add Test Random () \n");

 		int i = 1;
 		while( i <= p.getSongsList().size())
 		{
 			System.out.println( " getRandom() "+p.getRandom() );
 			i++;
 		}

 	System.out.println( " addSong(15) => "+p.addSong(15));

 	System.out.println( " removeSong(15) => "+p.removeSong(15));

 	System.out.println(" \n After Remove Test Random () \n");

 		 i = 1;
 		while( i <= p.getSongsList().size())
 		{
 			System.out.println( " getRandom() "+p.getRandom() );
 			i++;
 		}

 	System.out.println( " \nremoveSong(15) => "+p.removeSong(15));

 }

}















