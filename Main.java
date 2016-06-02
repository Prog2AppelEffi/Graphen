import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	private static DoubleLinkedList<Edge> edges = new DoubleLinkedList<>();
	private static DoubleLinkedList<Vertex> vertices = new DoubleLinkedList<>();

	public static void main(String[] args) {
        readGraph("graph.txt");
        System.out.println(vertices);
	}

    private static void readGraph(String filename){
        BufferedReader bufferedReader;
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(filename));
            String line; 
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(";");
                edges.insert(new Edge(data[0], data[1], data[2]));
          //      System.out.println(data[0] + data[1]);
                insertVertex(data[0]); 
                insertVertex(data[1]);

            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Datei im Pfad nicht gefunden.");
            e.printStackTrace();
            return;
        }
    }

    private static void reversDelete(DoubleLinkedList graph){
        int i = 1;

        while (i < graph.length()) {
            System.out.println(i);
            graph.delete(graph.get(i));
            //if (edge.v1 is not connected to edge.v2){
              // E[i] edge
            //}
            i++;
        }
    }
    
    public static boolean insertVertex(String data){
    	char a = data.charAt(0);
    	//System.out.println("suche " + a);
    	int i=0;
        while (i <= vertices.length()) {	
        	//System.out.println("   prüfe position " + i);
            if (vertices.get(i) != null && 
            		vertices.get(i).getVertex() == a) {
            	//System.out.println(i + " in liste ist " + a);
                return true;
			}
            i++;
        }
        //System.out.println("Füge ein " + a);
        vertices.insert(new Vertex(a));
        return false;
    	
    }
}
