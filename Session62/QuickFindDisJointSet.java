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
	Time Complexity : O(1)
*/
int find(int x)
{
	return root[x];
}

/*
	Time Complexity : O(n)

*/
public void union(int x , int y)
{
	int rootX = find(x);
	int rootY = find(y);

	if(rootX != rootY)
	{
		for(int v = 0 ; v < root.length; v++)
		{
			if(root[v] == rootY)
			{
				root[v] = rootX;
			}
		}
	}
}

/*
	Time Complexity : O(1)
*/
public boolean connected(int x , int y)
{

	return find(x) == find(y);
}

}

public class QuickFindDisJointSet
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
		System.out.println(" Expected : 0-0-0-0-0 :: 0-0-0 => "+Arrays.toString(jointSet.root));

		System.out.println(" isConnected(4,5) => "+jointSet.connected(4,5));
		System.out.println(" isConnected(7,2) ="+jointSet.connected(7,2));

	}
}














