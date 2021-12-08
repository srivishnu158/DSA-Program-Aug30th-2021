class ValidTree
{
	int[] vertexs;
	int edgesCount = 0;


	public void init(int n)
	{
		edgesCount = n;
		vertexs = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			vertexs[i] = i;
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
		edgesCount--;
		return true;

	}

	/*
		Time Complexity : O(n) = edges(n-1)*union(x,y) = O(n) * O(1) = O(n)
		Space Complexity : O(n) :: Creating no.of vertexes
	*/
	public int connectedPaths(int n, int[][] edges)
	{
		int edgesLength = edges.length;

		init(n);
		for(int i = 0 ; i < edgesLength ; i++)
		{
			int[] edge = edges[i];
			union(edge[0],edge[1]);
		}
		// find count based on unit roots of each vertex  :: vertexs[]
		return edgesCount;
	}

}

public class ConnectedPathsApp
{
	public static void main(String args[])
	{
		ValidTree tree = new ValidTree();

		System.out.println(" n=5 , {{0,1},{1,2},{3,4}}  : "
			+tree.connectedPaths(5, new int[][]{{0,1},{1,2},{3,4}}));

	System.out.println(" n=5 , {{0,1}, {1,2}, {2,3},{3,4}}  : "
			+tree.connectedPaths(5, new int[][]{{0,1},{1,2},{2,3},{3,4}}));

	}
}



