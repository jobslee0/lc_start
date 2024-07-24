def maxDepth(self, root):
    if not root:
        return 0
    return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

def minDepth(self, root):
    if not root:
        return 0
    left = self.minDepth(root.left)
    right = self.minDepth(root.right)
    return left + right + 1 if (left == 0 or right == 0) else min(left, right) + 1

def generateParenthesis(self, n):
    self.list = []
    self._gen(0, 0, n, "")
    return self.list

    def _gen(self, left, right, n, result):
        if left == n and right == n:
            self.list.append(result)
            return
        if left < n:
            self._gen(left + 1, right, n, result + '(')
        if left > right and right < n:
            self._gen(left, right + 1, n, result + ')')