package leetcode;

import basic.TreeNode;

import java.util.*;

public class VerticalOrderTraversalDFS implements IVerticalOrderTraversal {

    @Override
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> columns = new ArrayList<>();
        if (root == null) {
            return columns;
        }

        Map<Integer, Map<Integer, List<Integer>>> columnMap = new HashMap<>();

        State state = new State();

        preOrder(state, root, columnMap, 0, 0);

        for (int col = state.minCol; col <= state.maxCol; col++) {
            Map<Integer, List<Integer>> levelMap = columnMap.get(col);
            columns.add(getColumn(state, levelMap));
        }
        return columns;
    }

    private static List<Integer> getColumn (State state, Map<Integer, List<Integer>> levelMap) {
        List<Integer> column = new ArrayList<>();
        for (int level = state.minLevel; level <= state.maxLevel; level++) {
            List<Integer> levelItem = levelMap.get(level);
            if (levelItem == null) {
                continue;
            }
            Collections.sort(levelItem);
            column.addAll(levelItem);
        }
        return column;
    }

    private static void preOrder(State state, TreeNode node, Map<Integer, Map<Integer, List<Integer>>> map, int col, int level) {
        if (node == null) {
            return;
        }
        Map<Integer, List<Integer>> levelMap = map.getOrDefault(col, new HashMap<>());
        List<Integer> levelItem = levelMap.getOrDefault(level, new ArrayList<>());
        levelItem.add(node.val);
        levelMap.put(level, levelItem);
        map.put(col, levelMap);

        state.update(col, level);

        preOrder(state, node.left, map, col - 1, level + 1);
        preOrder(state, node.right, map, col + 1, level + 1);
    }

    private static class State {
        int minCol;
        int maxCol;
        int minLevel;
        int maxLevel;

        State () {
            minCol = Integer.MAX_VALUE;
            maxCol = Integer.MIN_VALUE;
            minLevel = Integer.MAX_VALUE;
            maxLevel = Integer.MIN_VALUE;
        }

        void update(int newCol, int newLevel) {
            minCol = Math.min(minCol, newCol);
            maxCol = Math.max(maxCol, newCol);
            minLevel = Math.min(minLevel, newLevel);
            maxLevel = Math.max(maxLevel, newLevel);
        }
    }
}
