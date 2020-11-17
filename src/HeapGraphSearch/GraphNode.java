package HeapGraphSearch;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;

    public GraphNode(int key){

        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
    public String toString(){
        return  "" + this.key;
    }
}
