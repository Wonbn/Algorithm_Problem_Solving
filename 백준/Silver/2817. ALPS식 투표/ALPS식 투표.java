import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        Map<Character, Integer> staff = new HashMap<>();

        // 스태프 이름과 스태프의 득표수를 따로 배열에 저장한다.
        char[] key = new char[N];
        Integer[] value = new Integer[N];
        for(int i = 0; i < N; i++) {
            char tmp = sc.next().charAt(0);
            int ntmp = sc.nextInt();
            if((double)ntmp/(double)X >= 0.05) {
                key[i] = tmp;
                value[i] = ntmp;
            } else {
                key[i] = '1';
                value[i] = 0;
            }
        }

        // 득표수 중에 최대값을 찾고, 최대값을 가진 스태프에게 chip을 준다.
        int[] chip = new int[N];
        int[] h = new int[N];
        for(int i = 0; i < N; i++) h[i] = 1;
        for(int c = 1; c <= 14; c++) {
            int max = 0;
            for(int i = 0; i < N; i++) {
                int vh = value[i]/h[i];
                if(max < vh) max = vh;
            }
            for(int i = 0; i < N; i++) {
                if(max == value[i]/h[i]) {
                    chip[i]++;
                    h[i]++;
                    break;
                }
            }
        }

        for(char cr = 'A'; cr <= 'Z'; cr++) {
            for(int i = 0; i < N; i++) {
                if(key[i] == cr) System.out.printf("%c %d\n", key[i], chip[i]);
            }
        }
    }
}