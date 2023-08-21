import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Friend {
    int cost;
    List<Integer> connect = new ArrayList<>();
}

public class Main {
    static int N, M, k;
    static Friend[] friends;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        friends = new Friend[N+1];
        for (int i = 1; i <= N; i++) {
            friends[i] = new Friend();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friends[i].cost = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            friends[f1].connect.add(f2);
            friends[f2].connect.add(f1);
        }

        int sum = 0;
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                sum += bfs(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                System.out.println("Oh no");
                break;
            }
        }

        if(sum > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }
    }

    private static int bfs(int idx) {
        int minCost = 10001;
        Queue<Friend> q = new LinkedList<>();
        q.add(friends[idx]);
        visited[idx] = true;

        while (!q.isEmpty()) {
            Friend friend = q.poll();
            minCost = Math.min(minCost, friend.cost);

            for (int i = 0; i < friend.connect.size(); i++) {
                int f = friend.connect.get(i);
                if (!visited[f]) {
                    visited[f] = true;
                    q.add(friends[f]);
                }
            }
        }

        return minCost;
    }
}