package HeapGraphSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite2 {
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode node: graph){
            if (!BFS(node, visited)){
                return false;
            }
        }
        return true;
    }
    public boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited){
        if (visited.containsKey(node)){
            return true;
        }
        //offer root, expand root, then generate the neighbors
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        //先指定一个visited assign一个group 为0；<node1：group 0>
        visited.put(node, 0);
        while (!queue.isEmpty()){
            //expand the root node
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur);
            int neigGroup = curGroup == 0 ? 1:0;
            for ( GraphNode nei: cur.neighbors){
                if(!visited.containsKey(nei)){
                    visited.put(nei, neigGroup);
                    queue.offer(nei);
                }else if (visited.get(nei) != neigGroup){
                    return false;
                }
            }
        }
        return true;
    }
}
