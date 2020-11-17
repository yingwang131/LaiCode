package HeapGraphSearch;

import HeapGraphSearch.GraphNode;

import java.util.*;

/*
expand the head of the queue
generate all its neightbors
case1: neightbor is not colored
        color the neightbor in the opposite color
        push the neightbor into the queue
case2: neighbor is already colored
        case2.1: if neightbor is in the same color, return flase
        case2.2: if neightbor is in the opposite color, do nothing
 */
public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        //还是要一个queue，generate one node， expand two node；
        //key为graph node, value为该节点所属的分组
        HashMap<GraphNode, Integer> visited = new HashMap<>();

        //发现这里不能写queue.offer（graph）得换个思路；
        for (GraphNode node : graph
        ) {

            if (!BFS(node, visited)) {
                return false;
            }

        }
        return true;// else 整个for 都是已经visited了
    }

    /**
     * @param node
     * @param visited
     * @return
     */
    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        //这些node还没有被visited，我们把它assign 到任何一个group里面，比如group -1；
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            //expand1，generate 2，0
            GraphNode cur = queue.poll();
            // the group assigned for cur node
            int curGroup = visited.get(cur);
            int neiGroup = curGroup == 0 ? 1 : 0;//意味着，curGroup如果是group0，那么neighborsGropu就应该是group1，必须是对立色
            for (GraphNode nei : cur.neighbors) {
//                System.out.println(visited);
                for(GraphNode key: visited.keySet()){

                    System.out.println("key = " + key + ", neighbors =" + key.neighbors);
                    System.out.println("value = " + visited.get(key));

                }
                //重写graphnode 的toString方法；
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Bipartite sol = new Bipartite();

        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(0);

//        GraphNode n1 = new GraphNode(0);
//        GraphNode n2 = new GraphNode(1);
//        GraphNode n3 = new GraphNode(2);
//        GraphNode n4 = new GraphNode(3);


        n1.neighbors.add(n2);
        n2.neighbors.add(n3);
        n3.neighbors.add(n4);
        n4.neighbors.add(n5);
        n5.neighbors.add(n1);


        List<GraphNode> graph = new LinkedList<>();
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        graph.add(n4);
        graph.add(n5);


        System.out.println(sol.isBipartite(graph));
    }
}
