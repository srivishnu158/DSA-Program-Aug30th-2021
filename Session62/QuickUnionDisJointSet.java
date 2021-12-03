import java.util.Arrays;

class DisJointSet
{
	int[] root;

public DisJointSet(int size)
	{
		root = new int[size];

		for(int i = 0 ; i < size ; i++)
		{
			root[i] = i;
		}		
	}
/*
	Time Complexity : O(logn)
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
		root[rootY] = rootX;
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

public class QuickUnionDisJointSet
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

		System.out.println(" Expected : 0-0-0-0-0 :: 5-5-5 => "+Arrays.toString(jointSet.root));

				// 0-1-2-3-4 :: 5-6-7
		System.out.println(" isConnected(0,4) => "+jointSet.connected(0,4));
		System.out.println(" isConnected(4,5) => "+jointSet.connected(4,5));
		System.out.println(" isConnected(5,7) => "+jointSet.connected(5,7));

		jointSet.union(3,5);
		/*
		0-1-2-3-4
			  |
		      5-6-7
		     */
		System.out.println(" Expected : 0-0-0-0-0 :: 0-5-5 => "+Arrays.toString(jointSet.root));

		System.out.println(" isConnected(4,5) => "+jointSet.connected(4,5));
		System.out.println(" isConnected(7,2) ="+jointSet.connected(7,2));

	}
}














