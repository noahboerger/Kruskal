import java.util.*;

public class Kruskal {

	private static Vertex findAndUpdateChef(Vertex v)
	{
		while(v.getChef() != v)
		{
			v.setChef(v.getChef().getChef());
			v = v.getChef();
		}
		return v;
	}
	
	public static void kruskal(Graph g)
	{
		PriorityQueue<Edge> p = new PriorityQueue<Edge>();
		p.addAll(g.edges());
		
		for(Vertex v : g.vertices())
		{
			v.setChef(v);
		}
		int count = 0;
		
		Vertex x,y;
		
		while(count <  g.size()-1)
		{
			Edge e = p.poll();
			x = findAndUpdateChef(e.getLeft());
			y = findAndUpdateChef(e.getRight());
			if (x != y)
			{
				x.setChef(y);
				e.setStatus(true);
				count++;
			}
		}
	}
}
