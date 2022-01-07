 import java.util.Queue;
 import java.util.LinkedList;

class Solution1 {
    /*
        Time Complexity : O(N)     
        Space Complexity : O(N)

        Actcually here row and column length is same i.e N row's & N col's
        the logic is lenear to the input so that its O(N) :: N talks about input
        
        Solution by updating the input :
    */
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int[][] directions = {
            {-1,0},{1,0},{0,-1},{0,1},{1,-1},{1,1},{-1,-1},{-1,1}
                            };
        
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0)
        {
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = 1;
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty())
        {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            if(row == m-1 && col == n-1)
            {
                return grid[row][col];
            }
            int distance = grid[row][col];
            for(int i = 0 ; i < directions.length;i++)
            {
                int[] dir = directions[i];
                int dir_row = row + dir[0];
                int dir_col = col + dir[1];
           if(dir_row < 0 || dir_row == m || dir_col < 0 
             || dir_col == n || grid[dir_row][dir_col] != 0)
           {
               continue;
           }
                grid[dir_row][dir_col] = distance+1;
                queue.add(new int[]{dir_row,dir_col});
            }
        }
        
        return -1;
    }
}

public class ShortestPathBinaryMatrix_Sol1
{
public static void main(String args[])
    {

    Solution1 s = new Solution1();
    int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};

    System.out.println(" Solution-1 ShortestPath = "
        +s.shortestPathBinaryMatrix(grid));


    }
}