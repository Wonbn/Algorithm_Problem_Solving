import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static boolean[] visited;
    static List<Integer>[] nodes;
    static List<Integer>[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        result = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            result[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        nodes = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            nodes[num1].add(num2);
            nodes[num2].add(num1);
        }

        for (int i = 0; i <= N; i++) Collections.sort(nodes[i]);

        dfs(V);

        visited = new boolean[N+1]; // 방문여부 초기화

        bfs(V);

        printResult();
    }

    private static void dfs(int v) {
        visited[v] = true;
        result[0].add(v);

        for (int n : nodes[v]) {
            if(!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        result[1].add(v);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int n : nodes[now]) {
                if(!visited[n]) {
                    visited[n] = true;
                    result[1].add(n);
                    q.add(n);
                }
            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result[0].size(); i++) { // dfs 출력
            if(i != 0) sb.append(' ');
            sb.append(result[0].get(i));
        }
        sb.append('\n');
        for (int i = 0; i < result[1].size(); i++) {  // bfs 출력
            if(i != 0) sb.append(' ');
            sb.append(result[1].get(i));
        }

        System.out.println(sb);
    }
}