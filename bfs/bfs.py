def BFS(graph,start,end):
    queue = []
    queue.append([start])
    visited.add(start);

    while queue:
        node = queue.pop()
        visited.add(node)

        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)