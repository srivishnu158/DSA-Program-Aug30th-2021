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
	Time Complexity : O(logn)
	0[0] - 1[0] - 2[0]
		   |
		   3[0]

	4[4] - 5[4] - 6[4] 

	uninon(3,6)
	find(3) ; => 0 // 2steps
	find(6) ; => 4 // 2 steps;
	root[4] = 0

	0[0] - 1[0] - 2[0]
		   |
		   3[0]
		   |
		  4[0] - 5[4] - 6[4]

	isConnected(1,6)
		find(1) : root = 0 // 2 Steps
		find(6) : root = 0 // 3 steps
		~ At each Level n/2 ~ log(n) 

*/
int find(int x)
{
	while(x != root[x])
	{
		x = root[x];
	}
	return x;
}

/*
	Time Complexity : O(logn)
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
	Time Complexity : O(logn)
*/
public boolean connected(int x , int y)
{

	return find(x) == find(y);
}

}

public class RankBasedUnionDisJointSet
{
	public static void main(String args[])
	{
		DisJointSet jointSet = new DisJointSet(8);

		// 0-1-2-3-4 :: 5-6-7

		jointSet.union(0,1);
		jointSet.union(1,2);
		jointSet.union(2,3);
		jointSet.union(3,4);

		jointSet.union(5,6);
		jointSet.union(6,7);

		System.out.println(" Roots : 0[0]-1[0]-2[0]-3[0]-4[0] :: 5[5]-6[5]-7[5] => "+Arrays.toString(jointSet.root));

		System.out.println(" Ranks : 0[2]-1[1]-2[1]-3[1]-4[1] :: 5[2]-6[1]-7[1] => "+Arrays.toString(jointSet.rank));

				// 0-1-2-3-4 :: 5-6-7
		System.out.println(" isConnected(0,4) => "+jointSet.connected(0,4));
		System.out.println(" isConnected(4,5) => "+jointSet.connected(4,5));
		System.out.println(" isConnected(5,7) => "+jointSet.connected(5,7));

		jointSet.union(3,5);
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

	}
}














