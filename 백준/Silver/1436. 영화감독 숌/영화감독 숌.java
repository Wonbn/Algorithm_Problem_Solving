import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 666 부터 수를 키워나가는데 숫자 6이 연속으로 3개 이상 있어야 한다.

        int n = sc.nextInt();

        int count = 1, num = 666;
        while(true) {
            if(checkSixTriple(String.valueOf(num))) { // 숫자 6을 3개 이상 포함하는 수
                if (count++ == n) break;
            }
            num++;
        }

        System.out.println(num);
    }

    // 숫자 6이 3개 연속으로 들어가지는 체크
    public static boolean checkSixTriple(String str) {
        int cnt = 0;
        for(char a : str.toCharArray()) {
            if(a == '6') {
                cnt++;
            } else cnt = 0;
            if(cnt == 3) return true;
        }
        return false;
    }
}