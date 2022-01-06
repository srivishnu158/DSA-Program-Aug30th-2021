 import java.util.Queue;
 import java.util.LinkedList;
 import java.util.Stack;

class Sample {
     Queue<int[]> queue = new LinkedList<>();
     int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
     Stack<int[]> stack = new Stack<>();


    
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        /*
            O(M*N * ~dfs call happens in  constant)
            Time Complexity :  O(M*N)
            Space Complexity : O(M*N)
        */
        for(int row = 0 ; row < m ;  row++)
        {
            for(int col = 0 ; col < n ; col++)
            {
                if(grid[row][col] == '1')
                {
                    grid[row][col] = '0';
                    dfs(row,col,m,n,grid);
                    islands++;
                }
            }
        }
       
        return islands;
    }
    
    public void bfs(int row, int col, int m , int n, char[][] grid)
    {
       
        queue.add(new int[]{row,col});
        while(!queue.isEmpty())
        {
           int[] cell = queue.poll();
            
            int cell_r = cell[0];
            int cell_c = cell[1];
            for(int i = 0 ; i < directions.length; i++)
            {
                int[] dir = directions[i];
                int dir_cell_r = cell_r + dir[0];
                int dir_cell_c = cell_c + dir[1];
                
                if(dir_cell_r < 0 || dir_cell_r == m
                  || dir_cell_c < 0 || dir_cell_c == n 
                  || grid[dir_cell_r][dir_cell_c] == '0')
                {
                    continue;
                }
                
                grid[dir_cell_r][dir_cell_c] = '0';
                queue.add(new int[] {dir_cell_r,dir_cell_c});
            }
        }
    }
    
    public void dfs(int row, int col, int m , int n, char[][] grid)
    {
       
        stack.push(new int[]{row,col});
        while(!stack.isEmpty())
        {
           int[] cell = stack.pop();
            
            int cell_r = cell[0];
            int cell_c = cell[1];
            for(int i = 0 ; i < directions.length; i++)
            {
                int[] dir = directions[i];
                int dir_cell_r = cell_r + dir[0];
                int dir_cell_c = cell_c + dir[1];
                
                if(dir_cell_r < 0 || dir_cell_r == m
                  || dir_cell_c < 0 || dir_cell_c == n 
                  || grid[dir_cell_r][dir_cell_c] == '0')
                {
                    continue;
                }
                
                grid[dir_cell_r][dir_cell_c] = '0';
                stack.push(new int[] {dir_cell_r,dir_cell_c});
            }
        }
    }
}

public class NumberOfIslands
{
    public static void main(String[] args)
    {
        Sample s = new Sample();
        
      char[][] grid =  {
{'1','1','1','1','0'},
{'1','1','0','1','0'},
{'1','1','0','0','0'},
{'0','0','0','0','0'}
    };

    System.out.println("No.Of Islands = "+s.numIslands(grid));

    }
}










