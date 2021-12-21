import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashMap;


class Node
{

	 int val;
	 List<Node> neighbors;

	 public Node(int val)
	 {
	 	this.val = val;
	 	neighbors = new ArrayList<>();
	 }

	 public String toString()
	 {

	 		System.out.println();

	 	System.out.print( val+"["+hashCode()+"] = ");

	 	 for(Node current : neighbors)
	 	 {
	 	 	System.out.print(current.val +"["+current.hashCode()+"] -> ");
	 	 }
	 	 	 		System.out.print("null");

	 	 return "";
	 }

}

class CloneGraph
{


	/*
	Time Complexity : O(V+E)
	Space Complexity : O(V) ~ Creates V StackFrames Riskier
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
		
		clonedMap.putIfAbsent(root, new Node(root.val));

		for(Node edge : root.neighbors)
		{
				clonedMap.get(root).neighbors.add(clone(edge,clonedMap));
		}
				}

		return clonedMap.get(root);
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
			}
			

		}

		for(Map.Entry<Integer,Node> me : map.entrySet())
		{
			System.out.println();
			System.out.print(me.getKey()+ "["+me.getValue().hashCode() +"] => ");
			for(Node n : me.getValue().neighbors)
			{
				
					System.out.print(n.val+"["+n.hashCode()+" ] ");
				
			}
		}

		CloneGraph cg = new CloneGraph();
		Node clonedRoot = cg.clone(map.get(1));

		System.out.println(" \n\n After Clone :: Print result in BFS Traversal");
		Node current = clonedRoot;
		Queue<Node> queue = new LinkedList<>();
		queue.add(current);
		Set<Node> visited = new HashSet<>();
		while(!queue.isEmpty())
		{
			Node vNode = queue.poll();
			if(!visited.contains(vNode))
			{
				visited.add(vNode);
				System.out.print(vNode);
				for(Node e : vNode.neighbors)
				{
					queue.add(e);
				}
			}
		}

	}
}





