import java.util.Arrays;

class DisJointSet
{
	int[] root;
	int[] rank;

	//size 7:
	// root[] : 0[0]-1[1]-2[2]-3[3]-4[4]-5[5]-6[6]
	// rank[] : 0[1]-1[1]-2[1]-3[1]-4[1]-5[1]-6[1]

public DisJointSet(int size)
	{
		root = new int[size];
		rank = new int[size];

		for(int i = 0 ; i < size ; i++)
		{
			root[i] = i;
			rank[i] = 1;
		}		
	}
/*
	Time Complexity : O(logn) ~ O(1)

	find(4)[0] <-> find(3) [0] <-> find(2)[0] <->  find(1) [0] <-> find(0)
											 
*/
int find(int x)
{
	if(x == root[x])
	{
		return x;
	}
	return root[x] = find(root[x]);
}

/*
	Time Complexity : O(logn) ~ O(1)
*/
public void union(int x , int y)
{
	int rootX = find(x);
	int rootY = find(y);
	if(rootX != rootY)
	{
			if(rank[rootX] > rank[rootY])
			{
				root[rootY] = rootX;
			}else if(rank[rootY] > rank[rootX])
			{
				root[rootX] = rootY;
			}else
			{
				root[rootY] = rootX;
				rank[rootX] = rank[rootX]+1;

			}
	}
	
}

/*
	Time Complexity : O(logn) ~ O(1)
*/
public boolean connected(int x , int y)
{

	return find(x) == find(y);
}

}

public class PathOptimizaionWithRankOnFindAndUnionDisJointSet
{
	public static void main(String args[])
	{
		DisJointSet jointSet = new DisJointSet(9);

		// 0-1-2-3-4 :: 5-6-7 :: 9

		jointSet.union(0,1);
		jointSet.union(1,2);
		jointSet.union(2,3);
		jointSet.union(3,4);

		jointSet.union(5,6);
		jointSet.union(6,7);

		System.out.println(" Roots : 0[0]-1[0]-2[0]-3[0]-4[0] :: 5[5]-6[5]-7[5] :: 8[8] => "+Arrays.toString(jointSet.root));

		System.out.println(" Ranks : 0[2]-1[1]-2[1]-3[1]-4[1] :: 5[2]-6[1]-7[1] :: 8[1] => "+Arrays.toString(jointSet.rank));

				// 0-1-2-3-4 :: 5-6-7
		System.out.println(" isConnected(0,4) => "+jointSet.connected(0,4));
		System.out.println(" isConnected(4,5) => "+jointSet.connected(4,5));
		System.out.println(" isConnected(5,7) => "+jointSet.connected(5,7));

		jointSet.union(3,7); // findRoot(3) = 0 :: findRoot(7) = 5 => root[5] = 0
		/*
		0-1-2-3-4
		|
		5-6
		|
		7
		*/

		
		System.out.println(" Roots : 0[0]-1[0]-2[0]-3[0]-4[0] :: 5[0]-6[5]-7[5] => "+Arrays.toString(jointSet.root));

		System.out.println(" Ranks : 0[3]-1[1]-2[1]-3[1]-4[1] :: 5[2]-6[1]-7[1] => "+Arrays.toString(jointSet.rank));

		System.out.println(" isConnected(4,5) => "+jointSet.connected(4,5));
		System.out.println(" isConnected(7,2) ="+jointSet.connected(7,2));

		jointSet.union(7,8); // findRoot(7) : 7[0] -> 5[0] -> 0
 
		/*
		  8
		  |
		7-0-1-2-3-4
		  |
		 5-6
		
		*/

		System.out.println(" Roots : 0[0]-1[0]-2[0]-3[0]-4[0] :: 5[0]-6[5]-7[0]::8[0] => "+Arrays.toString(jointSet.root));
		System.out.println(" Ranks : 0[3]-1[1]-2[1]-3[1]-4[1] :: 5[2]-6[1]-7[1] ::8[1] => "+Arrays.toString(jointSet.rank));


	}
}














