import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 문제는 n! 이 주어졌을때, 뒤에서부터 연속된 0의 갯수를 구하는 문제이다.
        // 하지만 n 은 500까지 있기 때문에 500!은 수가 너무도 크다.
        // 이 문제를 다른 시각으로 본다면 n! 까지 등장하는 10의 갯수로 볼 수 있다.
        // 따라서 등장하는 수의 약수 중 2와 5의 갯수 중 최소값이 답이 된다.

        int[] twoFive = new int[2]; // 2와 5의 갯수를 넣어둘 배열

        // 입력된 숫자 n까지 곱한 수가 약수로 포함하는 2와 5의 갯수를 구하는 반복문
        for(int i = 2; i <= n; i++) {
            int tmp = i;
            while(true) { // 2의 갯수
                if(tmp % 2 == 0) {
                    twoFive[0]++;
                    tmp /= 2;
                } else break;
            }
            while(true) { // 5의 갯수
                if(tmp % 5 == 0) {
                    twoFive[1]++;
                    tmp /= 5;
                } else break;
            }
        }

        System.out.println(Math.min(twoFive[0], twoFive[1]));
    }
}