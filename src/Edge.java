public class Edge {

    Vertex preRequisite;
    int weight;

    // Constructor
    public Edge(Vertex preRequisite, int weight) {
        this.preRequisite = preRequisite;
        this.weight = weight;
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("-- %.2f  -> %s  ", this.getWeight(),this.preRequisite.getName()));

        return str.toString();
    }

    private double getWeight() {
        return this.weight;
    }
}
