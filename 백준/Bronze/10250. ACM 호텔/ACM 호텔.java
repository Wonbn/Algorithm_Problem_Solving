import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스

        while(T-- > 0) {
            int H = sc.nextInt(); // 건물 층수
            int W = sc.nextInt(); // 한 층의 방 개수
            int N = sc.nextInt(); // 몇 번째 손님인지
            int room_num = 0;
            room_num += (N-1)/H + 1; // 몇 호인지를 먼저 구해서 넣어준다.
            room_num += (N%H != 0)?100*(N%H):(100*H);
            System.out.println(room_num);
        }
    }
}