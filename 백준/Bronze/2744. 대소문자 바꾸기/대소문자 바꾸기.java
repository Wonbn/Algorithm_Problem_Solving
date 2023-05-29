import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = 'a' - 'A'; // a값을 더해주면 대문자로, 빼주면 소문자로 변환
        char[] arr = scan.nextLine().toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 'a' && arr[i] <= 'z') arr[i] = (char)(arr[i] - a);
            else arr[i] = (char)(arr[i] + a);
        } // 아스키코드의 차이를 이용해서 대문자와 소문자를 변환

        String result = new String(arr);
        // char 배열을 다시 문자열로 변환

        System.out.println(result);
    }
}