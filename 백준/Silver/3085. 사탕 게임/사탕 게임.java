import java.util.Scanner;

public class Main {
    public static void change(char[][] bd, int i, int j, int t) {
        int n = bd.length;
        char tmp;

        tmp = bd[i][j];
        if(t == 0 && i < n-1) { // 위
            bd[i][j] = bd[i+1][j];
            bd[i+1][j] = tmp;
        } if(t == 1 && i > 0) { // 아래
            bd[i][j] = bd[i-1][j];
            bd[i-1][j] = tmp;
        } if(t == 2 && j < n-1) { // 오
            bd[i][j] = bd[i][j+1];
            bd[i][j+1] = tmp;
        } if(t == 3 && j > 0) { // 왼
            bd[i][j] = bd[i][j-1];
            bd[i][j-1] = tmp;
        }
    }

    public static int check(char[][] bd) {
        int max = 0; int count;
        char p;

        for(int i = 0; i < bd.length; i++) {
            p = bd[i][0];
            count = 1;
            for(int j = 1; j < bd.length; j++) {
                if(p == bd[i][j]) count++;
                else {
                    if(max < count) max = count;
                    p = bd[i][j];
                    count = 1;
                }
                if(max < count) max = count;
            }
        }
        count = 1;
        for(int i = 0; i < bd.length; i++) {
            p = bd[0][i];
            count = 1;
            for(int j = 1; j < bd.length; j++) {
                if(p == bd[j][i]) count++;
                else {
                    if(max < count) max = count;
                    p = bd[j][i];
                    count = 1;
                }
                if(max < count) max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int N = sc.nextInt();
        String tmp = sc.nextLine();
        char[][] board = new char[N][N];
        for(int i = 0; i < N; i++) board[i] = sc.nextLine().toCharArray();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int t = 0; t < 4; t++) {
                    change(board, i, j, t);
                    if(max < check(board)) max = check(board);
                    change(board, i, j, t);
                }
            }
        }

        System.out.println(max);
    }
}