import java.util.ArrayList;
public class GraphNode<T extends Comparable> {
    public boolean visited;
    public T data;
    public ArrayList<GraphNode<T>> adjecentNodes;

    public GraphNode (T data) {
        this.data = data;
        this.adjecentNodes = new ArrayList<GraphNode<T>>();
        this.visited = false;
    }
}