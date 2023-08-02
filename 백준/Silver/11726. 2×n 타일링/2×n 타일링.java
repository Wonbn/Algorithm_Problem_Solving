import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 2×n 크기의 직사각형

        int[] result = new int[1001];
        result[1] = 1; result[2] = 2;

        // 2×n 크기의 직사각형을 2×1과 1×2의 직사각형으로 채우는 경우의 수를 구하는 메서드
        for(int i = 3; i <= n; i++)
            result[i] = (result[i-1] + result[i-2]) % 10007;

        System.out.println(result[n]);
    }
}