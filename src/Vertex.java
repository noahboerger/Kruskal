
public class Vertex {
	public String name;
	public List<Edge> edges;
	public Vertex chef;

	public Vertex(String name) {
		this.name = name;
		edges = new LinkedList<Edge>();
	}

	public Collection<Vertex> neighbors() {
		Collection name = new HashSet<Vertex>();
		for (Edge e : edges) {
			if (e.left != this)
				name.add(e.left);
			if (e.right != this)
				name.add(e.right);
		}
		return s;

	}

	public boolean hasEdge(Vertex with) {
		for (Vertex v : neighbors())
			if (v == with) {
				return true;
			}
		return false;
	}
}
