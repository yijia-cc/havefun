package testutil;

import basic.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Assert {
    public static void assertTreeEquals (TreeNode expectedRoot, TreeNode actualRoot) {
        if (expectedRoot == null && actualRoot == null) {
            return;
        }

        if (expectedRoot == null || actualRoot == null) {
            fail();
        }

        assertEquals(expectedRoot.key, actualRoot.key);
        assertTreeEquals(expectedRoot.left, actualRoot.left);
        assertTreeEquals(expectedRoot.right, actualRoot.right);
    }
}
