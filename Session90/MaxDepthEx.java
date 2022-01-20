import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class MaxDepth
{

	 public int maxDepthRecursive(TreeNode root) {
        
        if(root == null)
        {
            return 0;
        }
        
        int leftDepth = 1 + maxDepthRecursive(root.left);
        int rightDepth = 1 + maxDepthRecursive(root.right);

        return Math.max(leftDepth, rightDepth);
    }

    public int maxDepthBFS(TreeNode root) {
        
        if(root == null)
        {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        
        while(!queue.isEmpty())
        {
            depth++;
            
            int levelElementSize = queue.size();
            while(levelElementSize > 0)
            {
                TreeNode current = queue.poll();
                if(current.left != null)
                {
                    queue.add(current.left);
                }
                
                if(current.right != null)
                {
                    queue.add(current.right);
                }
                levelElementSize --;
            }
            
        }
        
        return depth;
    }

   public int maxDepthDFS(TreeNode root) {
        
    if(root == null)
             {
        return 0;
             }
        
        Stack<TreeNode> treeStack = new Stack<>();
        Stack<Integer>  depthStack = new Stack<>();
        treeStack.push(root);
        depthStack.push(1);
        
        int depth = 0 ; int currentDepth = 0;
        
        while(!treeStack.isEmpty())
        {
            TreeNode current = treeStack.pop();
            currentDepth = depthStack.pop();
            
                if(current != null)
                {
                    depth = Math.max(depth, currentDepth);
                    treeStack.push(current.left);
                    treeStack.push(current.right);
                    depthStack.push(currentDepth+1);
                    depthStack.push(currentDepth+1);

                }
        }
        
        return depth;
    }
}

public class MaxDepthEx
{
	public static void main(String[] args) {
		Integer[] elements = {3,9,20,null,null,15,7};
		TreeUtils treeUtil = new TreeUtils();
		TreeNode root = treeUtil.constructTree(elements);
		LevelOrder l = new LevelOrder();
	    System.out.println(" \n Tree "+l.levelOrder(root));

	   		MaxDepth m = new MaxDepth();

	   	System.out.println(" Depth Recursive :: "+m.maxDepthRecursive(root));
	   		   	System.out.println(" Depth BFS :: "+m.maxDepthBFS(root));
	   	System.out.println(" Depth DFS :: "+m.maxDepthDFS(root));

	}
}






