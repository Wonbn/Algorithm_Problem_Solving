import java.util.*;
class Main
{
    public static int calculater(String str) {
        int result = 0;

        result += Integer.parseInt(str.substring(0,2))*3600;
        result += Integer.parseInt(str.substring(3,5))*60;
        result += Integer.parseInt(str.substring(6,8));

        return result;
    } // hh:mm:ss 형식으로 넣어주면 총 걸린 초를 반환해준다.

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String crt = sc.nextLine();
        String thr = sc.nextLine();

        int sCrt = calculater(crt);
        int sThr = (calculater(thr) <= sCrt) ? calculater(thr) + 24*3600 : calculater(thr) ; // 총 몇 초인지를 구한다.

        int sTotal = sThr - sCrt;

        System.out.printf("%02d:%02d:%02d", sTotal/3600, (sTotal%3600)/60, sTotal%60);

    }
}