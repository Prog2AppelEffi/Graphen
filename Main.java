/**
Graphenerzeugung und ausgabe in der Konsole. enthaelt zusaetzlich den reverseDelete algorithmus
 * @author Martin Appelmann 4685580 Group 2a 
 * @author Benjamin Effner 4633079 Group 2a
*/
public class Main {
	/**
	Startet das Programm
	@param args muss ich glaub ich nicht extra erklaeren... aber Stylecheck will das
	*/
	public static void main(String[] args) {

        Graph graph = new Graph("graph.txt");
        System.out.println(graph.toString());
        graph.reverseDelete();
        System.out.println(graph.toString());
	}
}
