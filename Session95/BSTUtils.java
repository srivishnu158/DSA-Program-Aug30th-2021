import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BSTUtils
{

	TreeNode root;


	/*
		Time Complexity  : O(nlogn)
		Space Complexity : O(n)
	*/
	public TreeNode constructBST(Integer[] elements) // where in elements index[0] != null
	{

		root = new TreeNode(elements[0]);

		for(int i = 1 ; i < elements.length ; i++)
		{
			insert(root,elements[i]);
		}

		return root;
	}


	/*
		Time Complexity  : O(logn)
		Space Complexity : O(1)
	*/
	public TreeNode insert(TreeNode root, int val)
	{

		if(root == null)
		{
			root = new TreeNode(val);
			return root;
		}

		TreeNode current = root;

		while(current != null)
		{
			if(current.val > val)
			{
				if(current.left == null)
				{
					current.left = new TreeNode(val);
					break;
				}

				current = current.left;
			}else // current.val < val
			{

				if(current.right == null)
				{
					current.right = new TreeNode(val);
					break;
				}

				current = current.right;
			}
		}

		return root;
	}

/*
		Time Complexity  : O(logn)
		Space Complexity : O(1)
	*/
	public boolean search(TreeNode root, int val)
	{

		
		TreeNode current = root;

		while(current != null)
		{
			if(current.val == val)
			{
				return true;
			}else if(current.val > val)
			{
				current = current.left;
			}else // current.val < val
			{
				current = current.right;
			}
		}

		return false;
	}


/*
		Time Complexity  : O(logn)
		Space Complexity : O(1)
	*/
public TreeNode precedessor(TreeNode root, TreeNode currentNode)
	{

		TreeNode precedessor = null;
		
		
		while(root != null)
		{
			if(root.val < currentNode.val)
			{
				precedessor  = root;
				root = root.right;
				
				
			}else // root.val > currentNode.val
			{
				root = root.left;
			}
		}

		return precedessor;
	}


/*
		Time Complexity  : O(logn)
		Space Complexity : O(1)
	*/
public TreeNode successor(TreeNode root, TreeNode currentNode)
	{

		TreeNode successor = null;
		
		
		while(root != null)
		{
			if(root.val > currentNode.val)
			{
				successor  = root;
				root = root.left;

			}else // root.val < currentNode.val
			{
				root = root.right;
				
			}
		}

		return successor;
	}
	

/*
		Time Complexity  : O(logn)
		Space Complexity : O(1)
	*/
public TreeNode getNode(TreeNode root, int val)
	{
		
		TreeNode current = root;

		while(current != null)
		{
			if(current.val == val)
			{
				break;
			}else if(current.val > val)
			{
				current = current.left;
			}else // current.val < val
			{
				current = current.right;
			}
		}

		return current;
	}


	/*
		Time Complexity  : O(n)
		Space Complexity : O(n)
	*/
public List<Integer> inOrder(TreeNode root)
{
	List<Integer> list = new ArrayList<>();

	Stack<TreeNode> stack = new Stack<>();

	TreeNode current = root;
	while(current != null || !stack.isEmpty())
	{
			while(current != null)
			{
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			list.add(current.val);
			current = current.right;

	}

	return list;

}

/*
		Time Complexity  : O(n)
		Space Complexity : O(n)
	*/
public List<List<Integer>> levelOrder(TreeNode root)
{
	List<List<Integer>> list = new ArrayList<>();

	Queue<TreeNode> queue = new LinkedList<>();
	if(root == null)
	{
		return list;
	}

	queue.add(root);

	while(!queue.isEmpty())
	{
		List<Integer> level = new ArrayList<>();
		int size = queue.size();
		while(size > 0)
		{
			TreeNode current = queue.poll();
			if(current.left != null)
			{
				queue.add(current.left);
			}

			if(current.right != null)
			{
				queue.add(current.right);
			}
			level.add(current.val);
			size--;
		}

		list.add(level);
	}
	return list;

}

public  TreeNode getRoot()
	{
		return root;
	}
}