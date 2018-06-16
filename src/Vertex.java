import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Vertex { // Initialisiere Konten
	private String name;
	private List<Edge> edges;
	private Vertex membership; // nutze Zugehörigkeit um Kreise zu erkenne

	public Vertex(String name) {
		this.name = name;
		edges = new LinkedList<Edge>();
	}

	public Collection<Vertex> neighbors() { //sucht Nachbar eines Knoten 
		Collection<Vertex> name = new HashSet<Vertex>();
		for (Edge e : edges) {
			if (e.getLeft() != this) {
				name.add(e.getLeft());
			}
			if (e.getRight() != this) {
				name.add(e.getRight());
			}
		}
		return name;

	}

	public boolean hasEdge(Vertex with) {
		for (Vertex v : neighbors())
			if (v == with) {
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
