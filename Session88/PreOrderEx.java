import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


class PreOrder
{

	public List<Integer> preOrderRecursive(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		 preOrder(root, list);
		 return list;
	}

	public void preOrder(TreeNode root , List<Integer> list)
	{
		if(root == null)
		{
			return;
		}

		list.add(root.value);
		preOrder(root.left, list);
		preOrder(root.right,list);
	}


	public List<Integer> preOrderIterative(TreeNode root)
	{
		List<Integer> list = new ArrayList<>();
		if(root == null)
		{
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode current = stack.pop();
			list.add(current.value);
			if(current.right != null)
			{
				stack.push(current.right);
			}

			if(current.left != null)
			{
				stack.push(current.left);
			}
		}
		return list;
	}

}


public class PreOrderEx
{
	public static void main(String[] args) {

		TreeUtils treeUtil = new TreeUtils();
		Integer[] elements1 = {1,2,3,4,5,6,7};
		Integer[] elements2 = {1,null,2,null,4,null,7};

		TreeNode root1 = treeUtil.constructTree(elements1);
		TreeNode root2 = treeUtil.constructTree(elements2);

		PreOrder p = new PreOrder();

		LevelOrder l = new LevelOrder();

		System.out.println(" \n Tree_1 "+l.levelOrder(root1));


		System.out.println(" Tree_1 Recursive"+p.preOrderRecursive(root1));
	   System.out.println("  Tree_1 Iterative"+p.preOrderIterative(root1));


		System.out.println(" \n Tree_2 "+l.levelOrder(root2));

		System.out.println(" Tree_2 Recursive"+p.preOrderRecursive(root2));
	   System.out.println(" Tree_2 Iterative"+p.preOrderIterative(root2));

	}
}









