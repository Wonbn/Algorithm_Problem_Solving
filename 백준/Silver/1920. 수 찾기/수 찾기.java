import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int numN[] = new int[n]; // N 개의 정수를 담은 배열
        for(int i = 0; i < n; i++) numN[i] = sc.nextInt();
        Arrays.sort(numN);

        int m = sc.nextInt(); // M 개의 정수가 주어짐
        for(int i = 0; i < m; i++) bnSearch(numN, sc.nextInt());

    }

    // M 개의 정수가 주어졌을때, N 개의 정수가 저장되어 있는 배열에
    // 주어진 숫자가 존재하는지 알아보는 이분 탐색 메서드
    public static void bnSearch(int[] numN, int a) {
        int check = 0;

        int min = 0; int max = numN.length-1;
        int avg;
        // 배열을 반으로 쪼개면서 탐색한다.
        while(true) {
            avg = (max+min)/2;
            if(max == min + 1) {
                if(numN[min] == a || numN[max] == a) check = 1;
                break;
            } else {
                if(numN[avg] < a) min = avg;
                else if(numN[avg] > a) max = avg;
                else {
                    check = 1;
                    break;
                }
            }
        }

        System.out.println(check);
    }
}