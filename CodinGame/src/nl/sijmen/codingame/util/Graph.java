package nl.sijmen.codingame.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Graph { // Adjacency list
    private ArrayList<ArrayList<Integer>> neighbours; // at index i: a list of node i's neighbours 
    private int N; // number of nodes
    
    public Graph(int N) {
        this.N = N;
        neighbours = new ArrayList<ArrayList<Integer>>(N);
        for(int i=0; i<N;i++) {
        	neighbours.add(new ArrayList<Integer>());
        }
    }
    
    public void addEdge(int startNode, int endNode) {
        neighbours.get(startNode).add(endNode);
        neighbours.get(endNode).add(startNode);
    }
    public void removeEdge(int startNode, int endNode) {
        neighbours.get( startNode ).remove( (Integer) endNode );
        neighbours.get( endNode ).remove( (Integer) startNode );
    }
    
    public int[] shortestRoute(int startNode, int targetNode) {
        if (neighbours.get(startNode).isEmpty() || neighbours.get(targetNode).isEmpty() ) {
            return new int[0];
        }
        
        int[] prevNode = new int[N]; Arrays.fill(prevNode, -1);
        int[] distance = new int[N]; Arrays.fill(distance, Integer.MAX_VALUE);
        
        Queue<Integer> Q = new ArrayDeque<Integer>();
        Q.add(startNode);
        distance[startNode] = 0;
        
        boolean done = false;
        while (!Q.isEmpty() && !done) {
            int node = (Integer) Q.poll();
            for(int next : neighbours.get(node)) {
                if(distance[next] > distance[node]+1) {
                    distance[next] = distance[node]+1;
                    prevNode[next] = node;
                    Q.add(next);
                }
                if( next == targetNode ) {
                    done = true;
                    break;
                }
            }
        }
        
        // Retrieve route
        int val[] = new int[distance[targetNode]+1];
        int curNode = targetNode;
        for (int i = distance[targetNode]; i >= 0; i--) {
            val[i] = curNode;
            curNode = prevNode[curNode];
        }
        return val;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < neighbours.size(); i++) {
            sb.append("Node " + i + ": ");
            for( int j = 0; j < neighbours.get(i).size(); j++) {
                sb.append(neighbours.get(i).get(j) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}