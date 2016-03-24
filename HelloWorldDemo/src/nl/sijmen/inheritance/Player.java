package nl.sijmen.inheritance;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        
        Graph G = new Graph(N);
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            G.addEdge(N1, N2);
        }
        
        ArrayList<Integer> exits = new ArrayList<>(E);
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            exits.add(EI);
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            int[] route = G.shortestRoute(SI, exits.get(0));
            System.err.print("Route: ");
            for( int i : route) {
                System.err.print(i + " ");
            }

            System.out.println("0 1"); // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }
}

class Graph {
    private ArrayList<ArrayList<Integer>> neighbours;
    private int N;
    
    public Graph(int N) {
        this.N = N;
        System.err.println("N: "+N);
        neighbours = new ArrayList<ArrayList<Integer>>(N);
        for(int i=0; i<N;i++) {
        	neighbours.add(new ArrayList<Integer>());
        }
        
        System.err.println("Size: " + neighbours.size() );
    }
    
    public void addEdge(int startNode, int endNode) {
        System.err.println("addEdge " + startNode +  "-" + endNode);
        neighbours.get(startNode).add(endNode);
        neighbours.get(endNode).add(startNode);
    }
    public void deleteEdge(int startNode, int endNode) {
        neighbours.get(startNode).remove(endNode);
        neighbours.get(endNode).remove(startNode);
    }
    
    public int[] shortestRoute(int startNode, int targetNode) {
        int[] prevNode = new int[N];
        Arrays.fill(prevNode, -1);
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        // previous node ,  distance
        Queue<Integer> Q = new ArrayDeque<Integer>();
        Q.add(startNode);
        
        boolean done = false;
        while (!Q.isEmpty() && !done) {
            int node = (Integer) Q.poll();
            for(int next : neighbours.get(node))
            {
                if(distance[next] > distance[node]+1) {
                    distance[next] = distance[node]+1;
                    prevNode[next] = node;
                }
                if( next == targetNode ) {
                    done = true;
                    break;
                }
            }
        }
        
        int val[] = new int[distance[targetNode]+1];
        int curNode = targetNode;
        for (int i = distance[targetNode]; i >= 0; i--) {
            val[i] = curNode;
            curNode = prevNode[curNode];
        }
        return val;
    }
    
    
}
