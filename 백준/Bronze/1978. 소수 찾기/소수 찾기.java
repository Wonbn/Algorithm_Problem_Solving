import java.util.Scanner;

public class Main {
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) is_prime(sc.nextInt());

        System.out.println(result);
    }

    public static void is_prime(int number) {
        // 0, 1 은 소수가 아니다
        if(number < 2) return;
        // 2 는 소수다
        if(number == 2) {
            result++;
            return;
        }
        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(number); i++) {
            // 소수가 아닐경우
            if(number % i == 0) return;
        }
        // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
        result++;
    }
}