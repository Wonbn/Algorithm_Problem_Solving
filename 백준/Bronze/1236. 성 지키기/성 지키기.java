import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        int n = sc.nextInt(); // 세로 크기
        int m = sc.nextInt(); // 가로 크기

        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++) {
            String tmp = sc.next();
            for(int j = 0; j < m; j++) arr[i][j] = tmp.charAt(j);
        }

        int[] narr = new int[n]; // 세로축 경비원 수
        int ncount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 'X') narr[i]++;
            }
            if(narr[i] == 0) ncount++;
        }
        int[] marr = new int[m]; // 가로축 경비원 수
        int mcount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[j][i] == 'X') marr[i]++;
            }
            if(marr[i] == 0) mcount++;
        }

        result = Math.max(mcount, ncount);
        System.out.println(result);
    }
}
