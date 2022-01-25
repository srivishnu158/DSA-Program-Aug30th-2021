import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;


class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        height(root,result);
        
        return result;
    }
    
    public int height(TreeNode currentNode ,  List<List<Integer>> result)
    {
        
        if(currentNode == null)
        {
            return -1;
        }
       
        int leftHieght =  1 + height(currentNode.left,result);
        int rightHieght = 1 + height(currentNode.right, result);
        
        int currentNodeHeight = Math.max(leftHieght, rightHieght);
        
        if(result.size() == currentNodeHeight)
        {
          result.add(new ArrayList<>());  
        }
        
        result.get(currentNodeHeight).add(currentNode.val);
        
        return currentNodeHeight;
    }
}

public class FindLeavesEx
{
    public static void main(String[] args) {
        Integer[] elements = {1,2,3,4,5};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n LevelOrder Tree "+l.levelOrder(root));
        
        Solution s = new Solution();
        System.out.println(" \n Path = "+s.findLeaves(root));


    }
}