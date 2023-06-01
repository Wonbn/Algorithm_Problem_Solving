import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 그리디 알고리즘
// 활동 선택 문제 -> 하나의 활동에 대해서만 작업할 때, 최대한 많은 활동을 할 수 있게 선택하는 문제
public class Main {
    public static void main(String[] args) throws IOException {
        // 이 문제는 한 회의실에 최대한 많은 회의를 넣어야 한다.
        // 알고리즘의 원리는 회의가 끝나는 시간이 최대한 짧은 시간을 선택해 나가는 것이다.
        // 회의가 빨리 끝난다면 다음 회의를 선택할 때, 선택할 수 있는 회의가 많아지기 때문이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 회의의 시작시간과 종료시간을 저장한다.
        int time[][] = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료시간을 기준으로 오름차순으로 정렬한다.
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        // 정렬된 시간 배열에서 현재 회의의 종료시간과 다음 회의의 시작시간을 비교한다.
        int res = 0; int endtime = 0;
        for(int i = 0; i < n; i++) {
            if(endtime <= time[i][0]) {
                endtime = time[i][1];
                res++;
            }
        }

        System.out.println(res);
    }
}