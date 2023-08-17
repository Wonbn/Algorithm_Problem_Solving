import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class City {
    int end;
    int weight;

    public City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static int N, M;
    static List<City>[] connect;
    static long[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        connect = new ArrayList[N + 1];
        dist = new long[N + 1];
        for (int i = 1; i <= N; i++) { // 필요한 배열 초기화
            connect[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) { // 입력된 출발값 / 도착값과 가중치 저장
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            connect[A].add(new City(B, C));
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean bellmanFord() {
        dist[1] = 0; // 시작점은 0으로 초기화.
        boolean update = false;

        // (N - 1)번 동안 최단거리 초기화 작업을 반복함.
        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (City city : connect[j]) {
                    // 탐색할 도시가 갈 수 없는 도시일때, 탐색 종료
                    if (dist[j] == INF) break;
                    
                    // 현재 도시의 인접 도시들 간의 거리 비교 및 최단거리 최신화
                    if (dist[city.end] > dist[j] + city.weight) {
                        dist[city.end] = dist[j] + city.weight;
                        update = true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 탐색 종료
            if (!update) {
                break;
            }
        }

        // (N - 1)번까지 계속 업데이트가 발생했을 경우
        // N 번째에도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (City city : connect[i]) {
                    if (dist[i] == INF) {
                        break;
                    }

                    if (dist[city.end] > dist[i] + city.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}