import java.util.*;

public class Kruskal {

	private static Vertex findAndUpdateChef(Vertex v)
	{
		while(v.chef != v)
		{
			v.chef = c.chef.chef;
			v = v.chef;
		}
		return v;
	}
	
	public static void kruskal(Graph g)
	{
		PriorityQueue<Edge> p = new PriorityQueue<Edge>();
		p.addAll(g.edges());
		
		for(Vertex v : g.Vertices())
		{
			v.chef = v;
		}
		int count = 0;
		
		Vertex x,y;
		
	}
}
