
public class Edge {
	private Vertex left;
	private Vertex right;
	private double cost;
	private boolean status;

	public Edge(Vertex left, Vertex right, double cost) {
		this.left = left;
		this.right = right;
		this.cost = cost;
		status = false;
	}

	public int compareTo(Edge other) {
		if (this.getCost() < other.getCost()) {
			return -1;
		} else if (this.getCost() > other.getCost()) {
			return 1;
		} else {
			return 0;
		}
	}

	public Vertex getLeft() {
		return left;
	}

	public void setLeft(Vertex left) {
		this.left = left;
	}

	public Vertex getRight() {
		return right;
	}

	public void setRight(Vertex right) {
		this.right = right;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
