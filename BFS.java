import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v) {
		V = v;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest) {
		adj[src].add(dest);
	}

	void BSF(int src) {
		boolean visited[] = new boolean[V];
		Queue<Integer> Q = new LinkedList<Integer>();
		visited[src] = true;
		Q.add(src);

		int[] discoverTime = new int[V];
		int[] parent = new int[V];

		parent[src] = -1;

		while (!Q.isEmpty()) {
			int u = Q.poll();
			System.out.println("Node: " + u + " Parent: " + parent[u] + " Discovery Time: " + discoverTime[u]);
			Iterator<Integer> i = adj[u].listIterator();
			while (i.hasNext()) {
				int v = i.next();
				if (!visited[v]) {
					discoverTime[v] = discoverTime[u] + 1;
					parent[v] = u;
					visited[v] = true;
					Q.add(v);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(8);

		g.addEdge(1, 3);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 7);

		g.BSF(0);
	}
}
