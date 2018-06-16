import java.io.IOException;

public class starter {
	
	String filesep = System.getProperty("user.dir");
	
	public static void main(String[] args) throws IOException {
<<<<<<< HEAD
		Graph testgraph = GraphIO.readGraph("C:\\Users\\noahb\\Desktop\\Testgraphen\\Graph.dat");
=======
		System.out.println("Tsa");
		Graph testgraph = GraphIO.readGraph("D:\\Hochschule Mosbach\\2. Semester\\Programmieren\\Kruskal Projekt\\Kruskal\\Graph.dat");
		System.out.println("tds");
		//TODO METHODE MOVEN ZU GRAPH
>>>>>>> 95c5b12fd138b538980722f4a3bef7ef2ce6397c
		GraphIO.printGraph(testgraph);
		
		//Kruskal.kruskal(testgraph);
	}
}
