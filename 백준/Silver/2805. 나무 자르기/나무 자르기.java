import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 나무 벌목 -> 절단기 사용법 (나무 n그루 , 필요한 나무 길이 m)
        // 높이 H 지정 - 한 줄에 연속해 있는 나무 모두 절단
        // H 보다 높이가 높은 나무의 윗부분이 잘린다. (낮은 잘리지 않는다.)
        // 잘린 나무 윗부분을 모두 가지고 갈 수 있다.

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long tree[] = new long[n]; long max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(max < tree[i]) max = tree[i];
        }

        long res = binary_search(tree, max, m);
        System.out.println(res);
    }

    // 이분분할탐색을 통해서 나무를 자르고 남은 높이의 나무의 길이를
    // 필요한 나무 길이와 비교하여 탐색해나간다.
    public static long binary_search(long t[], long max, long m) {
        long min = 0; long mid; long height;
        while(min <= max) {
            height = 0;
            mid = (max + min)/2;
            for(long a : t) height += ((a-mid > 0)? (a-mid):0);
            if(height < m) max = mid - 1;
            else min = mid + 1;
        }

        return (max+min)/2;
    }
}