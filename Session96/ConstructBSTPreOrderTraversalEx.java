import java.util.Deque;
import java.util.LinkedList;

class Solution {

            /* 
            With Dynamic Programming
            Time Complexity  : O(n)
            Space Complexity : O(1)
            */
    public TreeNode bstFromPreorder(Integer[] preorder) {
        
        if(preorder.length == 0)
        {
            return null;
        }
        
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        deque.addLast(root);


        
        for(int i = 1 ; i <  preorder.length ; i++)
        {
             TreeNode child = new TreeNode(preorder[i]);
             TreeNode current = deque.getLast();


                while( !deque.isEmpty() && deque.getLast().val < child.val)
                {
                    current = deque.removeLast();
                }
            
            if(current.val < child.val)
            {
                current.right = child;
            }else
            {
                current.left = child;
            }
                deque.addLast(child);
        }
        
        return root;
    }
}

public class ConstructBSTPreOrderTraversalEx
{

    public static void main(String[] args) {
        BSTUtils utils = new BSTUtils();
        Integer[] elements = {8,5,1,7,10,12};

        /*
            This takes O(nlogn)
        TreeNode root = utils.constructBST(elements);

        System.out.println(" \n Before Delete Tree :: ");
        System.out.println(" InOrder => "+utils.inOrder(root));
        System.out.println(" LevelOrder => "+utils.levelOrder(root));

        */

        Solution s = new Solution();
      
        // With Dynamic Programming
        TreeNode root = s.bstFromPreorder(elements);

         System.out.println(" \n  Tree :: ");
        System.out.println(" InOrder => "+utils.inOrder(root));
        System.out.println(" LevelOrder => "+utils.levelOrder(root));


    }
}