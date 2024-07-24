visited = set()
def dfs(node,visited):
    visited.add(node)

    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)

def DFS(self,tree):
    if tree.root is None:
        return []
    
    visited,stack = [],[tree.root]

    while stack:
        node = stack.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)