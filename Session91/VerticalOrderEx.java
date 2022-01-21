import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

class Solution {
        /*
            Time Complexity : O(n) BFS + O(nlogn) TreeMap(sort) = O(nlogn)
            Space Compleity : O(n)
        */
    public List<List<Integer>> verticalOrder1(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)
        {
            return output;
        }
        
        TreeMap<Integer, List<Integer>> columnMap = new TreeMap<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.add(new PairNode(root,0));
        
        while(! queue.isEmpty() )
        {
            PairNode pair = queue.poll();
            TreeNode current = pair.node;
            Integer column = pair.column;
            columnMap.putIfAbsent(column, new ArrayList<>());
            columnMap.get(column).add(current.value);
            
            if(current.left != null)
            {
              queue.add(  new PairNode(current.left, column-1));
                
            }
            
            if(current.right != null)
            {
              queue.add( new PairNode(current.right, column+1));
                
            }
        }
        
        for(int key : columnMap.keySet())
        {
            output.add(columnMap.get(key));
        }
        
        return output;
    }


            /*
            Time Complexity : O(n) BFS + O(n) Map = O(n)
            Space Compleity : O(n)
        */
public List<List<Integer>> verticalOrder2(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null)
        {
            return output;
        }
        
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<PairNode> queue = new LinkedList<>();
        queue.add(new PairNode(root,0));
        int minColumnIndex = 0;
        int maxColumnIndex = 0;
        
        while(! queue.isEmpty() )
        {
            PairNode pair = queue.poll();
            TreeNode current = pair.node;
            Integer column = pair.column;
            columnMap.putIfAbsent(column, new ArrayList<>());
            columnMap.get(column).add(current.value);
            
            minColumnIndex = Math.min(minColumnIndex, column);
            maxColumnIndex = Math.max(maxColumnIndex, column);
            
            if(current.left != null)
            {
              queue.add(  new PairNode(current.left, column-1));
                
            }
            
            if(current.right != null)
            {
              queue.add( new PairNode(current.right, column+1));
                
            }
        }
        
        while(minColumnIndex <= maxColumnIndex)
        {
            output.add(columnMap.get(minColumnIndex));
            minColumnIndex++;
        }
        
        return output;
    }


}

class PairNode
{
    TreeNode node;
    int column;
    
    public PairNode(TreeNode node, int column)
    {
        this.node = node;
        this.column = column;
    }
}

public class VerticalOrderEx
{
    public static void main(String[] args) {
        Integer[] elements = {3,9,8,4,0,1,7,null,null,null,2,5};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n Tree "+l.levelOrder(root));

        Solution s = new Solution();
        

        System.out.println(" O(nlogn) => "+s.verticalOrder1(root));
        System.out.println(" O(n) => "+s.verticalOrder2(root));

    }
}






