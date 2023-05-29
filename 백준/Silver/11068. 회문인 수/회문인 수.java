import java.util.Scanner;

public class Main {
    public static int check(int[] arr, int l) {
        int c = 1;
        for(int i = 0; i < l/2; i++) {
            if(arr[i] != arr[l-i-1]) {
                c = 0;
                break; }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // 100만까지만 주어지기 때문에 자릿수는 20을 넘어가지 않는다.
        while(t-- > 0) {
            int n = sc.nextInt();
            for(int b = 2; b <= 64; b++) {
                int[] arr = new int[20];
                int i = 0;
                int tmp = n;
                while(tmp != 0) {
                    arr[i] = tmp%b;
                    tmp /= b;
                    i++;
                }
                if(check(arr, i) == 1) {
                    System.out.println(1);
                    break; }
                if(b == 64) System.out.println(0);
            }
        }
    }
}