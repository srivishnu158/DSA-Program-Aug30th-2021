import java.util.Queue;
import java.util.Stack;
import java.util.Stack;
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
        {
            return false;
        }
        
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        
        treeNodeStack.push(root);
        sumStack.push(targetSum - root.val);
        
        while( !treeNodeStack.isEmpty() )
        {
            TreeNode current = treeNodeStack.pop();
            int leftSum = sumStack.pop();
            
            if(leftSum == 0 && current.left == null && current.right == null)
            {
                return true;
            }
            
          
              if(current.right != null)
            {
                treeNodeStack.push(current.right);
                sumStack.push(leftSum - current.right.val);
            }
            
             if(current.left != null)
            {
                treeNodeStack.push(current.left);
                sumStack.push(leftSum - current.left.val);
            }  
            
            }
            
     
        return false;
    }
}

public class HasPathSumEx
{
    public static void main(String[] args) {
        Integer[] elements = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n LevelOrder Tree "+l.levelOrder(root));
        
        Solution s = new Solution();
        System.out.println(" \n HasPath Sum -> "+s.hasPathSum(root, 22));


    }
}