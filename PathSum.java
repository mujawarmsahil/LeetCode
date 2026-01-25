/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        listOfPaths(root, targetSum, 0, result, new ArrayList<>());
        return result;
    }

    public void listOfPaths(TreeNode root, int targetSum, int sum,
                            List<List<Integer>> lists, List<Integer> list) {

        if (root == null)
            return;

        sum += root.val;
        list.add(root.val);

        if (root.left == null && root.right == null && sum == targetSum) {
            lists.add(new ArrayList<>(list)); // deep copy
        } else {
            listOfPaths(root.left, targetSum, sum, lists, list);
            listOfPaths(root.right, targetSum, sum, lists, list);
        }

        list.remove(list.size() - 1);
    }
}
