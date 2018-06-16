import java.util.*;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.javafx.geom.Edge;

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
		
		while(count <  g.size()-1)
		{
			Edge e = p.poll();
			x = findAndUpdateChef(e.left);
			y = findAndUpdateChef(e.right);
			if (x != y)
			{
				x.Chef = y;
				e.status = true;
				count++;
			}
		}
	}
}
