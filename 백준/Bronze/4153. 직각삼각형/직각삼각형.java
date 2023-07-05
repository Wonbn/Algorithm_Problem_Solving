import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a; int b; int c;

        while(true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0) break;

            if(a*a + b*b == c*c || c*c + b*b == a*a || a*a + c*c == b*b) System.out.println("right");
            else System.out.println("wrong");
        }

        br.close();
    }
}