import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class GraphIO {
	public static Graph readGraph(String path) throws IOException {
		Graph graph = new Graph();
		BufferedReader reader = new BufferedReader(new FileReader(path));
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
		reader.close();
		
		System.out.println("Es wurden " + graph.size() + " Knoten eingelesen.");
		return graph;
	}
}
