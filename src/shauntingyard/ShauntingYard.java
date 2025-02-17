package shauntingyard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShauntingYard {
    private boolean isNumber(String token) {
        int i = 0;
        while (i < token.length()) {
            if (!Character.isDigit(token.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int precedence(String token) {
        if (token.equals("+") || token.equals("-"))
            return 1;
        if (token.equals("*") || token.equals("/"))
            return 2;
        return 0;
    }

    public String[] shuntingYard(String[] tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!operators.empty() && isOperator(operators.peek())
                        && (precedence(token) <= precedence(operators.peek()))) {
                    output.add(operators.pop());
                }
                operators.push(token);
            } else {
                System.err.println("UNKNOWN TOKEN: " + token);
                System.exit(1);
            }
        }

        while (!operators.empty()) {
            output.add(operators.pop());
        }
        return output.toArray(new String[0]);
    }
}
