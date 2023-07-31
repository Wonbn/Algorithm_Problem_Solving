import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] count = new int[1000001]; 
        // 입력값 n에 대한 1~n까지의 최소연산횟수를 저장
        for(int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 3으로 나눠지거나 2로 나눠지거나 3,2 둘 모두로 나눠지거나 둘 모두로 나눠지지 않거나
            // 이렇게 4가지 경우의 수를 모두 커버한다.
            if(i % 3 == 0) min = Math.min(count[i/3], min);
            if(i % 2 == 0) min = Math.min(count[i/2], min);
            min = Math.min(count[i-1], min);

            // 그 중 가장 최소연산을 수행하는 경우로 결과를 저장한다.
            count[i] = min + 1;
        }

        System.out.println(count[n]);
    }
}