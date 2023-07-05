import java.util.Scanner;

// 문제는 입력받은 숫자 n 까지의 최소거리를 구하는 것이다.
// 하지만, 이 문제는 결국 숫자 n 이 몇번째 껍질에 있는지 알아내면 되는 문제이다.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = 0; int i = 1;
        int result = 1;
        while(true) {
            if(n <= i) {
                System.out.println(result);
                break;
            }
            i += (a += 6);
            result++;
        }
    }
}