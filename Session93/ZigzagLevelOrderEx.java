import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>>  result = new LinkedList<>();
        
        if(root == null)
        {
            return result;
        }
        boolean isLeftToRight = true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while( !queue.isEmpty() )
        {
            int levelSize = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            
            while(levelSize > 0 )
            {
                TreeNode current = queue.poll();
                
                if(isLeftToRight)
                {
                    level.addLast(current.val);
                }else
                {
                    level.addFirst(current.val);
                }
                
                if(current.left != null)
                {
                    queue.add(current.left);
                }
                
                if(current.right != null)
                {
                    queue.add(current.right);
                }
                levelSize --;
            }
            
            isLeftToRight = !isLeftToRight;
            result.add(level);
        }
        
        return result;
        
    }
}

public class ZigzagLevelOrderEx
{
    public static void main(String[] args) {
        Integer[] elements = {3,9,20,null,null,15,7};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n LevelOrder Tree "+l.levelOrder(root));
        
        Solution s = new Solution();
        System.out.println(" \n ZigZagLevelOrder Tree "+s.zigzagLevelOrder(root));


    }
}