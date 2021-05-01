package tools;

import basic.TreeNode;
import org.junit.jupiter.api.Test;

import static testutil.Assert.assertTreeEquals;

public class TreeBuilderTest {
    @Test
    public void createTreeEmptyInputTest() {
        Integer[] input = new Integer[]{};

        TreeNode actualRoot = TreeBuilder.createTree(input);
        assertTreeEquals(null, actualRoot);
    }

    @Test
    public void createTreeSingleElementTest() {
        Integer[] input = new Integer[]{5};
        TreeNode expectedRoot = new TreeNode(5);
        TreeNode actualRoot = TreeBuilder.createTree(input);
        assertTreeEquals(expectedRoot, actualRoot);
    }

    @Test
    public void createTreeTest() {
        Integer[] input = new Integer[]{3, 9, 20, null, null, 15, 7,  12, 25, null, null, null, null, 18, 24};
        TreeNode expectedRoot = new TreeNode(3);
        expectedRoot.left = new TreeNode(9);
        expectedRoot.right = new TreeNode(20);

        TreeNode nextRoot = expectedRoot.right;
        nextRoot.left = new TreeNode(15);
        nextRoot.right = new TreeNode(7);

        nextRoot = nextRoot.left;
        nextRoot.left = new TreeNode(12);
        nextRoot.right = new TreeNode(25);

        nextRoot = nextRoot.right;
        nextRoot.left = new TreeNode(18);
        nextRoot.right = new TreeNode(24);

        TreeNode actualRoot = TreeBuilder.createTree(input);
        assertTreeEquals(expectedRoot, actualRoot);
    }

    @Test
    public void createTreeOutOfBoundTest() {
        Integer[] input = new Integer[]{3, 9, 20, null, null, 15, 7,  12, 25, null, null, null, null, 18};
        TreeNode expectedRoot = new TreeNode(3);
        expectedRoot.left = new TreeNode(9);
        expectedRoot.right = new TreeNode(20);

        TreeNode nextRoot = expectedRoot.right;
        nextRoot.left = new TreeNode(15);
        nextRoot.right = new TreeNode(7);

        nextRoot = nextRoot.left;
        nextRoot.left = new TreeNode(12);
        nextRoot.right = new TreeNode(25);

        nextRoot = nextRoot.right;
        nextRoot.left = new TreeNode(18);

        TreeNode actualRoot = TreeBuilder.createTree(input);
        assertTreeEquals(expectedRoot, actualRoot);
    }
}
