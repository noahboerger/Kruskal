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
		Set s = new HashSet<Edge>();
		for (Vertex v : vertices()) {
			for (Edge e : v.edges)
				s.add(e);
		}
		return s;
	}

	public Collection<Vertex> vertices() {
		return graph.values();
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
		v.edges.add(e);
		w.edges.add(e);
	}
}
