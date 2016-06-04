import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
	private ArrayList<Vertex> adjacent = new ArrayList<Vertex>();
	private char vertex;
	
	public Vertex(String v){
		vertex = v.charAt(0);
	}
	public Vertex(char v){
		vertex = v;
	}
	/*public Vertex(String v, String adj){
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
	}*/
	
	
	public boolean adjacentTo(char v){
		for(int i = 0; i<adjacent.size();i++){
			if(adjacent.get(i).getVertex() == v){
				return true;
			}
		}
		return false;
	}
	public void makeAdjacent(Vertex V){
		if(!this.adjacent.contains(V)){
			this.adjacent.add(V);
		}
		if(!V.adjacent.contains(this)){
			V.adjacent.add(this);
		}
	}
	public void addAdjacent(Vertex V){
		this.adjacent.add(V);
	}
	public void removeAdjacent(Vertex V){
		this.adjacent.remove(V);
	}
	public ArrayList<Vertex> getAdjacent(){
		return adjacent;
	}
	
	
	public char getVertex(){
		return vertex;
	}
	public String toString(){
		String output = "";
		output += vertex + ", ";
		int i = 0;
		char temp;
		while(i < adjacent.size()){
			//output += "" + adjacent.get(i).toString();
			temp = adjacent.get(i).getVertex();
			output += "" + temp;
			i++;
		}
		return output;
	}
	
	@Override
	public int compareTo(Vertex v) {
		int r = 0;
		if(this.getVertex() == v.getVertex()){
			r = 1;
		}
		return r;
	}

}
