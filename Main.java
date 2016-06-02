

public class Main {

	public static void main(String[] args) {

        Graph graph = new Graph("graph.txt");
        
        System.out.println("unsortierte graph");
        System.out.println(graph.toString());
        graph.reverseDelete();
        System.out.println("sortierter graph");
        System.out.println(graph.toString());
        
	}

    
}
