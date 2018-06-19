import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GraphReader {
	// Noah Börger

	// Erstellen eines Graphen anhand einer Ausgewählten csv Datei die im Pfad path
	// liegt
	public static Graph readGraph(String path) throws IOException {
		Graph graph = new Graph();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			// Durchgehen jeder Zeile und erstellen der jeweiligen Knoten und Kanten
			String zeile;
			zeile = reader.readLine();
			while (zeile != null) {
				StringTokenizer stringtoken = new StringTokenizer(zeile, ";", false);
				String source = stringtoken.nextToken();
				String destination = stringtoken.nextToken();
				double cost = Double.parseDouble(stringtoken.nextToken());
				graph.addEdge(source, destination, cost);
				zeile = reader.readLine();
			}
		}
		return graph;
	}
}
