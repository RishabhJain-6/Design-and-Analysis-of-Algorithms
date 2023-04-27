import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private int V;
	private LinkedList<Integer> nbrs[];
	int[] parent;
	int[] discoverTime;
	int[] finishTime;
	int time;

	Graph(int v) {
		V = v;
		nbrs = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			nbrs[i] = new LinkedList<Integer>();
		}
		parent = new int[V];
		discoverTime = new int[V];
		finishTime = new int[V];
	}

	void addEdge(int src, int dest) {
		nbrs[src].add(dest);
	}

	void DFS() {
		for (int i = 0; i < V; i++) {
			parent[i] = -1;
		}
		time = 0;
		for (int i = 0; i < V; i++) {
			if (parent[i] == -1) {
				DFS_Visit(i);
			}
		}
	}

	private void DFS_Visit(int u) {
		time = time + 1;
		discoverTime[u] = time;
		Iterator<Integer> i = nbrs[u].listIterator();
		while (i.hasNext()) {
			int v = i.next();
			if (parent[v] == -1) {
				parent[v] = u;
				DFS_Visit(v);
			}
		}
		time = time + 1;
		finishTime[u] = time;
		System.out.println("Node: " + u + " Parent: " + parent[u] + " Discovery Time: " + discoverTime[u]
				+ " Finish Time: " + finishTime[u]);
	}

	public static void main(String[] args) {
		Graph G = new Graph(6);

		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(1, 2);
		G.addEdge(2, 3);
		G.addEdge(3, 1);
		G.addEdge(4, 3);
		G.addEdge(4, 5);

		G.DFS();
	}
}
