
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

	//private static DoubleLinkedList<Edge> edges = new DoubleLinkedList<>();
	//private static DoubleLinkedList<Vertex> vertices = new DoubleLinkedList<>();

	public static void main(String[] args) {

        Graph graph = new Graph("graph.txt");
        graph.bubbleSort();
        System.out.println(graph.toString());
        
        graph.reverseDelete();
        
        System.out.println(graph.toString());
        //graph.bubbleSort();
//        System.out.println("Vertices");
//        System.out.println(graph.printVertices());
        
        /*graph.reverseDelete();
        System.out.println("sortierter graph");
        System.out.println(graph.toString());*/
	}
}
