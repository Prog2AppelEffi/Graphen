
public class Edge implements Comparable<Edge> {
	private char vertex1;
	private char vertex2;
	private int weight;
	
	public Edge(String v1, String v2, String w){
		vertex1 = v1.charAt(0);
		vertex2 = v2.charAt(0);
		weight = Integer.parseInt(w);
	}
	
	
	public void insert(){
		
	}
	
	public String toString(){
		
		return vertex1+ ";" + vertex2 + ";" + weight;
	}


	@Override
	public int compareTo(Edge arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
