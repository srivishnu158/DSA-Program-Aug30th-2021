import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class InsertIntoBST
{

	public static void main(String[] args) {
		BSTUtils utils = new BSTUtils();
		Integer[] elements = {4,2,7,1,3};
		TreeNode root = utils.constructBST(elements);

		System.out.println(" \n Before Insert :: ");
		System.out.println(" InOrder => "+utils.inOrder(root));
		System.out.println(" LevelOrder => "+utils.levelOrder(root));

		System.out.println(" \n After Insert :: (5) ");
		utils.insert(root,5);
		System.out.println(" InOrder => "+utils.inOrder(root));
		System.out.println(" LevelOrder => "+utils.levelOrder(root));

	}
}