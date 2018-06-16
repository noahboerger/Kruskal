import java.io.IOException;

public class starter {
	
	String filesep = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {

		Graph testgraph = GraphIO.readGraph("C:\\Users\\noahb\\Desktop\\Testgraphen\\Graph.csv");
		
		//TODO METHODE MOVEN ZU GRAPH
		GraphIO.printGraph(testgraph);
		
		Kruskal.kruskal(testgraph);
		
		System.out.println("Blah Blah Spannbaum: ");
		int kostengesamt = 0;
		for(Edge e: testgraph.edges()) {
			if(e.isStatus()) {
				System.out.println("(" + e.getLeft().getName() + "," + e.getRight().getName() + ")  " + e.getCost());
				kostengesamt += e.getCost();
			}
		}
		System.out.println("Gesamstkosten: " + kostengesamt);
	}
}
