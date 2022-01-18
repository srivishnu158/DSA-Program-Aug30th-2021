import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


class LevelOrder
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


public class LevelOrderEx
{
	public static void main(String[] args) {

		TreeUtils treeUtil = new TreeUtils();
		Integer[] elements1 = {1,2,3,4,5,6,7,8};
		Integer[] elements2 = {1,null,2,null,4,null,7};

		TreeNode root1 = treeUtil.constructTree(elements1);
		TreeNode root2 = treeUtil.constructTree(elements2);

		LevelOrder l = new LevelOrder();

		System.out.println(" Tree_1 "+l.levelOrder(root1));
		System.out.println(" Tree_2 "+l.levelOrder(root2));

	}
}









