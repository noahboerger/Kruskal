import org.junit.Test;
import static org.junit.Assert.*;

public class KruskalTest {
	//Teil Brendan Bochmann
		
	//Testet Adjazensmatrix indem es Matrix erstellt und auf richtige Größe überprüft
	@Test
	public void AdjazensmatrixTest() {
		int ergebnis = 0;
		Graph graph = TestGraph1();
		ergebnis = graph.size();
		assertEquals(ergebnis, 4, 0);
	}

	//Zyklenerkennungstest da bei Fehlerhafter Zyklenerkennung Kruskal den Wert 70 ausgeben würde
	@Test
	public void Zyklenerkennung() {
		double ergebnis = 0;
		Graph graph = TestGraph1();
		ergebnis = Kruskal.kruskal(graph);
		assertEquals(ergebnis, 50.0f, 0.0f);
	}

	//Testet Kruskal indem es die resultierenden Kosten des Graphen überprüft
	@Test
	public void KruskalAlgorithmusTest() {
		double ergebnis = 0;
		Graph graph = TestGraph2();
		ergebnis = Kruskal.kruskal(graph);
		assertEquals(ergebnis, 137.0f, 0.0f);
	}
	
	//Testet ob eine Null Pointer exception Auftritt wenn ein unzusammenhängender Graph übergeben wird
	@Test(expected=NullPointerException.class)
	public void KruskalAlgorithmusTestInsel() {
		Graph graph = TestGraph3();
		Kruskal.kruskal(graph);
	}
	
	//Graph für die Zyklenerkennung
	private Graph TestGraph1() {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 10.0);
		graph.addEdge("A", "C", 15.0);
		graph.addEdge("B", "C", 20.0);
		graph.addEdge("B", "D", 25.0);
		graph.addEdge("C", "D", 30.0);
		return graph;
	}
	
	//Erstellt einen Testgraphen, der die Kosten 137 hat
	private Graph TestGraph2() {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 80.0);
		graph.addEdge("A", "F", 15.0);
		graph.addEdge("A", "G", 60.0);
		graph.addEdge("B", "C", 12.0);
		graph.addEdge("B", "D", 10.0);
		graph.addEdge("B", "E", 20.0);
		graph.addEdge("C", "E", 30.0);
		graph.addEdge("C", "G", 50.0);
		graph.addEdge("D", "E", 40.0);
		graph.addEdge("D", "F", 35.0);
		graph.addEdge("E", "F", 70.0);
		graph.addEdge("E", "G", 45.0);
		return graph;
	}
	
	//ersellt einen Graphen mit 2 Inseln -> Kein Spannbaum möglich
	private Graph TestGraph3() {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 80.0);
		graph.addEdge("A", "F", 15.0);
		graph.addEdge("A", "G", 60.0);
		graph.addEdge("B", "C", 12.0);
		graph.addEdge("B", "D", 10.0);
		graph.addEdge("B", "E", 20.0);
		graph.addEdge("C", "E", 30.0);
		graph.addEdge("C", "G", 50.0);
		graph.addEdge("D", "E", 40.0);
		graph.addEdge("D", "F", 35.0);
		graph.addEdge("E", "F", 70.0);
		graph.addEdge("E", "G", 45.0);
		//InselGraph
		graph.addEdge("H", "I", 15.0);
		graph.addEdge("H", "J", 20.0);
		graph.addEdge("I", "J", 10.0);
		return graph;
	}
}
