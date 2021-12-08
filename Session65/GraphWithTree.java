class ValidTree
{
	int[] vertexs;


	public void init(int n)
	{
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

		return true;

	}

	/*
		Time Complexity : O(n) = edges(n-1)*union(x,y) = O(n) * O(1) = O(n)
		Space Complexity : O(n) :: Creating no.of vertexes
	*/
	public boolean isValidTree(int n, int[][] edges)
	{
		int edgesLength = edges.length;
		if(edgesLength != n-1)
		{
			return false;
		}

		init(n);
		for(int i = 0 ; i < edgesLength ; i++)
		{
			int[] edge = edges[i];
				if(!union(edge[0],edge[1]))
				{
					return false;
				}
		}

		return true;
	}

}

public class GraphWithTree
{
	public static void main(String args[])
	{
		ValidTree tree = new ValidTree();

		System.out.println(" n=4 , {{0,1} {2,3}}  : "
			+tree.isValidTree(4, new int[][]{{0,1}, {2,3}}));

	System.out.println(" n=4 , {{0,1}, {1,2}, {2,3}}  : "
			+tree.isValidTree(4, new int[][]{{0,1},{1,2},{2,3}}));

	System.out.println(" n=4 , {{0,1}, {0,3}, {1,3}}  : "
			+tree.isValidTree(4, new int[][]{{0,1},{0,3},{1,3}}));



	System.out.println(" n=5 , {{0,1}, {0,4} , {1,4}, {2,3}}  : "
			+tree.isValidTree(5, new int[][]{{0,1}, {0,4} , {1,4}, {2,3}}));
	}
}



