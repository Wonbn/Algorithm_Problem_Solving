import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] count = new int[1000001];
        for(int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if(i % 3 == 0) min = Math.min(count[i/3], min);
            if(i % 2 == 0) min = Math.min(count[i/2], min);
            min = Math.min(count[i-1], min);

            count[i] = min + 1;
        }

        System.out.println(count[n]);
    }
}