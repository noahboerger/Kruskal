import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

	private Map<String, Vertex> graph;

	public Graph() {
		graph = new HashMap<String, Vertex>();
	}

	public boolean isEmpty() {
		return graph.isEmpty();
	}

	public int size() {
		return graph.size();
	}

	public Collection<Edge> edges() {
		Set<Edge> s = new HashSet<Edge>();
		for (Vertex v : vertices()) {
			for (Edge e : v.getEdges())
				s.add(e);
		}
		return s;
	}

	public Collection<Vertex> vertices() {
		return graph.values();
	}

	public Map<String, Vertex> getGraph() {
		return graph;
	}

	public void setGraph(Map<String, Vertex> graph) {
		this.graph = graph;
	}

	public Vertex getVertex(String s) {
		Vertex v = graph.get(s);
		if (v == null) {
			v = new Vertex(s);
			graph.put(s, v);
		}
		return v;
	}

	public void addEdge(String source, String dest, double cost) {
		Vertex v = getVertex(source);
		Vertex w = getVertex(dest);
		Edge e = new Edge(v, w, cost);
		v.getEdges().add(e);
		w.getEdges().add(e);
	}
	
	public  void printGraph() {
		System.out.println("\nAdjazenslisten des Graphen:\n");
		for (Vertex v : vertices()) {
			for (Edge e : v.getEdges()) {
				if (e.getLeft() == v) {
					System.out.print("(" + e.getLeft().getName() + "," + e.getRight().getName() + ") ");
				} else {
					System.out.print("(" + e.getRight().getName() + "," + e.getLeft().getName() + ") ");
				}
				System.out.print(e.getCost() + "    ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
