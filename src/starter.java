import java.io.IOException;

public class starter {
	
	String filesep = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {

		Graph testgraph = GraphIO.readGraph("C:\\Users\\noahb\\Desktop\\Testgraphen\\Graph.dat");
		
		//TODO METHODE MOVEN ZU GRAPH
		GraphIO.printGraph(testgraph);
		
		Kruskal.kruskal(testgraph);
	}
}
