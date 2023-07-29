import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine(); // 입력

        // Set을 활용해서 중복을 제거
        Set<String> result = differentExpressions(expression);

        // 괄호를 무조건 제거해야 하기 때문에 입력한 초기 식은 포함 X
        List<String> list = new ArrayList<>();
        for (String exp : result)
            if(!expression.equals(exp)) list.add(exp);

        // 사전 순 정렬
        Collections.sort(list);

        for (String exp : list) System.out.println(exp);
    }

    // 괄호를 제거해서 찾은 다른 식을 저장하고 반환하는 메서드
    public static Set<String> differentExpressions(String expression) {
        // 중복된 문자열이 저장될 수 있기 때문에 결과는 Set으로 받는다.
        Set<String> result = new HashSet<>();

        // 재귀를 통한 가능한 모든 경우의 식을 찾는다.
        generate(expression, 0, result);

        return result;
    }

    // 다른 식을 만드는 메서드
    private static void generate(String expression, int startIndex, Set<String> result) {
        // 괄호를 찾다가 startIndex가 문자열 끝까지 왔을때,
        // 그때의 문자열을 result에 저장하고 return
        if (startIndex == expression.length()) {
            result.add(expression);
            return;
        }

        // 열린 괄호를 만났다면
        if (expression.charAt(startIndex) == '(') {
            // 자신의 쌍인 닫힌 괄호를 찾아서 endIndex에 저장
            int endIndex = findMatchingClosingParenthesis(expression, startIndex);

            // 찾은 괄호 쌍 사이에 있는 괄호를 찾아서 제거하여 다시 식을 만든다.
            generate(expression, startIndex + 1, result);
            // 결국 괄호 제거는 <1>(<2>)<3> 에서 1,2,3 파트만 떼서 붙여주면 된다.
            generate(expression.substring(0, startIndex) + expression.substring(startIndex + 1, endIndex) +
                    expression.substring(endIndex + 1), startIndex, result);
        }
        else // 열린 괄호를 만나지 못했다면 인덱스를 한 칸씩 늘려서 찾는다.
            generate(expression, startIndex + 1, result);
    }

    //닫힌 괄호를 찾는 메서드
    public static int findMatchingClosingParenthesis(String expression, int startIndex) {
        int count = 0;
        for (int i = startIndex; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // 괄호가 쌍을 이루었는지에 대한 확인 후,
            // 자신의 쌍인 닫힌괄호를 만나면 그때의 인덱스를 반환
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count == 0) return i;
            }
        }
        return -1; // 에러 : 올바른 식이 아닐때
    }
}