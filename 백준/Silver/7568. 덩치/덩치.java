import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 몸무게와 키를 입력받아 그것을 "덩치"로 정의하고, 덩치의 등수를 정한다.
        // 덩치의 등수는 자신보다 큰 덩치를 가지고 있는 사람이 있다면 하나씩 내려가는 방식으로 정의할 수 있다.
        // 말하자면 자신보다 큰 덩치를 가진 사람이 2명 있다면 그 사람은 3등이 된다.

        int n = sc.nextInt();

        int[][] xy = new int[n][2];
        for(int i = 0; i < n; i++) {
            xy[i][0] = sc.nextInt();
            xy[i][1] = sc.nextInt();
        }

        // 자신보다 덩치가 큰 사람을 카운트한다.
        int idx = 0;
        while(true) {
            int count = 1;
            for(int i = 0; i < n; i++) {
                if(xy[idx][0] < xy[i][0] && xy[idx][1] < xy[i][1]) count++;
            }
            System.out.print(count);
            if(idx != n-1) System.out.print(" ");
            else break;
            idx++;
        }
    }
}