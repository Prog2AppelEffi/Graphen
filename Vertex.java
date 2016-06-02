
public class Vertex implements Comparable<Vertex> {
	private String adjacent = "";
	private int adjacentcount = 0;
	private char vertex;
	
	public Vertex(String v){
		vertex = v.charAt(0);
	}
	public Vertex(char v){
		vertex = v;
	}
	public Vertex(String v, String adj){
		vertex = v.charAt(0);
		adjacent = adjacent + adj;
	}
	public Vertex(char v, String adj){
		vertex = v;
		adjacent = adjacent + adj;
	}
	public Vertex(String v, char adj){
		vertex = v.charAt(0);
		adjacent = adjacent + adj;
	}
	public Vertex(char v, char adj){
		vertex = v;
		adjacent = adjacent + adj;
	}
	
	public boolean adjacentTo(char v){
		for(int i = 0; i<adjacent.length();i++){
			if(adjacent.charAt(i) == v){
				return true;
			}
		}
		return false;
	}
	
	public char getVertex(){
		return vertex;
	}
	public String toString(){
		return vertex + ", " + adjacent;
	}
	
	@Override
	public int compareTo(Vertex v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
