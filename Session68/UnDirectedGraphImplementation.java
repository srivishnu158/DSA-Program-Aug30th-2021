import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.LinkedHashSet;

class Graph
{
Map<Integer,Set<Integer>> map = new LinkedHashMap<>(); 

/*
	Time Complexity : O(1)
*/
public void addVertex(int v)
{
	map.putIfAbsent(v,new LinkedHashSet<>());
}

/*
	Time Complexity : O(1)
*/
public void addEdge(int vx, int vy)
{
	map.putIfAbsent(vx,new LinkedHashSet<>());
	map.putIfAbsent(vy,new LinkedHashSet<>());

		map.get(vx).add(vy); // As we are using Birectional/UnDirectedGraph
		map.get(vy).add(vx);

}

/*
	Time Complexity : O(1)
*/
public boolean removeEdge(int vx, int vy)
{
	if(map.get(vx) == null  || map.get(vy) == null || !map.get(vx).contains(vy))
		{
			return false;
		}

	map.get(vx).remove(vy);
	return true;
}

/*
	Time Complexity : O(E) 
*/
public boolean removeVertex(int v)
{
	if(map.get(v) == null)
	{
		return false;
	}

	Set<Integer> edges = map.get(v);

	for(Integer e : edges)
	{
		removeEdge(e,v);
	}

	map.remove(v);

	return true;

}

/*
	Time Complexity : O(1) 
	~ Map.get(K) + Set.contains(V) = O(1) + O(1) = O(1)
 	|12| -> 10 -  11 - 100
	isConnected(12,100)
*/
public boolean isConnected(int vx, int vy)
{
	if(map.get(vx) == null  || map.get(vy) == null)
	{
		return false;
	}

	Set<Integer> edges = map.get(vx);
	return edges.contains(vy);
}


	public void print()
	{
		for(Map.Entry<Integer,Set<Integer>> me : map.entrySet())
		{
			System.out.println(me.getKey() + " => "+me.getValue());
		}
	}

}

public class UnDirectedGraphImplementation
{
	public static void main(String args[])
	{
		int[][] edges = new int[][]{{10,25},{10,15},{10,12},{12,11},{12,100},{11,101}};

		Graph g = new Graph();
		for(int[] e : edges)
		{
			int vx = e[0];
			int vy = e[1];
			g.addEdge(vx,vy);
		}

		g.print();
		System.out.println(" isConnected(10,12) ~ "+g.isConnected(10,12));
		g.removeVertex(12);
		System.out.println("\n After removing of Vertex |12| ");
		g.print();
		System.out.println(" isConnected(10,12) ~ "+g.isConnected(10,12));


	}
}
