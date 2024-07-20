public boolean isValidBST(TreeNode root) {
    return isValid(root, null, null);
}

public boolean isValid(TreeNode root, Integer min, Integer max) {
    if (null == root) {
        return true;
    }
    if (min != null && root.val <= min) {
        return false;
    }
    if (max != null && root.val >= max) {
        return false;
    }
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
}

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
        return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
