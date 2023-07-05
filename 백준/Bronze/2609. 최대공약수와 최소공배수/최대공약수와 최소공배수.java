import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = 2;
        int a = sc.nextInt();
        int b = sc.nextInt();

        //최대공약수
        for(int i = Math.min(a,b); i > 0; i--) {
            if(a%i == 0 && b%i == 0) {
                System.out.println(i);
                break;
            }
        }
        // 최소공배수
        int c = Math.max(a,b);
        while(true) {
            if(c%a == 0 && c%b == 0) {
                System.out.println(c);
                break;
            }
            c = a * m++;
        }
    }
}