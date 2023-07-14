import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // n kg의 설탕을 배달한다. 설탕은 3kg, 5kg 두 가지 봉지를 이용해서 가져갈 수 있다.
        // 같은 kg의 설탕을 가장 적은 봉지로 들고 가야한다.
        // 따라서 무조건 5kg 봉지를 최대한 많이 가져가는 것이 이득이다.

        int count = n/5; int tmp;
        while(true) { // 5kg 봉지의 최대 갯수 찾는 알고리즘
            if(count == -1) break;
            tmp = n - count*5;
            if(tmp % 3 == 0) {
                count += tmp/3;
                break;
            }
            count--;
        }

        System.out.println(count);
    }
}