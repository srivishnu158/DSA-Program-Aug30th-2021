import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> output = new ArrayList<>();
        if( root == null)
        {
            return output;
        }
        
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();
        Stack<TreeNode> dfs  = new Stack<>();
        dfs.push(root);
        
        parentsMap.put(root, null);
        
    // Mapping each node to its parent ussing PreOrder Traversal
            while(!dfs.isEmpty())
            {
                TreeNode parent = dfs.pop();
                if(parent.right != null)
                {
                    dfs.push(parent.right);
                    parentsMap.put(parent.right, parent);
                }
                
                if(parent.left != null)
                {
                    dfs.push(parent.left);
                    parentsMap.put(parent.left, parent);
                }
            }
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(target);
        
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        visited.add(null);
        
        int distance = 0; 
        
        while(distance < k && !bfs.isEmpty())
        {
            int levelSize = bfs.size();
            while(levelSize > 0)
            {
                
                        TreeNode current = bfs.poll();
                    if(current.left != null && !visited.contains(current.left))
                    {
                        visited.add(current.left);
                        bfs.add(current.left);
                    }

                    if(current.right != null && !visited.contains(current.right))
                    {
                        visited.add(current.right);
                        bfs.add(current.right);
                    }

                    TreeNode parent = parentsMap.get(current);
                    if(!visited.contains(parent))
                    {
                        visited.add(parent);
                        bfs.add(parent);
                    }
                        levelSize--;
            }
            
            distance++;
            
        }
        
        for(TreeNode node : bfs)
        {
            output.add(node.value);
        }
        
        return output;
        
    }
}

public class KDistanceNodes
{
    public static void main(String[] args) {
        Integer[] elements = {3,5,1,6,2,0,8,null,null,7,4};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n Tree "+l.levelOrder(root));

        Solution s = new Solution();
        TreeNode target = l.getNode(root,5);

    System.out.println(" Time & Space Complexity O(n) => "+s.distanceK(root,target,2));

    }
}






