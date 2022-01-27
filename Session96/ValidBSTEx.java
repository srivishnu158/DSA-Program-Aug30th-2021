import java.util.Stack;

class Solution {
    public boolean isValidBST(TreeNode root) {
       
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Integer prev = null;
        TreeNode current = root;
        while(current != null || !stack.isEmpty())
        {
            while(current != null)
            {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            if(prev != null && current.val <= prev)
            {
                return false;
            }
            prev = current.val;
            current = current.right;
        }
        return true;
    }
}

public class ValidBSTEx
{

    public static void main(String[] args) {
        BSTUtils utils = new BSTUtils();
        Integer[] elements = {5,1,4,3,6};
        TreeNode root = utils.constructBST(elements);

        System.out.println(" \n Tree :: ");
        System.out.println(" InOrder => "+utils.inOrder(root));
        System.out.println(" LevelOrder => "+utils.levelOrder(root));

        Solution s = new Solution();
        System.out.println(" IsValid :: " +s.isValidBST(root));


    }
}