import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        long[] p = new long[101];
        p[1] = 1;
        p[2] = 1;
        for(int i = 3; i <= 100; i++) p[i] = p[i-2] + p[i-3];

        while(t-- != 0) System.out.println(p[sc.nextInt()]);
    }
}