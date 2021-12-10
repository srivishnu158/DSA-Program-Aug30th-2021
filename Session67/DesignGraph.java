import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.ArrayList;

class Graph
{
	 List<Set<Integer>> list  = null; // equals to :: HashSet[]

	 public Graph(int size)
	 {
			list  = new ArrayList<>(size);
			for(int i = 0 ; i < size ; i++)
			{
				list.add(i,new LinkedHashSet<>());
			}
	 }
	
	 public void addVertex(int v)
	 {
	 	list.add(v, new LinkedHashSet<>());
	 }

	 public void removeVertex(int vy)
	 {

	 	list.set(vy,null);

	 	for(int vx = 0 ; vx < list.size() ; vx++)
	 		{
	 			removeEdge(vx,vy);
	 		}


	 }

	 public void addEdge(int vx,int vy)
	 {

	 	if(list.get(vx) == null)
	 	{
	 		addVertex(vx);
	 	}

	 	list.get(vx).add(vy);
	 }

	 public void removeEdge(int vx,int vy)
	 {
	 		
	 		if(list.get(vx) != null && list.get(vx).contains(vy))
	 		{
	 			list.get(vx).remove(vy);
	 		}
	 }

	
	 public void print()
	 {
	 	for(int v = 0 ; v < list.size() ; v++)
	 	{
	 		if(list.get(v) != null)
	 		{

	 		System.out.print(" Vertex [ "+v+" ] => ");

	 		Set<Integer> edges = list.get(v);
	 		
	 			for(Integer e :edges)
	 				{
	 			System.out.print(e+" -> ");
	 				}
	 		
	 		System.out.print(" null");
	 		System.out.println();
	 		}
	 		

	 	}
	 }

}



public class DesignGraph
{
	public static void main(String[] args) {
		
		int[][] edges = new int[][]{{0,1},{0,2},{1,2},{2,1},{2,0},{1,0} };

		Graph  unDirectedGraph = new Graph(3);

		for(int i = 0 ; i < edges.length ; i++)
		{
			int[] e = edges[i];
			unDirectedGraph.addEdge(e[0],e[1]);
		}

		System.out.println(" UnDirected Graph !!!");
		unDirectedGraph.print();


		edges =  new int[][]{{0,1},{1,2},{0,2}};

		Graph  directedGraph = new Graph(3);

		for(int i = 0 ; i < edges.length ; i++)
		{
			int[] e = edges[i];
			directedGraph.addEdge(e[0],e[1]);
		}

		System.out.println(" Directed Graph !!!");
		directedGraph.print();

		System.out.println(" \n\n After Remove of V(1)");
		unDirectedGraph.removeVertex(1);
		directedGraph.removeVertex(1);

				System.out.println(" UnDirected Graph !!!");
				unDirectedGraph.print();

				System.out.println(" Directed Graph !!!");
				directedGraph.print();



				System.out.println(" UnDirected Graph !!! Remove Ende 2 -> 0");
				unDirectedGraph.removeEdge(2,0);
				unDirectedGraph.print();



	}
}











