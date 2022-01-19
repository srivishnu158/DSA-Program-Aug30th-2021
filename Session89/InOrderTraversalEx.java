import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class InOrderTraversal
{
	public List<Integer> inOrderRecursive(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();

		inOrderRecursive(root,list);
		return list;
	}

	public void inOrderRecursive(TreeNode root, List<Integer> list)
	{
			if(root == null)
			{
				return;
			}
		inOrderRecursive(root.left,list);
		list.add(root.value);
		inOrderRecursive(root.right,list);


	}

	public List<Integer> inOrderIterative(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		if(root == null)
		{
			return list;
		}
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
			while(current != null || !stack.isEmpty())
			{
					while(current != null)
					{
						stack.push(current);
						current = current.left;
					}
					current = stack.pop();
					list.add(current.value);
					current = current.right;
			}

			return list;
	}
}


public class InOrderTraversalEx
{
	public static void main(String[] args) {
			TreeUtils treeUtil = new TreeUtils();
		Integer[] elements1 = {1,2,3,4,5,6,7};
		Integer[] elements2 = {1,null,2,3};

		TreeNode root1 = treeUtil.constructTree(elements1);
		TreeNode root2 = treeUtil.constructTree(elements2);

		LevelOrder l = new LevelOrder();
		InOrderTraversal traversal = new InOrderTraversal();

		System.out.println(" \n Tree_1 "+l.levelOrder(root1));
		System.out.println("Recursive :: "+traversal.inOrderRecursive(root1));
	    System.out.println("Iterative :: "+traversal.inOrderIterative(root1));


	    System.out.println(" \n Tree_2 "+l.levelOrder(root2));
		System.out.println("Recursive :: "+traversal.inOrderRecursive(root2));
	    System.out.println("Iterative :: "+traversal.inOrderIterative(root2));


	}
}







