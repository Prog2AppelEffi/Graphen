import java.util.ArrayList;

/**
	Vertexklasse
	* @author Martin Appelmann 4685580 Group 2a 
	* @author Benjamin Effner 4633079 Group 2a
*/
public class Vertex implements Comparable<Vertex> {
	private ArrayList<Vertex> adjacent = new ArrayList<Vertex>();
	private char vertex;
	
	/**
		konstruktur 
		@param v als String, nimmt den ersten buchstaben
	*/
	public Vertex(String v) {
		vertex = v.charAt(0);
	}
	
	/**
	konstruktur 
	@param v als char
	*/
	public Vertex(char v) {
		vertex = v; 
	}
	
	/**
	erzeugt ein adjazenzverhaeltnis zwischen diesem knoten und dem knoten v
	@param v der andere knoten der zu diesem knoten adjazent ist
	*/
	public void makeAdjacent(Vertex v) {
		if (!this.adjacent.contains(v)) {
			this.adjacent.add(v);
		}
		if (!v.adjacent.contains(this)) {
			v.adjacent.add(this);
		}
	}
	
	/**
	fuegt den knoten v zur adjezenzliste zu
	@param v ist der hinzuzufuegende vertex
	*/
	public void addAdjacent(Vertex v) {
		this.adjacent.add(v);
	}
	/**
	Entfernt den knoten v aus
	@param v ist der zu entfernenede vertex
	*/
	public void removeAdjacent(Vertex v) {
		this.adjacent.remove(v);
	}
	/**
	gibt die adjezenzliste als arrayliste zurueck
	@return arraylist mit vertexobjekten
	*/
	public ArrayList<Vertex> getAdjacent() {
		return adjacent;
	}
	/**
	gibt den Vertexnamen als char zurueck
	@return char vertexname
	*/
	public char getVertex() {
		return vertex;
	}
	
	@Override
	public String toString() {
		String output = "";
		output += vertex + ", ";
		/*Ausgabe der Adjazenten Knoten hinter dem eigentlichen Knoten
		 * */
		int i = 0;
		char temp;
		while (i < adjacent.size()) {
			temp = adjacent.get(i).getVertex();
			output += "" + temp;
			i++;
		}
		return output;
	}
	
	@Override
	public int compareTo(Vertex v) {
		int r = 0;
		if (this.getVertex() == v.getVertex()) {
			r = 1;
		}
		return r;
	}
}
