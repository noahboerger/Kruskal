import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphReader {
	// Teil Noah Börger

	// Erstellen eines Graphen anhand einer Ausgewählten csv Datei die im Pfad path
	// liegt und eine Adjazenzmatrix wiederspiegelt
	public static Graph readGraph(String path) throws IOException {
		Graph graph = new Graph();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			// Durchgehen jeder Zeile und erstellen der jeweiligen Knoten und Kanten
			String zeile;
			zeile = reader.readLine();
			// Targets bleiben gleiche und werden in StringArray Targets gespeichert
			String targets[] = zeile.split(";");
			zeile = reader.readLine();
			// Lauf Variable für Zeilen Zahl, um redundanten Teil der Adjazenzmatrix nicht
			// durchgehen zu müssen (Matrix muss gespiegelt sein für Kruskal Algorithmus)
			// =Ungerichteter Graph
			int akt_zeile = 1;
			// While Schleife geht jede einzelne Zeile durch
			while (zeile != null) {
				// Zeile wird gesplittet, 0. Element ist die Quelle, von der aus die Kanten für
				// die aktuelle Zeile eingetragen werden
				String zeile_splitt[] = zeile.split(";");
				String source = zeile_splitt[0];
				// Durchgehen des relevanten, nicht redundaten Teils der Zeile
				for (int i = akt_zeile; i < zeile_splitt.length; i++) {
					try {
						Double.parseDouble(zeile_splitt[i]);
					} catch (NumberFormatException nfe) {
						continue;
						// Hier macht ExceptionHandling Sinn, da bei einer NumberFormatException davon
						// ausgegangen werden kann, dass in der Adjazenzmatrix etwas wie ein x, für
						// keine Verbindung eingetragen wurde.
					}
					// Auslesen des Ziels der Kante
					String destination = targets[i];
					// Auslesen der Kosten
					double cost = Double.parseDouble(zeile_splitt[i]);

					// Eintragen der Kante
					graph.addEdge(source, destination, cost);
				}
				// Lesen der nächsten Zeile und erhöhen der Laufvariablen
				zeile = reader.readLine();
				akt_zeile++;
			}
		}
		return graph;
	}
}
