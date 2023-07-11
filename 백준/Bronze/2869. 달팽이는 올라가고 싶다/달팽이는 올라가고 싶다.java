import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int count = 1;
        v -= a;
        // 올라가야 하는 높이에서 하루에 올라갈 수 있는 높이를 빼는 방식을
        // 나누는 방식으로 몫을 구한다.
        // 나머지가 있다면 한번 더 올라가야 하기 때문에 count++ 해준다.
        if(v != 0) {
            count += (v / (a-b));
            if(v % (a-b) != 0) count++;
        }
        System.out.println(count);
    }
}