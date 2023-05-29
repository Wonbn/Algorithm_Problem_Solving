import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] num = new int[1000001];
        for(int i = 1; i < 1000000; i++) {
            int tmp = i;
            int cte = tmp;
            while(tmp > 0) {
                cte += tmp%10;
                tmp /= 10;
            }
            if(cte <= 1000000 && num[cte] == 0) num[cte] = i;
        }
        System.out.println(num[n]);
    }
}