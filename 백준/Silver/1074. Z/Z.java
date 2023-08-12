import java.util.Scanner;

public class Main {
    static int n, r, c, size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        size = (int)Math.pow(2, n);
        int[] startIdx = new int[] {0, 0};
        int[] endIdx = new int[] {size-1, size-1};

        int result = binarySearch(startIdx, endIdx);

        System.out.println(result);
    }

    private static int binarySearch(int[] startIdx, int[] endIdx) {
        int result = 0;
        int[] mid = new int[2];
        while(size != 0) {
            mid[0] = (startIdx[0] + endIdx[0]) / 2;
            mid[1] = (startIdx[1] + endIdx[1]) / 2;

            if(mid[0] < r) {
                result += (size*size)>>1;
                startIdx[0] = mid[0];
            } else endIdx[0] = mid[0];
            if(mid[1] < c) {
                result += (size*size)>>2;
                startIdx[1] = mid[1];
            } else endIdx[1] = mid[1];

            size >>= 1;
        }

        return result;
    }
}