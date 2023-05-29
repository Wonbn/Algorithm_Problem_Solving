import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = n;
        int count = 0; // 사이클 수
        while(true) {
            int tmp = h;
            int right = tmp%10;
            h = 0; // h 는 계속 바뀌는 수
            while(tmp > 0) {
                h += tmp%10;
                tmp /= 10;
            }
             h = h%10 + 10*right;
            count++;
            if(h == n) break;
        }
        System.out.println(count);
    }
}