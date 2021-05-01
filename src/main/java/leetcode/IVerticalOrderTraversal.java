package leetcode;

import basic.TreeNode;

import java.util.List;

/**
 * @author yijia
 * @version 04/29/2021
 *
 * @problem https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree
 */
public interface IVerticalOrderTraversal {
    /**
     * Calculate the vertical order traversal of a binary tree.
     * The traversal is a list of top-to-bottom orderings for each column
     * index starting from the leftmost column to the rightmost column.
     * <p>
     * There maybe multiple nodes in the same row and column. In this case, sort
     * the nodes by their values.
     *
     * @param root The binary tree to traverse
     * @return The columns produced from vertical order traversal
     */
    List<List<Integer>> verticalTraversal(TreeNode root);
}
