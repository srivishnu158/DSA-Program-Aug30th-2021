 import java.util.Queue;
 import java.util.LinkedList;
 class Sample
 {
    public int orangeRotten(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        int rottenCount = 0;


        
        Queue<int[]> queue = new LinkedList<>();
        for(int row  = 0 ; row < m ; row++)
        {
            for(int col = 0 ; col < n ; col++)
            {
                if(grid[row][col] == 2)
                {
                    queue.add(new int[]{row, col});
                }else if(grid[row][col] == 1)
                {
                   freshCount++; 
                }
            }
        }
        
        if(queue.isEmpty())
        {
            
            return freshCount > 0 ? -1 : 0;
        }
        
        int level = -1;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!queue.isEmpty())
        {
            level++;
            int size = queue.size();
            while(size > 0 ) 
            {
                int[] rotten_cell = queue.poll();
                int rotten_row = rotten_cell[0];
                int rotten_col = rotten_cell[1];
                
                for(int i = 0 ; i < directions.length ; i++)
                {
                    int[] dir = directions[i];
                    int dir_rotten_row = rotten_row+dir[0];
                    int dir_rotten_col = rotten_col+dir[1];
                if(dir_rotten_row < 0 || dir_rotten_row == m ||
                  dir_rotten_col < 0 || dir_rotten_col == n
                  || grid[dir_rotten_row][dir_rotten_col] != 1)
                {
                    continue;
                }
                    grid[dir_rotten_row][dir_rotten_col] = 2;
                    queue.add(new int[]{dir_rotten_row,dir_rotten_col});
                    rottenCount++;
                }
                
                size --;
            }
        }
        
        return freshCount == rottenCount ? level : -1;
    }
 }


public class RottenOrange
{
    public static void main(String[] args) {
        Sample s = new Sample();
        int[][] matrix = {{2,1,1},{1,1,0},{0,1,1}};
 
        System.out.println(" Rotten Count :: "+s.orangeRotten(matrix));
    }
}







        