import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static DoubleLinkedList<Edge> graph1 = new DoubleLinkedList<>();

	public static void main(String[] args) {
        readGraph("graph.txt");
        System.out.println("unsortierte graph");
        System.out.println(graph1.toString());
        reversDelete();
        System.out.println("sortierter graph");
        System.out.println(graph1.toString());
        
	}

    private static void readGraph(String filename){
        BufferedReader bufferedReader;
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(filename));
            String line; 
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(";");
                graph1.insert(new Edge(data[0], data[1], data[2]));

            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Datei im Pfad nicht gefunden.");
            e.printStackTrace();
            return;
        }
    }

    private static void reversDelete(){
        int i = 1;

        while (i < graph1.length()) {
            System.out.println(i);
            graph1.delete(graph1.get(i));
            //if (edge.v1 is not connected to edge.v2){
              // E[i] edge
            //}
            i++;
        }
    }
}
