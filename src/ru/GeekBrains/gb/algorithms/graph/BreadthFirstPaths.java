package ru.GeekBrains.gb.algorithms.graph;

import java.util.LinkedList;

public class BreadthFirstPaths extends Paths {

    public BreadthFirstPaths(Graph g, int source) {
        super(g, source);
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.removeLast();
            for (int w : g.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    queue.addFirst(w);
                }
            }
        }
    }
}