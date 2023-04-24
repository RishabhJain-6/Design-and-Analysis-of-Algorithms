import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private int V;
	private LinkedList<Integer> nbrs[];

	Graph(int v) {
		V = v;
		nbrs = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			nbrs[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest) {
		nbrs[src].add(dest);
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
			Iterator<Integer> i = nbrs[u].listIterator();
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
		Graph G = new Graph(8);

		G.addEdge(1, 3);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(2, 4);
		G.addEdge(2, 5);
		G.addEdge(4, 5);
		G.addEdge(4, 6);
		G.addEdge(5, 6);
		G.addEdge(5, 7);
		G.addEdge(6, 7);

		G.BSF(0);
	}
}
