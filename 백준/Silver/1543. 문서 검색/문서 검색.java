import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String strq = sc.nextLine();
        String stra = sc.nextLine();
        int result = strq.length();

        strq = strq.replaceAll(stra, "");
        // 문서에서 등장하는 단어를 모두 빼준다.
        result = (result - strq.length())/stra.length();
        // 줄어든 문자수만큼 등장단어의 문자수를 나누어준다.
        System.out.println(result); // 출력
    }
}