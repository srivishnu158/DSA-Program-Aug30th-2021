import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class DAG
{

	/*
			Time Complexity  : O(V.2^V) 
			Space Complexity : O(V.2^V)
	*/

	public List<List<Integer>> getAllPaths(int[][] graph)
	{
		int n = graph.length;
		 List<List<Integer>> allPaths = new ArrayList<>();
		 List<Integer> path = new ArrayList<>();
		path.add(0);

		Stack<List<Integer> > stack = new Stack<>();
		stack.push(path);

		while( !stack.isEmpty() )
		{
			 path = stack.pop();
			 int lastIndex = path.size()-1;
			 int currentVertex = path.get(lastIndex);
			 if(currentVertex == n-1) // reached target
			 {
			 	allPaths.add(path);
			 	continue;
			 }

			 int[] edges = graph[currentVertex];
			 for(int i = 0 ; i < edges.length ; i++)
			 {
			 	int e = edges[i];
			 	List<Integer> list = new ArrayList<>();
			 	list.addAll(path);
			 	list.add(e);
			 	stack.push(list);
			 }
		}


		return allPaths;

	}
}

public class DFSDAGAllPaths
{
	public static void main(String[] args) {
		
		int[][] testCase1 = new int[][]{{1,2},{2,3},{3},{}};

		int[][] testCase2 = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};

		DAG d = new DAG();
		System.out.println(d.getAllPaths(testCase1));
		System.out.println(d.getAllPaths(testCase2));


	}
}










