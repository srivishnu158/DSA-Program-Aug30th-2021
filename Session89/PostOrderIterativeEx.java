import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class PostOrderTraversal
{
	public List<Integer> PostOrderRecursive(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();

		PostOrderRecursive(root,list);
		return list;
	}

	public void PostOrderRecursive(TreeNode root, List<Integer> list)
	{
			if(root == null)
			{
				return;
			}
		PostOrderRecursive(root.left,list);
		PostOrderRecursive(root.right,list);
	   list.add(root.value);
	}

	public List<Integer> PostOrderIterative(TreeNode root)
	{
			
		LinkedList<Integer> list = new LinkedList<>();


        
                if(root == null)
                {
                    return list;
                }
        
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

        while( !stack.isEmpty() )
                {
                    TreeNode current = stack.pop();
                   
                    list.addFirst(current.value);

                    if(current.left != null)
                    {
                    stack.push(current.left);
                    }

                    if(current.right != null)
                    {
                    stack.push(current.right);
                    }

                }
        
        return list;
	}
}


public class PostOrderIterativeEx
{
	public static void main(String[] args) {
			TreeUtils treeUtil = new TreeUtils();
		Integer[] elements1 = {1,2,3,4,5,6,7};
		Integer[] elements2 = {1,null,2,3};

		TreeNode root1 = treeUtil.constructTree(elements1);
		TreeNode root2 = treeUtil.constructTree(elements2);


		LevelOrder l = new LevelOrder();
		PostOrderTraversal traversal = new PostOrderTraversal();

		System.out.println(" \n Tree_1 "+l.levelOrder(root1));
		System.out.println("Recursive :: "+traversal.PostOrderRecursive(root1));
	    System.out.println("Iterative :: "+traversal.PostOrderRecursive(root1));


	    System.out.println(" \n Tree_2 "+l.levelOrder(root2));
		System.out.println("Recursive :: "+traversal.PostOrderIterative(root2));
	    System.out.println("Iterative :: "+traversal.PostOrderIterative(root2));


	}
}







