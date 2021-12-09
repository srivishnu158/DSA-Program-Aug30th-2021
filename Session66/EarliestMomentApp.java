import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class EarliestMoment
{
	int[] vertexs;
	int edgeCount = 0;

	public void init(int n)
	{
		vertexs = new int[n];
		edgeCount = n-1;
		for(int i = 0 ; i < n ; i++)
		{
			vertexs[i] = i; // n=3 {0[0], 0[1] , 2[2]}
		}
	}

	public int find(int v)
	{
		if(v == vertexs[v]) 
		{
			return v;
		}

		vertexs[v] = find(vertexs[v]);

		return vertexs[v];
	}

	public boolean union(int vx, int vy)
	{
		int rootX = find(vx); 
		int rootY = find(vy); 

		if(rootX == rootY)
		{
			return false;
		}

		vertexs[rootY] = rootX; 
		edgeCount--;
		return true;

	}

	

	/*
		Time Complexity : O(nlogn)+O(n) = O(nlogn)
		Space Complexity : O(n) 
		*/
	public int shortestTime(int n, int[][] logs)
	{
		
		if(logs.length < n-1)
		{
			return -1;
		}

		TreeMap<Integer,int[]> map = new TreeMap<>();

		init(n);

		// n*logn
		for(int i = 0 ; i < logs.length ; i++)
		{

				map.put(logs[i][0],logs[i]);

		}

		//System.out.println(map);
		// O(n)
		for(Map.Entry<Integer,int[]> me : map.entrySet())
		{
			int timeStamp = me.getKey();
			int[] arr = me.getValue();
			
			if(union(arr[1],arr[2]) && edgeCount == 0)
			{
				return timeStamp;
			}

		}


		return -1;
	}

}

public class EarliestMomentApp
{
	public static void main(String args[])
	{
			EarliestMoment e = new EarliestMoment();


	System.out.println("n = 4 {{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}} = "
		+e.shortestTime(4,new int[][] {{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}}));


	System.out.println("n = 4 {{9,3,0},{0,2,1},{8,0,1},{1,3,2},{2,2,0},{3,3,1}} = "
		+e.shortestTime(4,new int[][] {{9,3,0},{0,2,1},{8,0,1},{1,3,2},{2,2,0},{3,3,1}}));

	}
}



