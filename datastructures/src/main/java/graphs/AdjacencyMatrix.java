package graphs;

public class AdjacencyMatrix {
    private int nodes;
    private boolean adjacencyMatrix[][];

    public AdjacencyMatrix(int nodes) {
        this.nodes = nodes;
        adjacencyMatrix = new boolean[nodes][nodes];
    }

    public void addEdge(int source, int destination) {
        if (inBounds(source, destination)) {
            adjacencyMatrix[source][destination] = true;
            adjacencyMatrix[destination][source] = true;
        }
    }

    public void removeEdge(int source, int destination) {
        if (inBounds(source, destination)) {
            adjacencyMatrix[source][destination] = false;
            adjacencyMatrix[destination][source] = false;
        }
    }

    public boolean isEdge(int source, int destination) {
        if (inBounds(source, destination)) {
            return adjacencyMatrix[source][destination];
        } else {
            return false;
        }
    }

    private boolean inBounds(int source, int destination) {
        return ((source >= 0 && source < nodes) && (destination >= 0 && destination < nodes));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nodes; i++) {
            stringBuilder.append(i + " : ");
            for (boolean j : adjacencyMatrix[i]) {
                stringBuilder.append((j? 1: 0) + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(4);
        adjacencyMatrix.addEdge(0, 1);
        adjacencyMatrix.addEdge(0, 2);
        adjacencyMatrix.addEdge(1, 2);
        adjacencyMatrix.addEdge(2, 0);
        adjacencyMatrix.addEdge(2, 3);

        System.out.println("isEdge 0, 1: " + adjacencyMatrix.isEdge(0,1));
        System.out.println(adjacencyMatrix);

        adjacencyMatrix.removeEdge(0,1);
        System.out.println("isEdge 0, 1: " + adjacencyMatrix.isEdge(0,1));

        System.out.println(adjacencyMatrix);
    }
}
