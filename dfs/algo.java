public int maxDepth(TreeNode root) {
    return null == root ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}

public int minDepth(TreeNode root) {
    if (root == null) return 0;
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
}

public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    gen(0, 0, n, "", result);
    return result;
}

private void gen(int left, int right, int n, String str, List<String> result) {
    if (left == n && right == n) {
        result.add(str);
        return;
    }
    if (left < n) {
        gen(left+1,right,n,str + "(",result);
    }
    if (left > right && right < n) {
        gen(left,right+1,n,str + ")",result);
    }
}