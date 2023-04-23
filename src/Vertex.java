import java.util.ArrayList;

public class Vertex {

    String courseName;
    ArrayList<Edge> edges;

    public Vertex(String name) {
        this.courseName = name;
        this.edges = new ArrayList<Edge>();
    }

    public String getName() {
        return this.courseName;
    }
}
