public class Main {

	public static void main(String[] args) {

        Graph graph = new Graph("graph.txt");
        graph.bubbleSort();
        System.out.println(graph.toString());
        graph.reverseDelete();
        System.out.println(graph.toString());
	}
}
