import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0; // 쌍의 갯수
        int n = sc.nextInt();
        int[] arr = new int[2000001]; // 이백만개의 숫자자리를 미리 마련
        for(int i = 0; i < n; i++) arr[sc.nextInt()]++;
        // 수열에 나온 숫자는 1로 바꾼다.
        int x = sc.nextInt();

        for(int i = 1; i < x; i++) {
            if(arr[i] == 1 && arr[x-i] == 1 && (i != x-i)) {
                arr[i] = 0;
                arr[x-i] = 0;
                count++;
            }
        } // 더해서 x 가 돼야 하기 때문에 자신의 숫자와 맨 뒤에서 자신의 숫자를 뺸 값이 모두 있어야 한다.

        System.out.println(count);
    }
}