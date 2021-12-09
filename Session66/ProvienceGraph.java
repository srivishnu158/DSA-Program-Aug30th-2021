class UninqueGroups
{
	int[] vertexs;
	int counter;

	public void init(int n)
	{
		vertexs = new int[n];
		counter = n;
		for(int i = 0 ; i < n ; i++)
		{
			vertexs[i] = i; // n=3 {0[0], 0[1] , 2[2]}
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
		counter--;

		return true;

	}

	public int getCounter()
	{
		return counter;
	}

	/*
		Time Complexity : O(n(row) * n (col)) * O(1) union = O(n2)
		Space Complexity : O(n) :: Creating no.of vertexes 

		1 1 0
		1 1 0
		0 0 1

		n=3 {0[0], 1[1] , 2[2]} counter = 3
	
	m[0,0] [X]
	m[0,1] 1 (true)
	union(0,1) => {0[0], 1[0] , 2[2]} : conter = 2
	m[0,2] 0 (False)

	m[1,0] = 1 (True)
	union(1,0)  :: {0[0], 1[0] , 2[2]} : conter = 2 
					as 1 & 0 has same root which is 0 
					so no update in counter.

	m[1,1]  i == j False
	m[1,2] 0 Flase

	m[2,0] 0 False
	m[2,1] 0 False
	m[2,2] i==j False
	*/
	public int uninqueGroups(int n, int[][] connections)
	{
		

		init(n);
			
		for(int row = 0 ; row < n ; row++)
		{

				for(int col =  0 ; col < n ; col++)
						{
							if(row != col && connections[row][col] == 1)
							{
								union(row,col);
							}
							
						}
		}

		return counter;
	}

}

public class ProvienceGraph
{
	public static void main(String args[])
	{
			UninqueGroups ug = new UninqueGroups();
			System.out.println(" n=3, { {1,1,0} , {1,1,0} , {0,0,1} } = "
				+ug.uninqueGroups(3,new int[][] { {1,1,0} , {1,1,0} , {0,0,1} }));

			System.out.println(" n=3, { {1,0,0} , {0,1,0} , {0,0,1} } = "
				+ug.uninqueGroups(3,new int[][] { {1,0,0} , {0,1,0} , {0,0,1} }));

			System.out.println(" n=4, { {1,1,0,1 }, {1,1,0,0},{0,0,1,0},{1,0,0,1} }  = "
				+ug.uninqueGroups(4,new int[][] { {1,1,0,1 }, {1,1,0,0},{0,0,1,0},{1,0,0,1} } ));

		System.out.println(" n=4, { {1,0,0,1 }, {0,1,0,0},{0,0,1,0},{1,0,0,1} }   = "
				+ug.uninqueGroups(4,new int[][] { {1,0,0,1 }, {0,1,0,0},{0,0,1,0},{1,0,0,1} } ));

	}
}



