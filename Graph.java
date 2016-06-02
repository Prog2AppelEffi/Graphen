import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Graph{

	private ArrayList<Edge> graph = new ArrayList<>();

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
                this.graph.add(new Edge(data[0], data[1], data[2]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Datei im Pfad nicht gefunden.");
            e.printStackTrace();
            return;
        }
    }

    public String toString(){
        String output ="";
        for(Edge edge:graph) {
            output += edge.toString() + "\n";
        }
        return output;
    }

    public void reverseDelete(){
        bubbleSort();
        int i = 0;
        while (i < graph.size() ){
            Edge temp = graph.remove(i);
            if (!isConnected()){
                graph.add(i++, temp);
            }
        }
    }

    private void bubbleSort(){
        Edge temp;
        for (int i = 0; i < graph.size(); i++) {
            for(int j = 0; j<graph.size(); j++){
                if(graph.get(i).getWeight() > graph.get(j).getWeight()){
                    temp = graph.get(i);
                    graph.set(i, graph.get(j));
                    graph.set(j, temp);
                }
            }
        }
    }

    private boolean isConnected(){
        return false;
    }
}