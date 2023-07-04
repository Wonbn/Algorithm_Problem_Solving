import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// n명의 사람들이 원을 만들고 그 원에서 k 번째 사람을 계속해서 제거해나간다.
// 제거된 사람을 순서대로 List를 만들면 그것을 (n,k) - 요세푸스 순열이라고 한다.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n명의 사람 (1번 ~ n번)
        int k = sc.nextInt(); // k번째의 사람 제거

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(i);

        int check = 0; int idx = 0;
        System.out.print("<");
        while(list.size() != 0) { // 사람들이 모두 제거되면 종료
            if(check == 0) check = 1;
            else System.out.print(", ");
            idx += (k-1);
            if(idx > list.size() - 1) idx %= list.size();
            System.out.print(list.get(idx));
            list.remove(idx);
        }
        System.out.print(">");
        sc.close();
    }
}