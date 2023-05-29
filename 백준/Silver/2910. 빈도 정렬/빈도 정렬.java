import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 문제풀이시간 : 1시간 30분 / try 1번 / 메모리 초과 -> C 값이 10억인데 이 10억을 모두 배열로 잡아서 메모리 초과가 났다.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        int[] seq = new int[N]; // 주어진 수열
        for(int i = 0; i < N; i++) seq[i] = sc.nextInt();
        int[][] num = new int[N][2]; // 수열에서 등장하는 숫자들과 등장하는 횟수
        int idx = 0;
        for(int i = 0; i < N; i++) {
            int c = 0;
            for(int j = 0; j < idx; j++) {
                if (seq[i] == num[j][0]) {
                    num[j][1]++; c++;
                    break;
                }
            }
            if(c == 0) {
                num[idx][0] = seq[i];
                num[idx][1]++;
                idx++;
            }
        }

        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        for(int i = 0; i < num.length; i++) {
            for(int j = 0; j < num[i][1]; j++) {
                if(i == 0 && j == 0) System.out.printf("%d", num[i][0]);
                else System.out.printf(" %d", num[i][0]);
            }
        }
    }
}