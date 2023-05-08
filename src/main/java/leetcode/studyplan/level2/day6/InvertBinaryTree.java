package leetcode.studyplan.level2.day6;

import leetcode.studyplan.level2.datastructure.TreeNode;

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return root;

		var leftNode = root.left;
		var rightNode = root.right;

		root.right = invertTree(leftNode);
		root.left = invertTree(rightNode);

		return root;
	}

}
