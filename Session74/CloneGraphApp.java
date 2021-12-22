import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.LinkedHashSet;


class Node
{

	 int val;
	 List<Node> neighbors;

	 public Node(int val)
	 {
	 	this.val = val;
	 	neighbors = new ArrayList<>();
	 }

	 public void printVertex()
	 {

	 		System.out.println();

	 	System.out.print( val+"["+hashCode()+"] = ");

	 	 for(Node current : neighbors)
	 	 {
	 	 	System.out.print(current.val +"["+current.hashCode()+"] -> ");
	 	 }
	 	 	 		System.out.print("null");

	 }

}

class CloneGraph
{


	/*
	Time Complexity : O(V+E)
	Space Complexity : O(V+E) ~ Creates V+E StackFrames Riskier
	*/
	public Node clone(Node root)
	{

			Map<Node,Node> clonedMap = new LinkedHashMap<>();

			return clone(root, clonedMap);
	}

	public Node clone(Node root, Map<Node,Node> clonedMap)
	{
		if(clonedMap.get(root) == null)
				{
		
		clonedMap.put(root, new Node(root.val));

		for(Node edge : root.neighbors)
		{
				clonedMap.get(root).neighbors.add(clone(edge,clonedMap));
		}
				}

		return clonedMap.get(root);
	}
	/*
	Time Complexity  : O(V+E)
	Space Complexity : O(V)
	*/
	public Node dfs(Node root)
	{
		return dfs(root, new LinkedHashMap<>());
	}


	public Node dfs(Node root, Map<Node,Node> clonedMap)
	{
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new LinkedHashSet<>();
		stack.push(root);

		while(!stack.isEmpty())
		{
		Node originalNode = stack.pop();
		if(! visited.contains(originalNode))
			{
			visited.add(originalNode);
			clonedMap.putIfAbsent(originalNode, new Node(originalNode.val));
		  for(Node nei : originalNode.neighbors)
		  			{
		  clonedMap.putIfAbsent(nei, new Node(nei.val));
		  clonedMap.get(originalNode).neighbors.add(clonedMap.get(nei));
		  stack.push(nei);
		 			 }
			}
		  
		}

		return clonedMap.get(root);
	}


	/*
	Time Complexity  : O(V+E)
	Space Complexity : O(V)
	*/
	public Node bfs(Node root)
	{
		return bfs(root, new LinkedHashMap<>());
	}


	public Node bfs(Node root, Map<Node,Node> clonedMap)
	{
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new LinkedHashSet<>();
		queue.add(root);

		while(!queue.isEmpty())
		{
		Node originalNode = queue.poll();
		if(! visited.contains(originalNode))
			{
			visited.add(originalNode);
			clonedMap.putIfAbsent(originalNode, new Node(originalNode.val));
		  for(Node nei : originalNode.neighbors)
		  			{
		  clonedMap.putIfAbsent(nei, new Node(nei.val));
		  clonedMap.get(originalNode).neighbors.add(clonedMap.get(nei));
		  queue.add(nei);
		 			 }
			}
		  
		}

		return clonedMap.get(root);
	}
	public void printGraph(Node current)
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(current);
		Set<Node> visited = new HashSet<>();
		while(!queue.isEmpty())
		{
			Node vNode = queue.poll();
			if(!visited.contains(vNode))
			{
				visited.add(vNode);
				vNode.printVertex();
				for(Node e : vNode.neighbors)
				{
					queue.add(e);
				}
			}
		}
	}
}

public class CloneGraphApp
{
	public static void main(String[] args) {
		
		Map<Integer,Node> map = new LinkedHashMap<>();

		int[][] edges = {{2,4},{1,3},{2,4},{1,3}};

		for(int i = 0 ; i < edges.length ; i++)
		{
			int[] edge = edges[i];
			int v = i+1;
			map.putIfAbsent(v,new Node(v));

			for(int ve = 0 ; ve < edge.length ; ve++)
			{
				map.putIfAbsent(edge[ve],new Node(edge[ve]));

				map.get(v).neighbors.add(map.get(edge[ve]));
			} /*
				 class Node
				 {
					int val;
					List<Node> neighbors;
				 }
			*/
			

		}

		for(Map.Entry<Integer,Node> me : map.entrySet())
		{
			me.getValue().printVertex();
		}

		CloneGraph cg = new CloneGraph();
		Node clonedRoot = cg.clone(map.get(1));

		System.out.println(" \n\n After Clone DFS + Recursive");
		cg.printGraph(clonedRoot);


		System.out.println(" \n\n After Clone :: DFS Iterative");
		Node dfsClonedRoot =cg.dfs(map.get(1));
		cg.printGraph(dfsClonedRoot);

		System.out.println(" \n\n After Clone :: BFS ");
		Node bfsClonedRoot =cg.bfs(map.get(1));
		cg.printGraph(bfsClonedRoot);

	}
}





