import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String tmp = sc.nextLine();
        String[] serial = new String[N];
        for(int i = 0; i < N; i++) serial[i] = sc.nextLine();

        for(int i = 0; i < N-1; i++)
            for(int j = 0; j < N-1-i; j++) comp(serial, j);

        for(int i = 0; i < N; i++) System.out.println(serial[i]);
    }

    public static void comp(String[] arr, int idx) {
        String tmp;
        int[] c = new int[2];
        for(int i = 0; i <= 1; i++) {
            for(int j = 0; j < arr[i+idx].length(); j++) {
                if(arr[i+idx].charAt(j) >= '0' && arr[i+idx].charAt(j) <= '9')
                    c[i] += (arr[i+idx].charAt(j) -'0');
            }
        }
        if (arr[idx].length() > arr[idx+1].length()) {
            tmp = arr[idx];
            arr[idx] = arr[idx+1];
            arr[idx+1] = tmp;
        }
        if (arr[idx].length() == arr[idx+1].length()) {
            if(c[0] > c[1]) {
                tmp = arr[idx];
                arr[idx] = arr[idx+1];
                arr[idx+1] = tmp;
            }
            if(c[0] == c[1]) {
                for(int i = 0; i < arr[idx].length(); i++) {
                    if(arr[idx].charAt(i) < arr[idx+1].charAt(i)) break;
                    if(arr[idx].charAt(i) > arr[idx+1].charAt(i)) {
                        tmp = arr[idx];
                        arr[idx] = arr[idx+1];
                        arr[idx+1] = tmp;
                        break;
                    }
                }
            }
        }
    }
}