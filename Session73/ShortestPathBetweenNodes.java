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

public List<Character> shortestPath(Character source,Character destination)
{
	List<Character> currentPath = new ArrayList<>();
	currentPath.add(source);

	Queue<List<Character>> queue = new LinkedList<>();
	queue.add(currentPath);
	Set<Character> visitedSet = new LinkedHashSet<>();

	while(!queue.isEmpty())
	{
		currentPath = queue.remove();
		Character currentCh = currentPath.get(currentPath.size()-1);
		if(!visitedSet.contains(currentCh))
		{
			
		visitedSet.add(currentCh);
		Set<Character> edges =	map.get(currentCh);
		//System.out.println(currentCh + " -> "+edges);
		for(Character e: edges)
			{
			List<Character> currentVPath = new ArrayList<>();
			currentVPath.addAll(currentPath);
				currentVPath.add(e);
				if(e == destination)
				{
					return currentVPath;
				}
				queue.add(currentVPath);
				//System.out.println(queue);

			}
		}
	}

	
	return new ArrayList<>();
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

public class ShortestPathBetweenNodes
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
		System.out.println(" BFS A->F "+g.shortestPath('A','F')); //
		
		System.out.println(" BFS B->D "+g.shortestPath('B','D'));

		System.out.println(" BFS E->A "+g.shortestPath('E','A'));

		System.out.println(" BFS C->B "+g.shortestPath('C','B'));

	    System.out.println(" BFS E->F "+g.shortestPath('E','F'));

		System.out.println(" BFS E->K "+g.shortestPath('E','K'));


	}
}




