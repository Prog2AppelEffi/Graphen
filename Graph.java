import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Graph{

	private DoubleLinkedList<Edge> graph = new DoubleLinkedList<>();

	public Graph(String file){
		readGraph(file);
	}

	private void readGraph(String filename){
        BufferedReader bufferedReader;
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(filename));
            String line; 
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(";");
                graph.insert(new Edge(data[0], data[1], data[2]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Datei im Pfad nicht gefunden.");
            e.printStackTrace();
            return;
        }
    }

    public String toString(){
    	return graph.toString();
    }

    public void reverseDelete(){
        int i = 1;
        while (i < graph.length() ){
            System.out.println("=============================schritt " + i + " =====================");
            System.out.println("edge nummer " + graph.get(i));

            graph.delete(graph.get(i));
            if (!isConnected()){
                
            }
        }
    }

    private boolean isConnected(){
        return true;
    }
}