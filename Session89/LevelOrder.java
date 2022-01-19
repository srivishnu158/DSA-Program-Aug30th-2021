import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class LevelOrder
{

	/*
		Time Complexity  : O(n)
		Space Complexity : O(n)
	*/
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> levels = new ArrayList<>();
		if(root == null)
		{
			return levels;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty())
		{
			int levelElementsSize = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
				while(levelElementsSize > 0)
				{
						TreeNode currentNode = queue.poll();
						currentLevel.add(currentNode.value);
						if(currentNode.left != null)
						{
							queue.add(currentNode.left);
						}

						if(currentNode.right != null)
						{
							queue.add(currentNode.right);
						}

						levelElementsSize--;
				}

				levels.add(currentLevel);
		}

		return levels;
	}

}






