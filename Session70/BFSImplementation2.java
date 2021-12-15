import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;




class Graph
{
Map<Character,Set<Character>> map = new LinkedHashMap<>(); 

/*
	Time Complexity : O(1)
*/
public void addVertex(Character v)
{
	map.putIfAbsent(v,new LinkedHashSet<>());
}

/*
	Time Complexity : O(1)
*/
public void addEdge(Character vx, Character vy)
{
	map.putIfAbsent(vx,new LinkedHashSet<>());
	map.putIfAbsent(vy,new LinkedHashSet<>());

		map.get(vx).add(vy); // As we are using Birectional/UnDirectedGraph
		map.get(vy).add(vx);

}

/*
	Time Complexity : O(1)
*/
public boolean removeEdge(Character vx, Character vy)
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
public boolean removeVertex(Character v)
{
	if(map.get(v) == null)
	{
		return false;
	}

	Set<Character> edges = map.get(v);

	for(Character e : edges)
	{
		removeEdge(e,v);
	}

	map.remove(v);

	return true;

}

/*
	UnDirected Graph & Well connected.
	Time Complexity: O(V+E)
	SpaceComplexity: O(V)
*/

public List<Character> bfs(Character source)
{
	Set<Character> visitedSet = new LinkedHashSet<>();
	List<Character> output = new ArrayList<>();
	Queue<Character> queue = new LinkedList<>();
	if(map.get(source) == null)
	{
		return output;
	}


	queue.add(source);

	while(!queue.isEmpty())
	{
		Character v = queue.remove();
		if(!visitedSet.contains(v))  
		{
			output.add(v);
			visitedSet.add(v);
			Set<Character> edges = map.get(v);
			for(Character e: edges)
			{
				queue.add(e);
			
			}
		}
	}

	return output;
}

public void print()
	{
		System.out.println(" GRAPH :: ");
		for(Map.Entry<Character,Set<Character>> me : map.entrySet())
		{
			System.out.println(me.getKey() + " => "+me.getValue());
		}
	}

}

public class BFSImplementation2
{
	public static void main(String[] args)
	{
		/*
A = [C,D,B]
B = [A,E,F]
C = [A,E]
D = [A,E]
E = [C,D,B,F]
F =[E,B]
		*/

	char[][] edges = new char[][]{
	{'A','C'},{'A','D'},{'A','B'},
	{'B','E'},{'B','F'},
	{'C','E'},{'D','E'},{'E','F'}};

	Graph g = new Graph();
		for(char[] e : edges)
		{
			char vx = e[0];
			char vy = e[1];
			g.addEdge(vx,vy);
		}

		g.print();
		System.out.println(" BFS "+g.bfs('A'));

	}
}




