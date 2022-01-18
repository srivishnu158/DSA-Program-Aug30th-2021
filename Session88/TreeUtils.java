import java.util.Queue;
import java.util.LinkedList;

public class TreeUtils
{

	TreeNode root;

	/*
		Time Complexity  : O(n)
		Space Complexity : O(n)
	*/
	public TreeNode constructTree(Integer[] elements) // where in elements index[0] != null
	{
			root = new TreeNode(elements[0]);

			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int index = 0;
			while(index < elements.length)
			{
				int levelElementsSize = queue.size();
					while(levelElementsSize > 0)
					{
						TreeNode current = queue.poll();

						Integer leftElement  = null;
						int leftIndex = ++index;

						if(leftIndex < elements.length)
						{
								leftElement = elements[leftIndex];
						}
						Integer rightElement = null;

						int rightIndex = ++index;

						if(rightIndex < elements.length)
						{
								rightElement = elements[rightIndex];
						}


						if(leftElement != null)
						{
							TreeNode left = new TreeNode(leftElement);
							current.left = left;
							queue.add(left);
						}

						if(rightElement != null)
						{
							TreeNode right = new TreeNode(rightElement);
							current.right = right;
							queue.add(right);
						}
						levelElementsSize--;
					}
			}

			return root;
	}

	public  TreeNode getRoot()
	{
		return root;
	}
}