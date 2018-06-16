import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Vertex {
	public String name;
	public List<Edge> edges;
	public Vertex chef;

	public Vertex(String name) {
		this.name = name;
		edges = new LinkedList<Edge>();
	}

	public Collection<Vertex> neighbors() {
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

	public String getName() {
		return name;
	}
}
