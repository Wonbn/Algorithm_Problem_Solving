import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] A;
    static int[][] cloud1; // 구름이 있었던 칸
    static int[][] cloud2; // 구름이 있는 칸
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        A = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) A[i][j] = stoi(st.nextToken());
        }

        // 초기 구름 생성
        cloud1 = new int[N][N];
        cloud1[N-1][0] = 1;
        cloud1[N-1][1] = 1;
        cloud1[N-2][0] = 1;
        cloud1[N-2][1] = 1;

        // 구름 이동 M번 명령
        cloud2 = new int[N][N];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = stoi(st.nextToken()); // 이동 방향
            int s = stoi(st.nextToken()); // 이동 거리
            int[] idx;

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(cloud1[j][k] == 1) {
                        idx = move(d, s, j, k);
                        cloud2[idx[0]][idx[1]] = 1;
                    }
                }
            }

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(cloud2[j][k] == 1) waterIncrease(j, k);
                }
            }

            cloudCreated();

            for(int j = 0; j < N; j++) // cloud2의 값을 cloud1으로 복사
                System.arraycopy(cloud2[j], 0, cloud1[j], 0, N);
            for(int j = 0; j < N; j++) // cloud2 초기화
                Arrays.fill(cloud2[j], 0);
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) result += A[i][j];
        }

        System.out.println(result);

    }
    
    // 입력된 숫자에 따른 구름 이동 후 이동한 자리의 index 반환
    public static int[] move(int d, int s, int r, int c) {
        int[] idx = new int[] {r, c};
        switch (d) {
            case 1 : idx[1] = (idx[1]-s+N*30)%N; break;
            case 2 : idx[1] = (idx[1]-s+N*30)%N; idx[0] = (idx[0]-s+N*30)%N;break;
            case 3 : idx[0] = (idx[0]-s+N*30)%N;break;
            case 4 : idx[1] = (idx[1]+s)%N; idx[0] = (idx[0]-s+N*30)%N;break;
            case 5 : idx[1] = (idx[1]+s)%N;break;
            case 6 : idx[1] = (idx[1]+s)%N; idx[0] = (idx[0]+s)%N;break;
            case 7 : idx[0] = (idx[0]+s)%N;break;
            case 8 : idx[1] = (idx[1]-s+N*30)%N; idx[0] = (idx[0]+s)%N;break;
        }
        A[idx[0]][idx[1]]++;
        return idx;
    }

    // 위치가 들어오면 규칙에 맞게 물의 양 증가 (대각선 물이 존재하는 칸 수만큼 증가)
    public static void waterIncrease(int r, int c) {
        if(0 <= r-1 && 0 <= c-1 && A[r-1][c-1] > 0) A[r][c]++;
        if(N > r+1 && 0 <= c-1 && A[r+1][c-1] > 0) A[r][c]++;
        if(N > r+1 && N > c+1 && A[r+1][c+1] > 0) A[r][c]++;
        if(0 <= r-1 && N > c+1 && A[r-1][c+1] > 0) A[r][c]++;
    }

    // cloud 함수를 이용해서 구름 생성
    public static void cloudCreated() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(A[i][j] >= 2 && cloud2[i][j] == 0) {
                    cloud2[i][j] = 1;
                    A[i][j] -= 2;
                } else if(cloud2[i][j] == 1)
                    cloud2[i][j] = 0;
            }
        }
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}