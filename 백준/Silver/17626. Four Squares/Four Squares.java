import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[50001];
        Arrays.fill(num, 5);
        num[0] = 0;
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i <= 50000; i++) {
            int a = (int) Math.sqrt(i);
            for (int j = a; j >= a / 2; j--) {
                num[i] = Math.min(num[i], num[i - j * j] + 1);
            }
        }

        int n = sc.nextInt();
        System.out.println(num[n]);
    }
}