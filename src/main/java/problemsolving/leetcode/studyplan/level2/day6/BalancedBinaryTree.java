package problemsolving.leetcode.studyplan.level2.day6;

import problemsolving.leetcode.studyplan.level2.datastructure.TreeNode;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null || (root.right == null && root.left == null)) return true;
		if (!isBalanced(root.left) || !isBalanced(root.right)) return false;

		var leftHeight = getHeight(root.left);
		var rightHeight = getHeight(root.right);

		return Math.abs(leftHeight - rightHeight) < 2;
	}

	private int getHeight(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;

		var leftHeight = getHeight(root.left);
		var rightHeight = getHeight(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

}
