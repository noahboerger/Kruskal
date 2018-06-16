import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Vertex { 

	//Deklaration der Variablen
	private String name;
	private List<Edge> edges;
	// nutze Zugeh�rigkeit um Kreise zu erkenne
	private Vertex membership; 

	public Vertex(String name) {
		this.name = name;
		edges = new LinkedList<Edge>();
	}

	//Gibt alle Nachbarknoten als Collection zur�ck
	public Collection<Vertex> neighbors() {
		Collection<Vertex> neighbors = new HashSet<Vertex>();
		for (Edge e : edges) {
			if (e.getLeft() != this) {
				neighbors.add(e.getLeft());
			}
			if (e.getRight() != this) {
				neighbors.add(e.getRight());
			}
		}
		return neighbors;

	}

	//�berpr�ft ob Kante mit anderem Knoten besteht
	public boolean hasEdge(Vertex with) {
		for (Vertex vertex : neighbors())
			if (vertex == with) {
				return true;
			}
		return false;
	}

	// Setter und Getter- Methoden
	public String getName() {
		return name;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Vertex getMembership() {
		return membership;
	}

	public void setMembership(Vertex membership) {
		this.membership = membership;
	}

	public void setName(String name) {
		this.name = name;
	}
}
