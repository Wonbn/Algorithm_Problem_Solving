import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if (queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            } else queue.add(x);
        }
    }
}