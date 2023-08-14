import java.util.Scanner;

public class Main {
    static int n;
    static int[] stair;
    static int[] score;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        stair = new int[301];
        score = new int[301];
        for (int i = 1; i <= n; i++) stair[i] = sc.nextInt();

        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        score[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int i = 4; i <= n; i++) {
            score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
        }

        System.out.println(score[n]);
    }
}