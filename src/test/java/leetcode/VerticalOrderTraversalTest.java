package leetcode;

import basic.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import tools.TreeBuilder;

import java.util.Arrays;
import java.util.List;

public class VerticalOrderTraversalTest {
    @Test
    public void verticalTraversalTest() {
        class TestCase {
            final String name;
            final Integer[] inputTree;
            final List<List<Integer>> expectedColumns;

            TestCase(String name, Integer[] inputTree, List<List<Integer>> expectedColumns) {
                this.name = name;
                this.inputTree = inputTree;
                this.expectedColumns = expectedColumns;
            }
        }

        TestCase[] testCases = new TestCase[]{
                new TestCase(
                        "Incomplete left tree",
                        new Integer[]{3, 9, 20, null, null, 15, 7},
                        Arrays.asList(
                                Arrays.asList(9),
                                Arrays.asList(3, 15),
                                Arrays.asList(20),
                                Arrays.asList(7))),
                new TestCase(
                        "Multiple tree nodes in same column & level",
                        new Integer[]{1, 2, 3, 4, 5, 6, 7},
                        Arrays.asList(
                                Arrays.asList(4),
                                Arrays.asList(2),
                                Arrays.asList(1, 5, 6),
                                Arrays.asList(3),
                                Arrays.asList(7))),
                new TestCase(
                        "Multiple tree nodes in same column & level, order by value",
                        new Integer[]{8, 2, 3, 4, 6, 5, 7},
                        Arrays.asList(
                                Arrays.asList(4),
                                Arrays.asList(2),
                                Arrays.asList(8, 5, 6),
                                Arrays.asList(3),
                                Arrays.asList(7))),
        };

        IVerticalOrderTraversal[] algorithms = new IVerticalOrderTraversal[]{
                new VerticalOrderTraversalDFS(),
        };

        for (TestCase testCase : testCases) {
            for (IVerticalOrderTraversal algorithm : algorithms) {
                TreeNode inputTree = TreeBuilder.createTree(testCase.inputTree);
                List<List<Integer>> columns = algorithm.verticalTraversal(inputTree);
                String message = String.format("%s, %s", testCase.name, algorithm.getClass().getName());
                Assertions.assertEquals(testCase.expectedColumns, columns, message);
            }
        }
    }
}
