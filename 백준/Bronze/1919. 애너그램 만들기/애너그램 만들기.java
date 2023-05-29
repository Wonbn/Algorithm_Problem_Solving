import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str1 = sc.nextLine().toCharArray();
        char[] str2 = sc.nextLine().toCharArray();
        int[] alp1 = new int[26];
        int[] alp2 = new int[26];
        int result = 0;

        for(char c : str1) alp1[c-'a']++;
        for(char c : str2) alp2[c-'a']++;

        for(int i = 0; i < 26; i++) result += Math.abs(alp1[i]-alp2[i]);

        System.out.println(result);
    }
}
