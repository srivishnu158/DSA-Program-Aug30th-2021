import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        Time Complexity : O(n)
        Space Complexity : O(n)
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
        {
            return null;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        parentMap.put(root, null);
        
        // Map each node to it’s parent util we found node(p) & node(q)
        while(!parentMap.containsKey(p)  || !parentMap.containsKey(q))
        {
            TreeNode parent = stack.pop();
            if(parent.left != null)
            {
                 stack.push(parent.left);
                parentMap.put(parent.left, parent);
            }
            
            if(parent.right != null)
            {
                stack.push(parent.right);
                parentMap.put(parent.right, parent);
            }
        }
        
        // Add all the ancestors of node(p) to the set 
        Set<TreeNode> ancestors = new HashSet<>();
        while( p != null)
        {
            ancestors.add(p);
            p = parentMap.get(p);
        }
        
        // The first parent of q identified in set is LCA 
        while(q != null)
        {
            if(ancestors.contains(q))
            {
                break;
            }
            q = parentMap.get(q);
        }
        
        return q;
    }

    public TreeNode getNode(TreeNode root, int value)
    {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop();
            if(current.value == value)
            {
                return current;
            }

            if(current.right != null)
            {
                stack.push(current.right);
            }

            if(current.left != null)
            {
                stack.push(current.left);
            }
        }

        return null;
    }
}

public class LowestCommonAncestorEx
{
    public static void main(String[] args) {
        Integer[] elements = {3,5,1,6,2,0,8,null,null,7,4};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n Tree "+l.levelOrder(root));

        Solution s = new Solution();
        
        TreeNode p = s.getNode(root,6);
        TreeNode q = s.getNode(root,4);

        System.out.println(" LCA[6,4] "+s.lowestCommonAncestor(root,p,q).value);

         p = s.getNode(root,5);
         q = s.getNode(root,4);

        System.out.println(" LCA[5,4] "+s.lowestCommonAncestor(root,p,q).value);

         p = s.getNode(root,5);
         q = s.getNode(root,1);

        System.out.println(" LCA[5,1] "+s.lowestCommonAncestor(root,p,q).value);

    }
}






