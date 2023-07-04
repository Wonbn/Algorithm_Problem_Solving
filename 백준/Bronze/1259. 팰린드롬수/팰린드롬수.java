// 앞, 뒤 상관없이 어디서 읽든 똑같이 읽히는 것을 팰린드롬이라고 한다.
// ex) 12321, asdsa

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            boolean check = true;
            int a = sc.nextInt();
            if(a == 0) break;
            String str = "" + a;
            for(int i = 0; i < (str.length()+1)/2; i++) {
                if(str.charAt(i) != str.charAt(str.length()-i-1)) {
                    System.out.println("no");
                    check = false;
                    break;
                }
            }
            if(check) System.out.println("yes");
        }
    }
}