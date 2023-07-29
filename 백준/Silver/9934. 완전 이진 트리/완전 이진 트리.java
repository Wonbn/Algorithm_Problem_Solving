import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[] binaryTree; // 결과값을 저장할 배열
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        binaryTree = new String[k];
        
        // 입력값을 이진트리 순서에 맞게 결과에 저장
        int[] input = new int[expTwo(k)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < expTwo(k); i++) input[i] = Integer.parseInt(st.nextToken());

        binaryTreeCheck(input);

        for(String str : binaryTree) System.out.println(str);
    }

    // 이진 트리의 특성을 고려해서 값의 트리의 위치를 문자열 배열에 넣어준다.
    public static void binaryTreeCheck(int[] arr) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(k != 0) {
            int idx = expTwo(k-1);
            sb.setLength(0);
            while (true) {
                sb.append(arr[idx]+" ");
                idx += expTwo(k);
                if(idx >= arr.length) {
                    binaryTree[i++] = sb.toString();
                    break;
                }
            }
            k--;
        }
    }

    // 2의 지수 곱의 결과값을 반환하는 메서드 (2^n)
    public static int expTwo(int n) {
        int t = 1;
        for(int i = 1; i <= n; i++) t *= 2;
        return t;
    }
}