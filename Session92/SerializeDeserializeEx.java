import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

 class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
        {
            return null;
        }
        
        String tree = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
           TreeNode current = queue.poll();
           
            if(current == null)  {
               tree = tree.concat("E,"); 
            } else
            {
                tree = tree.concat(current.value+",");
                 queue.add(current.left);
                 queue.add(current.right);
            }
           
        }
        
        tree = tree.substring(0, tree.length()-1);
        //System.out.println(tree);
        return tree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
        {
            return null;
        }
        
        String[] elements = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(elements[0]));
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        int i = 0;
        
        while( i < elements.length && !bfs.isEmpty())
        {
            int levelSize = bfs.size();
            
            while(levelSize > 0)
            {
                TreeNode current = bfs.poll();
                if(++i < elements.length && !elements[i].equals("E"))
                {
                   current.left= new TreeNode(Integer.valueOf(elements[i]));
                    bfs.add(current.left);
                }
                
                if(++i < elements.length && !elements[i].equals("E"))
                {
                   current.right= new TreeNode(Integer.valueOf(elements[i]));
                       bfs.add(current.right);

                }
                levelSize--;
            }
            
        }
        
        return root;
    }
}

public class SerializeDeserializeEx
{
    public static void main(String[] args) {
        Integer[] elements = {1,2,3,null,null,4,5};
        TreeUtils treeUtil = new TreeUtils();
        TreeNode root = treeUtil.constructTree(elements);
        LevelOrder l = new LevelOrder();
        System.out.println(" \n Before Serialization Tree "+l.levelOrder(root));
        Codec c = new Codec();
        String serializedValue = c.serialize(root);
        System.out.println(" \n Serialization-String => "+serializedValue); 

    TreeNode newRoot = c.deserialize(serializedValue);
    System.out.println(" Before Serialization/Desiralization Tree => "+l.levelOrder(newRoot));

    }
}

