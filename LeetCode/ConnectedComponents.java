/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/

class ConnectedComponents{
	public int connectedComponents(int n, List<List<Integer> edges){
		// define result for return
		int result = 0;
		// create an adjacency list from edges
		List<Integer> adj[] = new ArrayList<>();

		for(List<Integer> edge: edges){
			int from = edge.get(0);
			int to = edge.get(1);

			adj[from].add(to);
			adj[to].add(from);
		}

		// stack for DFS
		Stack<Integer> stack = new Stack<>();

		// array to keep track of visited nodes
		boolean visited[] = new visited[n];

		// iterate through each node
		for(int i = 0; i < n; i++){
			// if node is not visited, start dfs
			if(!visited[i]){
				// add node to the stack to process
				stack.push(i);
				// increment connected component count
				result++;

				// while stack is not empty keep processing each node
				while(!stack.isEmpty()){
					// get current node in stack
					int top = stack.pop();

					// mark it as visited
					visited[top] = true;

					// visit all neighbours of the stack element
					for(int neighbour: adj[top]){
						// if neighbour is not visited, add it to the stack
						if(!visited[neighbour]){
							stack.push(neighbour);
						}
					}
				}
			}
		}
		return resut;
	}
}