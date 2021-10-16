// PARADOX
import java.io.*;
import java.util.*;

class Graph
{
	private static int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked") Graph(int v)
	{
		// build a graph using adjacency list
		V = v;
		// create an empty list of 0's
		adj = new LinkedList[v];
		for(int i=0;i<V;i++)
		{
			adj[i] = new LinkedList();
		}

	}

	void addEdge(int v, int w)
	{
		// add an edge to a vertex
		adj[v].add(w);
	}

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//System.out.println("Enter N");
		int N = Integer.parseInt(br.readLine());
		int i = 1;
		// build a graph of size N
		Graph g = new Graph(N+1); // size of graph has an extra vertex to account for a vertex number N
       	V = N;
		while(N!=0){
			String s = br.readLine();
			int x = Integer.parseInt(s.charAt(0)+"");
			s = s.substring(2);
			// if statement i makes claim about statement x, add edge between i and x
			g.addEdge(i,x);
			// once i store all my input vertices, I call dfs on my graph
			if(i==V){
				i = 1;
				g.DFS();
			}
			// increment test case number to keep track of number of vertices
			i++;
			// decrement test cases
			N--;
		}
	}

	// helper DFS function to perform DFS traversal

	void DFSUtil(int v, boolean visited[])
	{
		// mark current vertex as visited
		visited[v] = true;
		if(v!=0)
      		System.out.println(v+" ");
		// check visited status for each adjacent neighbour
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext())
		{
			int n = i.next();
			if(!visited[n]){
				DFSUtil(n, visited);
			}
		}
	}

	void DFS()
	{
		boolean visited[] = new boolean[V+1];
		for(int i=0;i<=V;i++){
			// call helper DFS function
			DFSUtil(i, visited);
		}

	}
}
