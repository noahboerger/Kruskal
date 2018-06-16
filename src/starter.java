import java.io.IOException;

public class starter {
	//todo
	String filesep = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {

		Graph testgraph = GraphIO.readGraph("Graph.csv");
		
		testgraph.printGraph();
		
		Kruskal.kruskal(testgraph);
		
		System.out.println("Blah Blah Spannbaum: ");
		int gesamtkosten = 0;
		for(Edge e: testgraph.edges()) {
			if(e.isStatus()) {
				System.out.println("(" + e.getLeft().getName() + "," + e.getRight().getName() + ")  " + e.getCost());
				gesamtkosten += e.getCost();
			}
		}
		System.out.println("Gesamstkosten: " + gesamtkosten);
	}
}
