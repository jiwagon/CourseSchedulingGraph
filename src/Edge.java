public class Edge {

    Vertex preRequisite;
    int weight;

    // Constructor
    public Edge(Vertex preRequisite, int weight) {
        this.preRequisite = preRequisite;
        this.weight = weight;
    }
}
