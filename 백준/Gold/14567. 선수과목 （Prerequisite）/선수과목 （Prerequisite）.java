import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] preSubjects;
    static int[] count, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        preSubjects = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            preSubjects[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            preSubjects[s2].add(s1);
            count[s2]++;
        }

        result = new int[N + 1];
        topological();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(i != 1) sb.append(" ");
            sb.append(result[i]);
        }
        System.out.println(sb);
    }

    private static void topological() {
        for (int i = 1; i <= N; i++) {
            if (preSubjects[i].isEmpty()) {
                result[i] = 1;
                continue;
            }
            for(int s : preSubjects[i]) {
                result[i] = Math.max(result[i], result[s] + 1);
            }
        }
    }
}