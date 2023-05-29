import java.util.Scanner;

public class Main {

    public static int sum(int a) { return a*(a+1)/2; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int k = sc.nextInt();
            int check = 0;
            for(int i = 1; sum(i) < k; i++) {
                int s = sum(i);
                for(int j = 1; sum(j) < k; j++) {
                    s += sum(j);
                    for(int l = 1; sum(l) < k; l++) {
                        s += sum(l);
                        if(s == k) {
                            check = 1;
                            break; }
                        s -= sum(l);
                    }
                    s -= sum(j);
                }
            }
            System.out.println(check);
        }
    }
}