import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
import java.util.List;

class Sample
{

  private List<int[]> directions  = Arrays.asList(

          new int[] {-1,0}, // UP
          new int[] {1,0},  // Down
          new int[] {0,-1}, // Left
          new int[] {0,1} // Right
      );

  private Integer empty = Integer.MAX_VALUE;
  private Integer wall = -1;
  private Integer gate = 0;

/*
    
    Algo :
     Find out gates and add positions to Queue .
     See the nerest emptyRoom  , increment the value then add
     position to the Queue. 

    Time Complexity : O(MN)
    Space Complexity : O(MN)
*/
  public void nearestGate(int[][] rooms)
  {
      Queue<int[]> queue  = new LinkedList<>();
     

      int m = rooms.length;
      int n = rooms[0].length;

    // Add all positions of Gates to the Queue
      for(int row = 0 ; row < m ; row++)
      {
        for(int col = 0 ; col < n ; col++)
        {
            if(rooms[row][col] == gate)
            {
              queue.add(new int[]{row,col});
            }
        }
      }

      while(!queue.isEmpty()) 
      {
        int[] points = queue.poll(); 
        int row = points[0]; 
        int col = points[1]; 

          for(int[] dir: directions)
          { //(0,1)
            int currentRow  = row+dir[0];
            int currentCol =  col+dir[1]; 

            if(currentRow < 0 || 
               currentCol < 0 || 
               currentRow >= m ||
               currentCol >= n ||
               rooms[currentRow][currentCol]!= empty
                )
            {
              continue;
            }

            rooms[currentRow][currentCol] = rooms[row][col]+1;
            queue.add(new int[] {currentRow,currentCol});

          }

      }

  }



}

public class WallsAndGate
{
  public static void main(String args[])
  {
    Sample s = new Sample();
    int[][] rooms = {
{2147483647,-1,0,2147483647},
{2147483647,2147483647,2147483647,-1},
{2147483647,-1,2147483647,-1},
{0,-1,2147483647,2147483647}
  };

  s.nearestGate(rooms);

  System.out.println(" Result \n");

      int m = rooms.length;
      int n = rooms[0].length;

      for(int row = 0 ; row < m ; row++)
      {
        for(int col = 0 ; col < n ; col++)
        {
            System.out.print(rooms[row][col]+"  ");
        }
        System.out.println();
      }



  }
}







