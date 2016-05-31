import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		DoubleLinkedList<Edge> graph1 = new DoubleLinkedList<Edge>();
        initGraph(graph1, "graph.txt");
        System.out.println(graph1);
	}
	
    public static void initGraph(List<Edge> list, String filename) {
    	BufferedReader bufferedReader;
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(filename));
            String line; 
            String[] data;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals("")) {
                    data = line.split(";");
                    list.insert(new Edge(data[0], data[1], data[2]));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
