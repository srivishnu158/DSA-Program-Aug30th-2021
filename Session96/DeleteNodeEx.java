class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode parent = null;
        TreeNode current = root;
        
        while( current != null && current.val != key)
        {
            parent = current;
            if(current.val < key)
            {
              current = current.right;  
            }else
            {
                current = current.left;
            }
            
        }
        
        // Case1 : Element is Not Found
        if(current == null)
        {
            return root;
        }
        
        // Case2/3/4 : LeafNode/ hasOnlyLeftChild / hasOnlyRight Child
       else  if(current.left == null || current.right == null)
       {
           TreeNode child = current.left == null ? current.right : current.left;
           if(parent == null) // For root we don't have parent
           {
               root = child;
           }else if(parent.left == current)
           {
               parent.left = child;
           }else
           {
               parent.right = child;
           }
       }else {
           
             //case 5:  Hash Both the childs
        
        parent = current;
        TreeNode successor = current.right;
        while(successor != null && successor.left != null)
        {
            parent = successor;
            successor = successor.left;
        }
       // System.out.println(current.val+ " : p "+parent.val+" : s"+successor.val);
        current.val = successor.val;
          
           if(parent.left == successor )
           {
             parent.left = successor.right;
           }else
           {
               parent.right = successor.right;
           }
        
       }
        
      
        return root;
        
        
    }
}

public class DeleteNodeEx
{

    public static void main(String[] args) {
        BSTUtils utils = new BSTUtils();
        Integer[] elements = {5,3,6,2,4,7};
        TreeNode root = utils.constructBST(elements);

        System.out.println(" \n Before Delete Tree :: ");
        System.out.println(" InOrder => "+utils.inOrder(root));
        System.out.println(" LevelOrder => "+utils.levelOrder(root));

        Solution s = new Solution();
        System.out.println(" delete(3) =>"+s.deleteNode(root,3));

         System.out.println(" \n After Delete Tree :: ");
        System.out.println(" InOrder => "+utils.inOrder(root));
        System.out.println(" LevelOrder => "+utils.levelOrder(root));


    }
}