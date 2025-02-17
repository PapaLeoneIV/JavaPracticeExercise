package tokenizer;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public Tokenizer() {}

    public String[] consume(String expression) {
        List<String> tokens = new ArrayList<>();
        
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == ' ') {
                continue;
            }

            if (Character.isDigit(currentChar)) {
                number.append(currentChar);
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    i++;
                    number.append(expression.charAt(i));
                }
                tokens.add(number.toString());
                number.setLength(0); // Reset number for next potential token
            } 
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                tokens.add(String.valueOf(currentChar));
            } 
            else {
                System.err.println("UNKNOWN TOKEN: " + currentChar);
				System.exit(1);
            }
        }

        return tokens.toArray(new String[0]);
    }
}
