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

	public Vertex getVertex(String name) {
		Vertex vertex = graph.get(name);
		if (vertex == null) {
			vertex = new Vertex(name);
			graph.put(name, vertex);
		}
		return vertex;
	}

	public void addEdge(String source, String destination, double cost) {
		Vertex v = getVertex(source);
		Vertex w = getVertex(destination);
		Edge e = new Edge(v, w, cost);
		v.getEdges().add(e);
		w.getEdges().add(e);
	}

	public void printGraph() {
		System.out.println("\nAdjazenslisten des Graphen:\n[" + size() + " Knoten]\n");
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

	@Override
	public String toString() {
		String graph_string = "<html><body>Adjazenslisten des Graphen:<br>[" + size() + " Knoten]<br><br>";
		for (Vertex v : vertices()) {
			for (Edge e : v.getEdges()) {
				if (e.getLeft() == v) {
					graph_string += "(" + e.getLeft().getName() + "," + e.getRight().getName() + ") ";
				} else {
					graph_string += "(" + e.getRight().getName() + "," + e.getLeft().getName() + ") ";
				}
				graph_string += e.getCost() + "    ";
			}
			graph_string += "<br>";
		}
		graph_string += "</body></html>";
		return graph_string;
	}
}
