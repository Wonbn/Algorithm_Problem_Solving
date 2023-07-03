import java.util.Scanner;

// 동전의 순서는 상관이 없기 때문에 각 종류별 동전의 갯수로 판단
// 각 종류별 동전의 갯수가 같다면 같은 경우의 수
// 제한시간 0.5초이기 때문에 각 경우의 수를 다 찾는 것은 불가능
// 이전의 구한 값을 이용해서 현재 원하는 값 도출

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n]; // 동전의 종류
        for(int i = 0; i < n; i++) coin[i] = sc.nextInt();

        int[] dp = new int[k+1]; // 동전의 합이 index원이 되도록 하는 경우의 수
        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = coin[i]; j <= k; j++) dp[j] = dp[j] + dp[j - coin[i]];
            // 동전의 종류가 1 종류일때, 2 종류일때, 3 종류일때... 반복문을 통해서 늘려나가면서
            // 그 때마다 만들 수 있는 경우의 수를 합쳐나간다.
            // 합쳐나가면서 생각해야할 주요 원리 : 한 종류일때, 구한 경우의 수를 다른 종류의 동전까지 합쳐졌을때,
            // 여러 종류의 동전의 합의 경우의 수를 구하는 것은 만들고 싶은 동전의 합 N이고 기준이 되는 수 A일때,
            // N - A 를 만드는 경우의 수의 총합을 구하는 것과 같다.
        }

        System.out.println(dp[k]);
        sc.close();
    }
}