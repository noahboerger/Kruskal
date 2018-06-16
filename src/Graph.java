import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

	private Map<String, Vertex> graph;

	//Konstruktor
	public Graph() {
		graph = new HashMap<String, Vertex>();
	}

	//Gibt zurück ob Graph leer ist
	public boolean isEmpty() {
		return graph.isEmpty();
	}

	//Gibt anzahl an Knoten des Graphen zurück
	public int size() {
		return graph.size();
	}

	//Gibt alle Kanten als Collection zurück
	public Collection<Edge> edges() {
		Set<Edge> set = new HashSet<Edge>();
		for (Vertex vertex : vertices()) {
			for (Edge edge : vertex.getEdges())
				set.add(edge);
		}
		return set;
	}

	//Gibt alle Knoten als Collection zurück
	public Collection<Vertex> vertices() {
		return graph.values();
	}

	//Gibt Knoten mit passendem Namen zurück oder erstellt diesen, falls noch nicht vorhanden
	public Vertex getVertex(String name) {
		Vertex vertex = graph.get(name);
		if (vertex == null) {
			vertex = new Vertex(name);
			graph.put(name, vertex);
		}
		return vertex;
	}

	//Fügt Kante in Graph ein 
	public void addEdge(String source, String destination, double cost) {
		Vertex vertex_source = getVertex(source);
		Vertex vertex_destination = getVertex(destination);
		Edge edge = new Edge(vertex_source, vertex_destination, cost);
		vertex_source.getEdges().add(edge);
		vertex_destination.getEdges().add(edge);
	}

	//Gibts Adjazenslisten des Graphen in Konsole aus
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

	//Gibt Adjazenslisten des Graphen als HTML String für JFrame zurück
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
