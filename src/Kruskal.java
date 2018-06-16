import java.util.*;

public class Kruskal {

	private static Vertex findAndUpdateMembership(Vertex vertex) {
		while (vertex.getMembership() != vertex) {
			vertex.setMembership(vertex.getMembership().getMembership());
			vertex = vertex.getMembership();
		}
		return vertex;
	}

	public static void kruskal(Graph graph) {
		PriorityQueue<Edge> p = new PriorityQueue<Edge>();
		p.addAll(graph.edges());

		for (Vertex vertex : graph.vertices()) {
			vertex.setMembership(vertex);
		}
		int count = 0;

		Vertex x, y;

		while (count < graph.size() - 1) {
			Edge edge = p.poll();
			x = findAndUpdateMembership(edge.getLeft());
			y = findAndUpdateMembership(edge.getRight());
			if (x != y) {
				x.setMembership(y);
				edge.setStatus(true);
				count++;
			}
		}
	}
}
