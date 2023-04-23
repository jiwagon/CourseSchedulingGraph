import java.util.ArrayList;

//CourseScheduler = graph;
public class CourseScheduler {

    ArrayList<Vertex> courses;

    public CourseScheduler() {
        this.courses = new ArrayList<>();
    }

//    // Method to add a class as a vertex to the graph
//    public void addCourse(String courseName) {
//        this.courses.add(new Vertex(courseName));
//    }
//
//    // Helper method to get the vertex by class name
//    private Vertex getVertex(String className) {
//        for (Vertex vertex : graph) {
//            if (vertex.className.equals(className)) {
//                return vertex;
//            }
//        }
//        return null;
//    }
//
//    // Method to add a prerequisite between two classes as an edge in the graph
//    public void addPrerequisite(String fromClass, String toClass, int weight) {
//        Vertex fromVertex = getVertex(fromClass);
//        Vertex toVertex = getVertex(toClass);
//        fromVertex.edges.add(new Edge(toVertex, weight));
//    }

    public int getIndex(String vertex) {
        for (int i = 0; i < this.courses.size(); i++) {
            if (this.courses.get(i).courseName == vertex)
                return i;
        }
        return -1;
    }

    // Add a vertex to a graph
    public Vertex addCourse(String vertex) {
        Vertex toAdd = new Vertex(vertex);
        // or if (!vertices.contains(vertex))
        // vertex.compareTo(String.valueOf(vertices)) == 0
        if (getIndex(vertex) == -1) {
            this.courses.add(toAdd);
        }
        else {
            System.out.println("Vertex" + vertex + " already exists.");
        }
        return toAdd;
    }

    public void addPrerequisite(String fromCourse, String toCourse, int weight) {
        Vertex start;
        Vertex end;
        // check if start vertex exists or not
        int startPos = this.getIndex(fromCourse);
        if (startPos < 0) {
            start = this.addCourse(fromCourse);
        }
        else {
            start = this.courses.get(startPos);
        }
        // check if end vertex exists or not
        int endPos = this.getIndex(toCourse);
        if (endPos < 0) {
            end = this.addCourse(toCourse);
        }
        else {
            end = this.courses.get(endPos);
        }

//        for (int i = 0; i < start.edges.size(); i++) {
//            if (start.edges.get(i).eVertex.vName == endVer) {
//                    System.out.println("End Edge already exists in Graph");
//                    return;
//                }
//            }
//
//        for (int i = 0; i < start.edges.size(); i++) {
//            if (end.edges.get(i).eVertex.vName.equals(startVer)) {
//                System.out.println("Start Edge already exists in Graph");
//                return;
//            }
        //}

        // Add same edge from end to start
        start.edges.add(new Edge(end, weight));
        end.edges.add(new Edge(start, weight));
        // add vertex to startVertex arraylist of edges if edge with endVertex is not existing
        // add vertex to endVertex arraylist of edges if edge with startVertex is not existing
    }
}
