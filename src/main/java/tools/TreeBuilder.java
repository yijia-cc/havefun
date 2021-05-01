package tools;

import basic.TreeNode;

public class TreeBuilder {
    public static TreeNode createTree(Integer[] levelOrder) {
        // Input: array of Integer
        // Output: root of the tree
        //
        // Example 1:
        // Input is {3, 9, 20, null, null, 15, 7}
        //           0  1  2    3      4    5  6
        // Output is
        //               3(0)              # nodes = 1
        //            /      \
        //           9(1)    20(2)         # nodes = 2
        //                 /    \
        //                15(5)  7(6)      # nodes = 4
        //
        //
        // Observation:
        // 3 (0) is root,
        // 3.left = 9 (1),
        // 3.right = 20 (2),
        // 20.left = 15 (5),
        // 20.right = 7 (6)

        // Example 2:
        // Input is {3, 9, 20, null, null, 15, 7,  12, 25, null, null, null, null, 18, 24, null, null, 19}
        //           0  1  2    3      4    5  6   7   8   9     10    11     12   13  14   15    16   18
        //                                     p
        //                                                             c
        //
        // Output is
        //               3(0)              # nodes = 1 level 0
        //            /      \
        //           9(1)    20(2)         # nodes = 2 level 1
        //                  /    \
        //               15(5)  7(6)       # nodes = 4 level 2
        //                /   \
        //            12(7)    25(8)       # nodes = 5 level 3
        //                     /    \
        //                 18(11)   24(12)
        //                          /
        //                       19(18)
        //
        // Observation:
        // 3 (0) is root,
        // 3.left = 9 (1),
        // 3.right = 20 (2),
        // 20.left = 15 (5),
        // 20.right = 7 (6)
        // 15.left = 12 (7)
        // 15.right = 25 (8)

        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        if (levelOrder.length == 1) {
            return root;
        }

        TreeNode[] treeNodes = new TreeNode[levelOrder.length];

        int parentIndex = 0;
        treeNodes[parentIndex] = root;

        // traverse two children nodes
        for (int childIndex = 1; childIndex < levelOrder.length; childIndex++) {
            while (parentIndex < childIndex && levelOrder[parentIndex] == null) {
                parentIndex++;
            }
            if (levelOrder[childIndex] != null) {
                treeNodes[childIndex] = new TreeNode(levelOrder[childIndex]);
            }

            if (childIndex % 2 == 1) {
                // index of left child is always odd
                treeNodes[parentIndex].left = treeNodes[childIndex];
            } else {
                // index of right child is always even
                treeNodes[parentIndex].right = treeNodes[childIndex];
                parentIndex++;
            }
        }
        return root;
    }
}
