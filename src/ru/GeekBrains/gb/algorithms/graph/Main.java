package ru.GeekBrains.gb.algorithms.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0,2);
        graph.addEdge(0,7);
        graph.addEdge(1,9);
        graph.addEdge(2,9);
        graph.addEdge(3,9);
        graph.addEdge(3,8);
        graph.addEdge(4,8);
        graph.addEdge(5,7);
        graph.addEdge(5,6);
        graph.addEdge(6,8);
        graph.addEdge(8,9);

        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph, 1);
        System.out.println(depthFirstPaths.hasPathTo(0));
        System.out.println(depthFirstPaths.pathTo(0));

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
        System.out.println(bfp.hasPathTo(3));
        System.out.println(bfp.pathTo(3));
    }
}
