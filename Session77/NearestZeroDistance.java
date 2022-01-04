import java.util.Queue;
import java.util.LinkedList;

class Sample
{
		/*
			Time Complexity : O(MN) 
			Space Complexiy : O(MN)
		*/
	public int[][] nearestDistance(int[][] matrix)
	{
		int m = matrix.length;
		int n = matrix[0].length;

		Queue<int[]> queue = new LinkedList<>();
		int[][] distanceMatrix = new int[m][n];

		for(int  row = 0 ; row  < m ; row++)
		{
			for(int col = 0 ; col < n ; col++)
			{
				if(matrix[row][col] == 0)
				{
					distanceMatrix[row][col] = 0;
					queue.add(new int[]{row,col});
				}else
				{
					distanceMatrix[row][col] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!queue.isEmpty())
		{
			int[] currentCell = queue.poll();
			int row = currentCell[0];
			int col = currentCell[1];

				for(int i = 0 ; i < directions.length ; i++)
				{
					int[] dir = directions[i];
					int dir_row = row+dir[0];
					int dir_col = col+dir[1];

					if(dir_row < 0 || dir_col < 0 || dir_row == m 
						|| dir_col == n )
					{
						continue;
					}

					if(
						distanceMatrix[dir_row][dir_col] > 
						distanceMatrix[row][col] + 1
					)
					{
						distanceMatrix[dir_row][dir_col] = distanceMatrix[row][col] + 1;
						queue.add(new int[]{dir_row,dir_col});
					}
				}


		}

		return distanceMatrix;
	}
}

public class NearestZeroDistance
{
	public static void main(String[] args) {
		Sample s = new Sample();
		int[][] matrix = {{1,1,1},{1,1,1},{1,0,1}};
		 /*
Output : 
3  2  3  
2  1  2  
1  0  1

		*/
	
		int[][] distance = s.nearestDistance(matrix);

		int m = matrix.length;
		int n = matrix[0].length;

		for(int  row = 0 ; row  < m ; row++)
		{
			for(int col = 0 ; col < n ; col++)
			{
				System.out.print(distance[row][col] +"  ");
			}

			System.out.println();
		}
	}
}






