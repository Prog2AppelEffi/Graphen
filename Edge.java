
public class Edge implements Comparable<Edge> {
	private char vertex1;
	private char vertex2;
	private int weight;
	
	public Edge(String v1, String v2, String w){
		vertex1 = v1.charAt(0);
		vertex2 = v2.charAt(0);
		weight = Integer.parseInt(w);
	}

	public int getVertex1(){
		return vertex1;
	}

	public int getVertex2(){
		return vertex2;
	}
	
	public int getWeight(){
		return weight;
	}

	public String toString(){
		return vertex1+ ";" + vertex2 + ";" + weight;
	}


	@Override
	public int compareTo(Edge tempEdge) {
		if (tempEdge.getWeight() == this.getWeight()) {
            return 0;
        } else if (tempEdge.getWeight() < this.getWeight()) {
            return -1;
        } else {
        	return 1;
        }
	}
}
