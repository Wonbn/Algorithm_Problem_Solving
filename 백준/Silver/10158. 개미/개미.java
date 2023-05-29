import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int t = sc.nextInt();
        int m = w - x;
        int n = h - y;

        if (Math.min(m, n) >= t) System.out.printf("%d %d", x + t, y + t);
        else if (Math.max(m, n) >= t) {
            if (m < n) {
                t -= m;
                x = ((t / w) % 2 == 0) ? w - (t % w) : t % w;
                y += t;
            } else {
                t -= n;
                y = ((t / h) % 2 == 0) ? h - (t % h) : t % h;
                x += t;
            }
            System.out.printf("%d %d", x, y);
        } else {
            int tmp = t - m;
            x = ((tmp / w) % 2 == 0) ? w - (tmp % w) : tmp % w;
            tmp = t - n;
            y = ((tmp / h) % 2 == 0) ? h - (tmp % h) : tmp % h;
            System.out.printf("%d %d", x, y);
        }
    }
}
