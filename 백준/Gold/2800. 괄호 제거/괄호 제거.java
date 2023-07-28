import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine().trim();
        scanner.close();

        Set<String> result = differentExpressions(expression);

        List<String> list = new ArrayList<>();
        for (String exp : result)
            if(!expression.equals(exp)) list.add(exp);

        Collections.sort(list);

        for (String exp : list) System.out.println(exp);
    }

    // 괄호를 제거해서 서로 다른 식을 만들자!
    public static Set<String> differentExpressions(String expression) {
        // 중복된 문자열이 저장될 수 있기 때문에 결과는 Set으로 받는다.
        Set<String> result = new HashSet<>();

        // 재귀를 통한 괄호제거를 통한 가능한 모든 경우의 식을 찾는다.
        generate(expression, 0, result);

        return result;
    }

    private static void generate(String expression, int startIndex, Set<String> result) {
        if (startIndex == expression.length()) {
            result.add(expression);
            return;
        }

        if (expression.charAt(startIndex) == '(') {
            int endIndex = findMatchingClosingParenthesis(expression, startIndex);
            for (int i = startIndex + 1; i < endIndex; i++) {
                if (expression.charAt(i) == '(') {
                    generate(expression, i, result);
                    i = findMatchingClosingParenthesis(expression, i);
                }
            }
            generate(expression, startIndex + 1, result);
            generate(expression.substring(0, startIndex) + expression.substring(startIndex + 1, endIndex) +
                    expression.substring(endIndex + 1), startIndex, result);
        } else {
            generate(expression, startIndex + 1, result);
        }
    }

    public static int findMatchingClosingParenthesis(String expression, int startIndex) {
        int count = 0;
        for (int i = startIndex; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
        }
        return -1; // Error: No matching closing parenthesis found
    }
}