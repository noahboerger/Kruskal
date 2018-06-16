import java.util.*;

public class Kruskal {

	private static Vertex findAndUpdateChef(Vertex v)
	{
		while(v.chef != v)
		{
			v.chef = v.chef.chef;
			v = v.chef;
		}
		return v;
	}
	
	public static void kruskal(Graph g)
	{
		PriorityQueue<Edge> p = new PriorityQueue<Edge>();
		p.addAll(g.edges());
		
		for(Vertex v : g.vertices())
		{
			v.chef = v;
		}
		int count = 0;
		
		Vertex x,y;
		
		while(count <  g.size()-1)
		{
			Edge e = p.poll();
			x = findAndUpdateChef(e.left);
			y = findAndUpdateChef(e.right);
			if (x != y)
			{
				x.chef = y;
				e.status = true;
				count++;
			}
		}
	}
}
