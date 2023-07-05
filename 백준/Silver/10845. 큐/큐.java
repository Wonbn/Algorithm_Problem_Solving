import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> queue = new LinkedList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) command(br.readLine());
    }

    public static void command(String cmd) {
        st = new StringTokenizer(cmd);
        switch (st.nextToken().charAt(2)) {
            case 's' :
                queue.offer(Integer.parseInt(st.nextToken()));
                return;
            case 'p' :
                if(cmd.length() == 3) {
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.poll());
                } else {
                    if(queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                }
                return;
            case 'z' :
                System.out.println(queue.size());
                return;
            case 'o' :
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.peek());
                return;
            case 'c' :
                if(queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.peekLast());
        }
    }
}