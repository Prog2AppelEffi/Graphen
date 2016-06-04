
public class Edge implements Comparable<Edge> {
	private Vertex vertex1;
	private Vertex vertex2;
	private int weight;
	
	/*public Edge(String v1, String v2, String w){
		vertex1 = v1.charAt(0);
		vertex2 = v2.charAt(0);
		weight = Integer.parseInt(w);
	}*/
	public Edge(Vertex vert1, Vertex vert2, String w){
		vertex1 = vert1;
		vertex2 = vert2;
		weight = Integer.parseInt(w);
		vertex1.makeAdjacent(vertex2);
	}

	public Vertex getVertex1(){
		return vertex1;
	}

	public Vertex getVertex2(){
		return vertex2;
	}
	
	public int getWeight(){
		return weight;
	}

	public String toString(){
		return vertex1.getVertex()+ ";" + vertex2.getVertex() + ";" + weight;
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
