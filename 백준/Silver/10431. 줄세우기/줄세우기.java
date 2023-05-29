import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int[] t = new int[p];
        for(int i = 0; i < p; i++) {
            int count = 0;
            int[] num = new int[21];
            int[] k = new int[22];
            t[i] = sc.nextInt();
            for(int j = 0; j<20; j++) num[j] = sc.nextInt();

            k[0] = num[0];
            for(int j = 1; j < 20; j++) {
                for(int y = 0; y < j; y++) {
                    if(k[y] > num[j]) {
                        for(int u = j-1; u >= y; u--) {
                            k[u+1] = k[u];
                            count++;
                        }
                        k[y] = num[j];
                        break;
                    }
                    k[j] = num[j];
                }
            }
            System.out.printf("%d %d\n", t[i], count);
        }
    }
}
