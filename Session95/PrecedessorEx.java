import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class PrecedessorEx
{

	public static void main(String[] args) {
		BSTUtils utils = new BSTUtils();
		Integer[] elements = {4,2,7,1,3};
		TreeNode root = utils.constructBST(elements);

		System.out.println(" \n Tree :: ");
		System.out.println(" InOrder => "+utils.inOrder(root));
		System.out.println(" LevelOrder => "+utils.levelOrder(root));

		TreeNode node7 = utils.getNode(root,7);
		System.out.println(" precedessor(7) =>"+utils.precedessor(root,node7).val);

				TreeNode node1 = utils.getNode(root,1);
				TreeNode preOf1 = utils.precedessor(root,node1);
		System.out.println(" precedessor(1) =>"+preOf1);

	}
}