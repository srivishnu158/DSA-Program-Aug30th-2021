import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class SearchEx
{

	public static void main(String[] args) {
		BSTUtils utils = new BSTUtils();
		Integer[] elements = {4,2,7,1,3};
		TreeNode root = utils.constructBST(elements);

		System.out.println(" \n Tree :: ");
		System.out.println(" InOrder => "+utils.inOrder(root));
		System.out.println(" LevelOrder => "+utils.levelOrder(root));

		
		System.out.println(" search(2) =>"+utils.search(root,2));
		System.out.println(" search(5) =>"+utils.search(root,5));

	}
}