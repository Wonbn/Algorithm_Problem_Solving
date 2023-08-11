import java.util.*;

class Node {
    List<Integer> nearNodes = new ArrayList<>();
}
public class Main {
    static int n;
    static boolean[] visited;

    static Node[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        nodes = new Node[n+1];
        for (int i = 1; i <= n; i++) { // 클래스 초기화
            nodes[i] = new Node();
        }

        for (int i = 0; i < m; i++) { // 각 노드들의 인접 노드들 저장
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            nodes[num1].nearNodes.add(num2);
            nodes[num2].nearNodes.add(num1);
        }

        // bfs를 이용해서 모든 노드들을 순회하면서 방문했는지 여부를 체크하면서
        // 연결 요소에 갯수를 카운트한다.
        int count = 0;
        visited = new boolean[n + 1];
        while (checkAllVisited() != 0) {
            bfs(checkAllVisited());
            count++;
        }

        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            for(int i = 0; i < nodes[node].nearNodes.size(); i++) {
                if(!visited[nodes[node].nearNodes.get(i)]) {
                    q.add(nodes[node].nearNodes.get(i));
                    visited[nodes[node].nearNodes.get(i)] = true;
                }
            }
        }

    }

    private static int checkAllVisited() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return 0;
    }
}