import java.util.Queue;
import java.util.Stack;
import java.util.Stack;
class PathSumNode
{
    int sum ;
    String path;

    public PathSumNode(int sum , String path)
    {
                this.sum = sum;
                this.path = path;
    }
}
class Solution {
    public String hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
        {
            return null;
        }
        
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<PathSumNode> sumStack = new Stack<>();
        
        treeNodeStack.push(root);
        sumStack.push(new PathSumNode(targetSum - root.val,root.val+""));
        
        while( !treeNodeStack.isEmpty() )
        {
            TreeNode current = treeNodeStack.pop();
            PathSumNode sumNode = sumStack.pop();
            int leftSum = sumNode.sum;
            String path = sumNode.path;
            
            if(leftSum == 0 && current.left == null && current.right == null)
            {
                return path;
            }
            
          
              if(current.right != null)
            {
                treeNodeStack.push(current.right);
                sumStack.push(new PathSumNode(leftSum - current.right.val,path+"->"+current.right.val));
            }
            
             if(current.left != null)
            {
                treeNodeStack.push(current.left);
                sumStack.push(new PathSumNode(leftSum - current.left.val,path+"->"+current.left.val));
            }  
            
            }
            
     
        return null;
    }
}

public class HasPathSumEx2
{
    public static void main(String[] args) {
        Integer[] elements = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n LevelOrder Tree "+l.levelOrder(root));
        
        Solution s = new Solution();
        System.out.println(" \n Path = "+s.hasPathSum(root, 22));


    }
}