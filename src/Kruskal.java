import java.util.*;

public class Kruskal {
//Mohammad Alshaker
	
	// Setzt die Zugehörigkeit auf die Zugehörigkeit des vorherigen Knotens, damit
	// alle Knoten eines Netzes die gleiche Zugehörigkeit besitzen, sodass keine
	// Kreise gebildet werden
	private static Vertex findAndUpdateMembership(Vertex vertex) {
		while (vertex.getMembership() != vertex) {
			vertex.setMembership(vertex.getMembership().getMembership());
			vertex = vertex.getMembership();
		}
		return vertex;
	}

	// Führt den Kruskalalgorithmus durch: Kanten werden in PriorityQueue geladen,
	// Zugehörigkeit der Knoten wird auf sich selbst gesetzt. Die Kante mit den
	// geringsten Kosten wird in der Vorschleife entfernt und überprüft ob sie noch
	// benötigt wird, um günstigstes Netz zu bilden oder ob die Knoten an ihren
	// Enden schon die selbe Zugehörigkeit haben. Knoten werden dementsprechen ihre
	// Zugehörigkeiten geupdatet und als Besucht markiert und die Schleife läuft mit
	// nächst teurerer Kante weiter.
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
			//wirft Null-Pointer Exception, wenn Graph aus Teilgraphen ohne zusammenführende Kanten ausgewertet wird!
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
