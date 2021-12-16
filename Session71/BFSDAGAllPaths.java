import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class DAG
{

	public List<List<Integer>> getAllPaths(int[][] graph)
	{
		int n = graph.length;
		 List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		path.add(0);
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(path);

		while( !queue.isEmpty())
		{
			 path = queue.poll();
			 int currentVertex  = path.get(path.size()-1);

			 if(currentVertex == n-1)
			 {
			 	allPaths.add(path);
			 }else
			 {
			 	int[] edges = graph[currentVertex];
			 	for(int e : edges)
			 	{
			 		List<Integer> list  = new ArrayList<>(path);
			 		list.add(e);
			 		queue.add(list);
			 	}
			 }
		}

		return allPaths;

	}
}

public class BFSDAGAllPaths
{
	public static void main(String[] args) {
		
		int[][] testCase1 = new int[][]{{1,2},{3},{3},{}};

		int[][] testCase2 = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};

		DAG d = new DAG();
		System.out.println(d.getAllPaths(testCase1));
		System.out.println(d.getAllPaths(testCase2));


	}
}










