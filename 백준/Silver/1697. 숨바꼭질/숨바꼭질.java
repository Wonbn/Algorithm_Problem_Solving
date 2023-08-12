import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] time;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        time = new int[200001];
        visited = new boolean[200001];

        bfs();

        System.out.println(time[k]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while(!q.isEmpty()) {
            int pos = q.poll();

            if(pos-1 >= 0 && !visited[pos-1]) {
                q.add(pos-1);
                visited[pos-1] = true;
                time[pos-1] = time[pos] + 1;
            }
            if(pos+1 <= 200000 && !visited[pos+1]) {
                q.add(pos+1);
                visited[pos+1] = true;
                time[pos+1] = time[pos] + 1;
            }
            if(2*pos <= 200000 && !visited[2*pos]) {
                q.add(2*pos);
                visited[2*pos] = true;
                time[2*pos] = time[pos] + 1;
            }

            if(visited[k]) {
                return;
            }
        }
    }
}