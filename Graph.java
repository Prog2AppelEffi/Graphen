import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
  * @author Martin Appelmann 4685580 Group 2a 
 * @author Benjamin Effner 4633079 Group 2a
*/
public class Graph {

	private ArrayList<Edge> edges = new ArrayList<>();
	private ArrayList<Vertex> vertices = new ArrayList<>();
/**
*konstruktor fuer den graphen, braucht den dateinamen
*@param file der name der datei
*/
	public Graph(String file) {
		readGraph(file);
	}
	/**
*	liest die Textdatei ein und erzeugt einen graphen daraus
*	@param filename der name der datei
	*/
	private void readGraph(String filename) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(filename));
            String line; 
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(";");
                this.edges.add(new Edge(insertVertex(data[0]), 
                    insertVertex(data[1]), data[2]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Datei im Pfad nicht gefunden.");
            e.printStackTrace();
            return;
        }
    }
	/**
	erzeugt einen neuen Vertex, fuegt diesen in die array list vertices ein 
	und gibt den entsprechenden Vertex zurueck
	@param data uebergibt den namen des Vertex
	@return gibt den eingefuegten vertex zurueck
	*/
	public Vertex insertVertex(String data) {
    	char a = data.charAt(0);
    	int i = 0;
    	
        while (i < vertices.size()) {
        	if (vertices.get(i).getVertex() == a) {
                return vertices.get(i);
			}
            i++;
        }
        vertices.add(new Vertex(a));
        return vertices.get(vertices.size() - 1);
    }
	
	@Override
    public String toString() {
        String output = "";
        for (Edge edge:edges) {
            output += edge.toString() + "\n";
        }
        return output;
    }
    /**
	schreibt alle Knoten des Graphen auf
	@return gibt einen String mit allen Vertices zurueck
	*/
    public String printVertices() {
    	String output = "";
        for (Vertex vertex:vertices) {
            output += vertex.toString() + "\n";
        }
        return output;
    }
	/**
	reverse delete algorithmus
	*/
    public void reverseDelete() {
    	if (!isConnected()) {
        	System.out.println("Der Graph ist nicht zusammenhaengend");
        	return;
        }
        int i = 0;
        bubbleSort();
        while (i < edges.size()) {
            Edge temp = edges.get(i);
            edges.get(i).getVertex1().removeAdjacent(edges.get(i).getVertex2());
            edges.get(i).getVertex2().removeAdjacent(edges.get(i).getVertex1());
            edges.remove(i);
            if (!isConnected()) {
            	temp.getVertex1().addAdjacent(temp.getVertex2());
                temp.getVertex2().addAdjacent(temp.getVertex1());
            	edges.add(i, temp);
            	i++;
            }
        }
    }
    /**
	Prueft ob der Graph zusammenhaengend ist
	@return true wenn er zusammenhaengend ist
	*/
    public boolean isConnected() {
    	ArrayList<Vertex> stillCheck = new ArrayList<>();
    	ArrayList<Vertex> checked = new ArrayList<>();
    	bfs(vertices.get(0), stillCheck, checked);
    	if (checked.size() == vertices.size()) {
    		return true;
    	}
    	return false;
    }
    /**
	breadth-first search
	methode fuer rekursiven aufruf
	@param start ist der Vertex, von dem aus alle adjazenten Knoten geprueft werden
	@param stillCheck ist die adjazentsliste der noch zu Pruefenden knoten, die aber schon angesteuert wurden


	 * eventuell ist stillCheck unnoetig*
	 * @param checked ist eine liste mit allen bereits geprueften vertices
	 * @return gibt in dieser version immer false zurueck, da der Rueckgabewert nicht mehr relevant ist. 
	 * es wird die groesse von checked ueberprueft
	 */
    private boolean bfs(Vertex start, ArrayList<Vertex> stillCheck, ArrayList<Vertex> checked) {

    	stillCheck.add(start);
    	for (int i = 0; i < start.getAdjacent().size(); i++) {
    		if (!checked.contains(start.getAdjacent().get(i)) && !stillCheck.contains(start.getAdjacent().get(i))) {
    			bfs(start.getAdjacent().get(i), stillCheck, checked);
    		}
    	}
    	stillCheck.remove(start);
    	checked.add(start);
    }
    /**
	 * Bubblesort algorithmus fuer die Kantenliste
	 * Sortiert nach gewicht der Kante
	 */
    private void bubbleSort() {
        Edge temp;
        for (int i = 0; i < edges.size(); i++) {
            for (int j = 0; j < edges.size(); j++) {
                if (edges.get(i).getWeight() > edges.get(j).getWeight()) {
                    temp = edges.get(i);
                    edges.set(i, edges.get(j));
                    edges.set(j, temp);
                }
            }
        }
    }
}