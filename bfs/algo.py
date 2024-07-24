def levelOrder(self, root):
    if not root:
        return []
    
    result = []
    queue = collections.deque()
    queue.append(root)

    while queue:
        size = len(queue)
        level = []

        for _ in range(size):
            node = queue.popleft()
            level.append(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        result.append(level)
    
    return result