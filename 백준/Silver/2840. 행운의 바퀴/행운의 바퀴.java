import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 바퀴의 칸수
        int k = sc.nextInt(); // 바퀴를 돌리는 횟수

        int check = 0; // 행운의 바퀴가 있는지 없는지 체크
        int point = 0; // 화살표가 가르키고 있는 문자의 인덱스
        char[] cycle = new char[n];
        int[] alp = new int[26]; // 알파벳을 담는 배열
        Arrays.fill(cycle, '?');
        for(int i = 0; i < k; i++) { // k번 바퀴를 돌림
            int s = sc.nextInt(); // 회전하는 동안 문자가 변한 횟수
            char ch = sc.next().charAt(0); // 칸에 들어있는 문자
            if(cycle[(point + s)%n] == '?') { // 화살표가 가르키고 있는 칸의 문자가 없을때
                if(alp[ch-'A'] == 1) {
                    check = 1;
                    break;
                }
                cycle[(point + s)%n] = ch;
                point = (point + s)%n;
                alp[ch-'A'] = 1;
            } else { // 화살표가 가르키고 있는 칸의 문자가 있을때
                if(cycle[(point + s)%n] != ch) { // 문자가 다를때
                    check = 1;
                    break;
                } else point = (point + s)%n; // 문자가 같을때
            }
        }
        StringBuilder sb = new StringBuilder();
        if(check == 0) {
            for(int i=0;i<n;i++) {
                sb.append(cycle[point]);
                point--;
                if (point < 0) point = n - 1;
            }
            System.out.println(sb);
        } else System.out.println("!");
    }
}