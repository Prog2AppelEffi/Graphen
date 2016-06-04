
/**
Klasse fuer Kanten des Graphen
 * @author Martin Appelmann 4685580 Group 2a 
 * @author Benjamin Effner 4633079 Group 2a
*/
public class Edge implements Comparable<Edge> {
	private Vertex vertex1;
	private Vertex vertex2;
	private int weight;
	/**
	Konstruktor fuer eine Kante
	@param vert1 ist ein Vertex Objekt an der kante
	@param vert2 ist ein Vertex Objekt an der kante
	@param w Das gewicht der kante, uebergeben als String und umgewandelt zum int
	*/
	public Edge(Vertex vert1, Vertex vert2, String w) {
		vertex1 = vert1;
		vertex2 = vert2;
		weight = Integer.parseInt(w);
		vertex1.makeAdjacent(vertex2);
	}

	public Vertex getVertex1() {
		return vertex1;
	}

	public Vertex getVertex2() {
		return vertex2;
	}
	
	public int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return vertex1.getVertex() + ";" + vertex2.getVertex() + ";" + weight;
	}


	@Override
	public int compareTo(Edge tempEdge) {
		//System.out.println(tempEdge);
		if (tempEdge.getWeight() == this.getWeight()) {
            return 0;
        } else if (tempEdge.getWeight() < this.getWeight()) {
            return -1;
        } else {
        	return 1;
        }
	}
}
