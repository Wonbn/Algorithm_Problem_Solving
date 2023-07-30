import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n];
        for(int i = 0; i < n; i++) p[i] = sc.nextInt();
        Arrays.sort(p);

        long result = 0;
        for(int i = 1; i < n; i++) p[i] += p[i-1];
        for(int i = 0; i < n; i++) result += p[i];

        System.out.println(result);
    }
}