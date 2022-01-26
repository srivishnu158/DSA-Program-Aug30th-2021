import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class SuccessorEx
{

	public static void main(String[] args) {
		BSTUtils utils = new BSTUtils();
		Integer[] elements = {4,2,7,1,3};
		TreeNode root = utils.constructBST(elements);

		System.out.println(" \n Tree :: ");
		System.out.println(" InOrder => "+utils.inOrder(root));
		System.out.println(" LevelOrder => "+utils.levelOrder(root));

		TreeNode node2 = utils.getNode(root,2);
		System.out.println(" successor(1) =>"+utils.successor(root,node2).val);

				TreeNode node7 = utils.getNode(root,7);
				TreeNode sucOf7 = utils.successor(root,node7);
		System.out.println(" successor(7) =>"+sucOf7);

	}
}