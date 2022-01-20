import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class SymmetricTree
{

     /*
        Time Complexity : O(n)
        Space Complexity : O(n)
    */

     public boolean isSymmetricRecursive(TreeNode root) {
        if(root == null)
        {
            return true;
        }    
        
        return isMirror(root.left , root.right);
        
    }
    
    public boolean isMirror(TreeNode t1 , TreeNode t2)
    {
        
            if(t1 == null && t2 == null)
            {
                return true;
            }
        
            if( (t1 != null && t2 == null) || (t2 != null && t1 == null))
            {
                return false;
            }
        
        
            
        return t1.value == t2.value && isMirror(t1.left , t2.right) && isMirror(t1.right, t2.left);
        
    }


    /*
        Time Complexity : O(n)
        Space Complexity : O(n)
    */

     public boolean isSymmetricBFS(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        
        while( !queue.isEmpty() )
        {
           
               TreeNode t1 = queue.poll();
               TreeNode t2 = queue.poll();  
                
                
                if(t1 == null && t2 == null)
                {
                    continue;
                }
                
                if( (t1 == null && t2 != null) || (t2== null && t1 != null) 
                   || t1.value != t2.value )
                {
                    return false;
                }
                
                queue.add(t1.left);
                queue.add(t2.right);
                
                queue.add(t1.right);
                queue.add(t2.left);
         
        }
        
        return true;
        
    }

    /*
        Time Complexity : O(n)
        Space Complexity : O(n)
    */

     public boolean isSymmetricDFS(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);
        
        while( !stack.isEmpty() )
        {
           
               TreeNode t1 = stack.pop();
               TreeNode t2 = stack.pop();  
                
                
                if(t1 == null && t2 == null)
                {
                    continue;
                }
                
                if( (t1 == null && t2 != null) || (t2== null && t1 != null) 
                   || t1.value != t2.value )
                {
                    return false;
                }
                
                //[1], [2, 2], [3, 3]
                stack.push(t1.left);
                stack.push(t2.right);
                
                stack.push(t1.right);
                stack.push(t2.left);
         
        }
        
        return true;
        
    }
}

public class SymmetricTreeEx
{
	public static void main(String[] args) {
        Integer[] elements1 = {1,2,2,3,4,4,3};
		Integer[] elements2 = {1,2,2,null,3,null,3};

		TreeUtils treeUtil = new TreeUtils();
		TreeNode root1 = treeUtil.constructTree(elements1);
        TreeNode root2 = treeUtil.constructTree(elements2);

        SymmetricTree s = new SymmetricTree();
		LevelOrder l = new LevelOrder();

	    System.out.println(" \n Tree_1 "+l.levelOrder(root1));


	   	System.out.println(" isMirror Recursive :: "+s.isSymmetricRecursive(root1));
	   	System.out.println(" isMirror BFS :: "+s.isSymmetricBFS(root1));
        System.out.println(" isMirror DFS :: "+s.isSymmetricDFS(root1));


         System.out.println(" \n Tree_2 "+l.levelOrder(root2));

        System.out.println(" isMirror Recursive :: "+s.isSymmetricRecursive(root2));
        System.out.println(" isMirror BFS :: "+s.isSymmetricBFS(root2));
        System.out.println(" isMirror DFS :: "+s.isSymmetricDFS(root2));

	}
}






