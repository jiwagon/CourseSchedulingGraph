import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//CourseScheduler = graph;
public class CourseScheduler {

    ArrayList<Vertex> courses;

    public CourseScheduler() {
        this.courses = new ArrayList<>();
    }

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
            System.out.println("Course " + vertex + " already exists.");
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

        for (int i = 0; i < start.edges.size(); i++) {
            if (start.edges.get(i).preRequisite.courseName == toCourse) {
                    System.out.println("End Edge already exists in Graph");
                    return;
                }
            }

        // Add same edge from end to start
        start.edges.add(new Edge(end, weight));
        // end.edges.add(new Edge(start, weight));-- dont need this for directed graph
        // add vertex to startVertex arraylist of edges if edge with endVertex is not existing
        // add vertex to endVertex arraylist of edges if edge with startVertex is not existing
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : courses) {
            sb.append(vertex.courseName).append(": ");
            for (Edge edge : vertex.edges) {
                sb.append(edge.preRequisite.courseName).append(" (").append(edge.weight).append(")  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

        // Breadth-First Traversal
        public String BFS(String startName, String endName){

        Queue<Vertex> searchQ = new LinkedList<>();
        ArrayList<Vertex> visitedVertices = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();
        StringBuilder stb = new StringBuilder();

        int index = this.getIndex(startName);
        searchQ.add(this.courses.get(index));
        visitedVertices.add(this.courses.get(index));
        paths.add(this.courses.get(index).courseName);

        while(!searchQ.isEmpty()){
            Vertex current = searchQ.remove();
            stb.append(current.courseName + " - ");
            int pos = visitedVertices.indexOf(current);
            if(current.courseName.equals(endName))
                return paths.get(pos);

            for(Edge edge: current.edges){
                if(!visitedVertices.contains(edge.preRequisite)){
                    searchQ.add(edge.preRequisite);
                    visitedVertices.add(edge.preRequisite);
                    paths.add(paths.get(pos) + "--" + edge.preRequisite.courseName);
                }
            }
        }
        return "";
    }
}
