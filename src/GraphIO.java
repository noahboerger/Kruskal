import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class GraphIO {
	public static Graph readGraph(String path) throws IOException {
		Graph graph = new Graph();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String zeile;
		zeile = reader.readLine();
		while (zeile != null) {
			StringTokenizer stringtoken = new StringTokenizer(zeile, "(,)", false);
			String source = stringtoken.nextToken();
			String destination = stringtoken.nextToken();
			double cost = Double.parseDouble(stringtoken.nextToken());
			graph.addEdge(source, destination, cost);
			reader.readLine();
		}
		reader.close();
		System.out.println("Es wurden " + graph.size() + " Knoten eingelesen.");
		return graph;
	}

	public static void printGraph(Graph graph) {
		System.out.println("Adjazenslisten des Graphen:\n");
		for (Vertex v : graph.vertices()) {
			for (Edge e : v.getEdges()) {
				if (e.getLeft() == v) {
					System.out.println("(" + e.getLeft().getName() + "," + e.getRight().getName() + ")");
				} else {
					System.out.println("(" + e.getRight().getName() + "," + e.getLeft().getName() + ")");
					System.out.println(e.getCost() + "");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
