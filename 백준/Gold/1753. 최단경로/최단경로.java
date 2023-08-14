import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node n) {
        return this.w - n.w;
    }
}

public class Main {
    static List[] l; // 노드의 집합
    static int[] dist; // 목표지점까지의 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()); // 시작인덱스

        l = new ArrayList[V+1];
        dist = new int[V+1];

        for (int i = 1; i <= V; i++) {
            l[i] = new ArrayList<Node>(); // i에서 출발하여 도착하는 노드를 모두 저장한다.
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            l[u].add(new Node(v, w)); // 노드 u에 대한 각 간선의 정보를 저장한다.
        }

        dijkstra(K); // 다익스트라 알고리즘에 시작 인덱스를 넣어준다.

        // 가지 못하는 노드는 "INF"를 출력해준다.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    // 우선순위 큐를 이용해서 가장 적은 가중치를 가지는 노드부터 탐색한다.
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 시작 노드부터 시작해서 인접 노드를 탐색하다가 같은 노드가 나오면
            // 가중치가 작은 것을 우선순위 큐에 추가한다.
            int len = l[now.v].size();
            for (int i = 0; i < len; i++) {
                Node next = (Node) l[now.v].get(i);

                if (dist[next.v] > now.w + next.w) {
                    dist[next.v] = now.w + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}