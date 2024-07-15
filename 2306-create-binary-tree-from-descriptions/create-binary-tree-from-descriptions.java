class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;
            TreeNode parent = nodeMap.computeIfAbsent(parentVal, k -> new TreeNode(parentVal));
            TreeNode child = nodeMap.computeIfAbsent(childVal, k -> new TreeNode(childVal));
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            children.add(childVal);
        }
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            if (!children.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }
        return null;
    }
}