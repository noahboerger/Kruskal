import java.io.IOException;

public class starter {
	
	String filesep = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {
		System.out.println("Tsa");
		Graph testgraph = GraphIO.readGraph("D:\\Hochschule Mosbach\\2. Semester\\Programmieren\\Kruskal Projekt\\Kruskal\\Graph.dat");
		System.out.println("tds");
		//TODO METHODE MOVEN ZU GRAPH
		GraphIO.printGraph(testgraph);
	}
}
