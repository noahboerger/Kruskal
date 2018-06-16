import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Vertex {
	private String name;
	private List<Edge> edges;
	private Vertex chef;

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Vertex getChef() {
		return chef;
	}

	public void setChef(Vertex chef) {
		this.chef = chef;
	}

	public void setName(String name) {
		this.name = name;
	}

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
