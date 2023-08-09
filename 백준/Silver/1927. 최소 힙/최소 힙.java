import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 최소 힙은 우선순위 큐를 이용해서 만들 수 있다.
        // 말 그대로 최소를 구할 수 있는 자료구조이다. 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 우선순위 큐에 넣어주고 그냥 빼주면 된다.
        // 그러면 큐에서 poll을 하면 큐 내에서 가장 작은 값이 반환된다.
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int in = Integer.parseInt(br.readLine());
            if(in == 0) {
                if(minHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(minHeap.poll()).append("\n");
                }
            } else {
                minHeap.add(in);
            }
        }

        System.out.println(sb);
    }
}