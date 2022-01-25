import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        
        Map<String, List<TreeNode>> treesMap = new HashMap<>();
        
        construct(root, treesMap);
        
        for(String key : treesMap.keySet())
        {
            
            List<TreeNode> trees = treesMap.get(key);
            
            if(trees.size() > 1)
            {
               result.add(trees.get(0)); 
            }
            
        }
           
        return result;
    }
    
    private String construct(TreeNode root, Map<String, List<TreeNode>> treesMap)
    {
        if( root == null)
        {
            return "";
        }
        
        String key = "L"+construct(root.left, treesMap) + root.val + "R"+construct(root.right, treesMap);
        
        treesMap.putIfAbsent(key, new ArrayList<>());
        treesMap.get(key).add(root);
        
        return key;
    }

    public void preOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        System.out.print(root.val + " , ");
        preOrder(root.left);
        preOrder(root.right);

    }

}



public class FindDuplicateSubtreesEx
{
    public static void main(String[] args) {
        Integer[] elements = {2,2,2,3,null,3,null};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n LevelOrder Tree "+l.levelOrder(root));
        
        Solution s = new Solution();

       List<TreeNode> duplicateSubTrees =  s.findDuplicateSubtrees(root);
       for(TreeNode treeNode : duplicateSubTrees)
       {
            System.out.print(" [ ");
            s.preOrder(treeNode);
            System.out.print("]");

       }

       System.out.println();
    }
}