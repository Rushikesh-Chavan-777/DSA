import java.util.*;
import java.util.Queue;

public class Graphs {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
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
    static void bfs(ArrayList<Edge> graph[], int V, boolean visited[], int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(visited[curr] == false) {
                //{1}print it {2}make it true {3}add neighbours
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        /*
1 --- 3
/ | \
0 | 5 -- 6

\ | /
2 ---- 4
*/

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);


        boolean visited[] = new boolean[V];

        for(int j = 0; j < V; j++) {
            if(visited[j] == false) {
                bfs(graph, V, visited, j);
            }
        }

    }
}
