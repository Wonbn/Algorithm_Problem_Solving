import java.util.Scanner;

public class Main {
    static int[] result = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 1; i <= 10; i++) result[i] = rec_func(i);

        for(int i = 0; i < t; i++) {
            System.out.println(result[sc.nextInt()]);
        }
    }

    public static int rec_func(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int r = rec_func(n-1) + rec_func(n-2) + rec_func(n-3);
        if(n == 3) r++;

        return r;
    }
}