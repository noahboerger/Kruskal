import java.util.*;

public class Kruskal {
//Mohammad Alshaker
	
	// Setzt die Zugeh�rigkeit auf die Zugeh�rigkeit des vorherigen Knotens, damit
	// alle Knoten eines Netzes die gleiche Zugeh�rigkeit besitzen, sodass keine
	// Kreise gebildet werden
	private static Vertex findAndUpdateMembership(Vertex vertex) {
		while (vertex.getMembership() != vertex) {
			vertex.setMembership(vertex.getMembership().getMembership());
			vertex = vertex.getMembership();
		}
		return vertex;
	}

	// F�hrt den Kruskalalgorithmus durch: Kanten werden in PriorityQueue geladen,
	// Zugeh�rigkeit der Knoten wird auf sich selbst gesetzt. Die Kante mit den
	// geringsten Kosten wird in der Vorschleife entfernt und �berpr�ft ob sie noch
	// ben�tigt wird, um g�nstigstes Netz zu bilden oder ob die Knoten an ihren
	// Enden schon die selbe Zugeh�rigkeit haben. Knoten werden dementsprechen ihre
	// Zugeh�rigkeiten geupdatet und als Besucht markiert und die Schleife l�uft mit
	// n�chst teurerer Kante weiter.
	public static void kruskal(Graph graph) {
		PriorityQueue<Edge> pqueue = new PriorityQueue<Edge>();
		pqueue.addAll(graph.edges());

		for (Vertex vertex : graph.vertices()) {
			vertex.setMembership(vertex);
		}
		int count = 0;

		Vertex left, right;

		while (count < graph.size() - 1) {
			Edge edge = pqueue.poll();
			//wirft Null-Pointer Exception, wenn Graph aus Teilgraphen ohne zusammenf�hrende Kanten ausgewertet wird!
			left = findAndUpdateMembership(edge.getLeft());	
			right = findAndUpdateMembership(edge.getRight());
			if (left != right) {
				left.setMembership(right);
				edge.setStatus(true);
				count++;
			}
		}
	}
}
