import java.util.*;
import java.util.Queue;

public class BFS_Graphs {


    static class Edge {
        int src;
        int dst;
        int wgt;
        Edge(int src, int dst, int wgt) {
            this.src = src;
            this.wgt = wgt;
            this.dst = dst;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));
    }
    public static void bfs(ArrayList<Edge> graph[], int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        q.add(0);
        while(!q.isEmpty()) {
            int curr = q.remove();
            //1: print the curr node 2: set visited to true 3: run a for loop and get into the breadth of the graph array
            if(visited[curr] == false) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean visited[], int curr) {
        //here we try to go in depth of the tree, so we recursively print one node rather than adding in a q the neighbors
        if(visited[curr] == true) {
            return;
        }
        System.out.print(curr + " ");
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            dfs(graph, visited, e.dst);
        }
    }




    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph, V);
        System.out.println();
        boolean visited[] = new boolean[V];
        dfs(graph, visited, 0);


    }
}
