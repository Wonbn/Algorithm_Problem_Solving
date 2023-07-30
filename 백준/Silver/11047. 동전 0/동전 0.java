import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n];
        for(int i = 0; i < n; i++) coin[i] = sc.nextInt();

        int result = 0;
        for(int i = n-1; i >= 0; i--) {
            result += k/coin[i];
            k %= coin[i];
            if(k == 0) break;
        }

        System.out.println(result);
    }
}