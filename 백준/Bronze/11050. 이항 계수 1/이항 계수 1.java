import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(bc(sc.nextInt(), sc.nextInt()));
    }

    static int bc(int n, int k) {
        if(n == k || k == 0) return 1;

        return bc(n-1, k-1) + bc(n-1, k);
        // 재귀함수와 파스칼의 삼각형 성질을 이용해서 이항계수를 구할 수 있다.
    }
}