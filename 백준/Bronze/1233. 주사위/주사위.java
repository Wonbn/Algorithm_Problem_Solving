import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();
        // 3~80까지 합의 개수를 담는 배열

        countsum(s1,s2,s3);
    }

    public static void countsum(int s1, int s2, int s3) {
        int[] cnt = new int[81];
        for (int i = 1; i <= s1; i++)
            for (int j = 1; j <= s2; j++)
                for (int k = 1; k <= s3; k++) cnt[i + j + k]++;
        int max = 0;
        int maxc = 0;
        for (int i = 3; i <= (s1+s2+s3); i++)
            if(maxc < cnt[i]) {
                max = i;
                maxc = cnt[i];
            }
        System.out.println(max);
    }
}