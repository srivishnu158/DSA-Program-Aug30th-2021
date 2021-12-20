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
	Time Complexity: O(v-1)!
	SpaceComplexity: O(V-1)!
*/

public List<List<Character>> getAllPathsBFS(Character source,Character destination)
{
	List<List<Character>> allPaths = new ArrayList<List<Character>>();

	if(map.get(source) == null)
	{
		return new ArrayList<>();
	}

	List<Character> currentPath = new ArrayList<>();
	currentPath.add(source);

	Queue<List<Character>> queue = new LinkedList<>();
	queue.add(currentPath);


	while(!queue.isEmpty())
	{
		currentPath = queue.remove();
		Character currentCh = currentPath.get(currentPath.size()-1);
		
		Set<Character> edges =	map.get(currentCh);
		//System.out.println(currentCh + " -> "+edges);
		for(Character e: edges)
			{
			List<Character> currentVPath = new ArrayList<>();
				currentVPath.addAll(currentPath);
				currentVPath.add(e);

				if(e == destination)
				{
					allPaths.add(currentVPath);

					continue;
				}
				
				if(!currentPath.contains(e))
				{
					queue.add(currentVPath);
				}
				//System.out.println(queue);

			

		}
	}

	
	return allPaths;
}

/*
	UnDirected Graph & Well connected.
	Time Complexity: O(V-1)!
	SpaceComplexity: O(V-1)!
*/

public List<List<Character>> getAllPathsDFS(Character source,Character destination)
{
	List<List<Character>> allPaths = new ArrayList<List<Character>>();

	if(map.get(source) == null)
	{
		return new ArrayList<>();
	}

	List<Character> currentPath = new ArrayList<>();
	currentPath.add(source);

	Stack<List<Character>> stack = new Stack<>();
	stack.add(currentPath);


	while(!stack.isEmpty())
	{
		currentPath = stack.pop();
		Character currentCh = currentPath.get(currentPath.size()-1);
		
		Set<Character> edges =	map.get(currentCh);
		//System.out.println(currentCh + " -> "+edges);
		for(Character e: edges)
			{
			List<Character> currentVPath = new ArrayList<>();
				currentVPath.addAll(currentPath);
				currentVPath.add(e);

				if(e == destination)
				{
					allPaths.add(currentVPath);

					continue;
				}
				
				if(!currentPath.contains(e))
				{
					stack.push(currentVPath);
				}
				//System.out.println(queue);
			}
	}

	
	return allPaths;
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

public class UnDirectedGraphAllPaths
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
		System.out.println(" BFS "+g.getAllPathsBFS('A','F')); 
	    System.out.println(" DFS "+g.getAllPathsDFS('A','F')); 

	}
}




