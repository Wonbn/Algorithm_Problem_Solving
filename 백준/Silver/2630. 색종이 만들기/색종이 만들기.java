import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int checkColor;   // 기준 색깔
    static int[] colorCount = new int[2]; // 0,1 인덱스를 이용해서 색깔 갯수 저장
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        square = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) square[i][j] = Integer.parseInt(st.nextToken());
        }

        solve(0, n-1,0, n-1);
        System.out.println(colorCount[0]+"\n"+colorCount[1]);
    }

    // 재귀함수를 이용한 분할 정복 메서드
    public static void solve(int xStart, int xEnd, int yStart, int yEnd) {
        checkColor = square[yStart][xStart];
        
        // 1X1 정사각형이 됐을때, 분할 중지
        if(xStart == xEnd && yStart == yEnd) { 
            colorCount[checkColor]++;
            return;
        }

        // 정사각형이 모두 같은 색이라면 분할 중지
        if(checkSame(xStart, xEnd, yStart, yEnd)) return;

        int xMid = (xStart + xEnd) / 2;
        int yMid = (yStart + yEnd) / 2;

        solve(xStart, xMid, yStart, yMid);                   // 1번 사격형
        solve(xMid+1, xEnd, yStart, yMid);            // 2번 사격형
        solve(xStart, xMid, yMid+1, yEnd);            // 3번 사격형
        solve(xMid+1, xEnd, yMid+1, yEnd);     // 4번 사격형
    }

    // 현재 정사각형이 모두 같은 색인지 판단하는 메서드
    public static boolean checkSame(int xs, int xe, int ys, int ye) {
        for(int i = ys; i <= ye; i++) {
            for(int j = xs; j <= xe; j++) {
                if(checkColor != square[i][j]) return false;
            }
        }
        colorCount[checkColor]++;
        return true;
    }
}