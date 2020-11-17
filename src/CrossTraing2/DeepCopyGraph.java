package CrossTraing2;


import java.util.*;

public class DeepCopyGraph {
    static class GraphNode {
        public int key;
        public List<GraphNode> neighbors;

        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }

    //BFS1 的方式去拷贝
    public List<GraphNode> copy(List<GraphNode> graph) {
        if (graph == null) {
            return null;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        HashMap<GraphNode, GraphNode> lookup = new HashMap<>();

        //构建新图和旧图node的映射关系
        for (GraphNode head : graph
        ) {
            queue.offer(head);
            lookup.put(head, new GraphNode(head.key));
        }

        //复制边
        while (!queue.isEmpty()) {
            //当前处理结点
            GraphNode expand = queue.poll();
            //不知道如何表达generate n1 的邻居n2
            //复制当前节点的邻边
            for (GraphNode generate : expand.neighbors) {
                if (!lookup.containsKey(generate)) {
                    GraphNode newNode = new GraphNode(generate.key);
                    lookup.put(generate, newNode);
                    if (!queue.contains(generate)) {
                        queue.offer(generate);
                    }
                }
                GraphNode copyNode = lookup.get(expand);
                if (copyNode.neighbors == null) {
                    copyNode.neighbors = new ArrayList<>();
                }
                //复制边的关系
                copyNode.neighbors.add(lookup.get(generate));
            }
//            queue.offer(expand.neighbors);
//            if (!lookup.containsKey(generate)){
//                GraphNode newGraph = new GraphNode(graph.key);
//                lookup.put(graph, newGraph);
//                queue.push(generate);
//            }
            // 不会表示 N1'.neighbors.add(N2')

        }
        return new ArrayList<GraphNode>(lookup.values());

    }

    //BFS1 的方式去拷贝,去掉一些不必要的条件
    public List<GraphNode> copyBFS1(List<GraphNode> graph) {

        if (graph == null) {
            return null;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        HashMap<GraphNode, GraphNode> lookup = new HashMap<>();

        //构建新图和旧图node的映射关系
        for (GraphNode head : graph
        ) {
            queue.offer(head);
            lookup.put(head, new GraphNode(head.key));
        }

        //复制边
        while (!queue.isEmpty()) {
            //当前处理结点
            GraphNode expand = queue.poll();
            //不知道如何表达generate n1 的邻居n2
            //复制当前节点的邻边
            for (GraphNode generate : expand.neighbors) {
                // if (!lookup.containsKey(generate)) {
                //     GraphNode newNode = new GraphNode(generate.key);
                //     lookup.put(generate, newNode);
                //     if (!queue.contains(generate)) {
                //         queue.offer(generate);
                //     }
                // }
                GraphNode copyNode=lookup.get(expand);
                // if(copyNode.neighbors==null){
                //     copyNode.neighbors=new ArrayList<>();
                // }
                //复制边的关系
                copyNode.neighbors.add(lookup.get(generate));
            }

        }
        return new ArrayList<GraphNode>(lookup.values());
    }

    //DFS 的方式去拷贝
    public List<GraphNode> copyDFS(List<GraphNode> graph) {
        if (graph == null) {
            return null;
        }
        Map<GraphNode, GraphNode> lookup = new HashMap<GraphNode, GraphNode>();
        for (GraphNode input : graph) {
            if (!lookup.containsKey(input)) {
                lookup.put(input, new GraphNode(input.key));
                DFS(input, lookup);
            }
        }
        return new ArrayList<GraphNode>(lookup.values());
    }

    private GraphNode DFS(GraphNode input, Map<GraphNode, GraphNode> lookup) {
        // GraphNode copyNode = new GraphNode(input.key);
        // lookup.put(input, copyNode);
        GraphNode copyNode = lookup.get(input);// why didn't check copynode 是不是在lookuptable 里面；
        for (GraphNode neighbor : input.neighbors) {
            if (!lookup.containsKey(neighbor)) {
                lookup.put(neighbor, new GraphNode(neighbor.key));
                DFS(neighbor, lookup);
            }
            copyNode.neighbors.add(lookup.get(neighbor));
        }
        return copyNode;
    }


    public static void main(String[] args) {
        DeepCopyGraph sol = new DeepCopyGraph();
        //建立结点
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        //建立关联关系
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node3);

        List<GraphNode> graph = new ArrayList<>();
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        sol.copyDFS(graph);


    }
}