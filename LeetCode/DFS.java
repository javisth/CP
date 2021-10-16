// DFS
import java.io.*;
import java.util.*;

class Graph 
{
	private int V; // number of vertices

	LinkedList<Integer> adj[]; // array of lists for adjacency list

	// graph constructor to create graph
	Graph(int v){
		V = v;
		// make a new adjacency list array of size V
		adj = new LinkedList[v];
		for(int i=0;i<V; i++){
			adj[i] = new LinkedList();
		}
	}

	// add an edge into the graph
	void addEdge(int v, int w){
		adj[v].add(w);  // adding w to v's list
	}

	void DFS(int s){
		// mark all vertices as not visited
		boolean visited[] = new boolean[V];
		/*
		// call recursive helper function to print DFS traversal starting from all vertices one by one
		for(int i=0;i<V;i++){
				if(visited[i] == false)
					DFSUtil(i, visited);
		}
		*/
		// create a stack for DFS
		Stack<Integer> stack = new Stack<>();
		// push the current source node
		stack.push(s);
		while(!stack.empty())
		{
			// pop a vertex from the stack and print it
			s = stack.peek();
			stack.pop();

			// print popped item if visited to avoid having duplicate vertices
			if(!visited[s])
			{
				System.out.print(s + " ");
				visited[s] = true;
			}
			// push adjacent vertices of s into the stack if not visited
			Iterator<Integer> i = adj[s].iterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n])
					stack.push(n);
			}
		}

		//DFSUtil(v, visited);
	}

	void DFSUtil(int v, boolean visited[]){
		// mark current node as visited and print it
		visited[v] = true;
		System.out.print(v+ " ");

		// Recur for all vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if (!visited[n]){
				DFSUtil(n, visited);
			}
		}
	}

	public static void main(String args[])
	{
		// create a graph of 4 vertices
		Graph g = new Graph(4);

		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(2,3);
		g.addEdge(3,3);

		System.out.println("Depth First Traversal starting from vertex 2");

		g.DFS(0);

	}
}