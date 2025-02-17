import java.util.Scanner;
import shauntingyard.ShauntingYard;
import tokenizer.Tokenizer;
import treebuilder.TreeBuilder;
import treenode.TreeNode;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter an expression to evaluate (press Enter without input to exit):\n");
        Scanner myObj = new Scanner(System.in);

        Tokenizer tokenizer = new Tokenizer();
        ShauntingYard sy = new ShauntingYard();
        TreeBuilder tb = new TreeBuilder();
        
        while (true) {
            String expression = myObj.nextLine().trim(); // Read the entire line
            
            if (expression.isEmpty()) {
                break;
            }

            String[] tokens = tokenizer.consume(expression);
            
            String[] polishNotation = sy.shuntingYard(tokens);
            
            TreeNode root = tb.buildTree(polishNotation);
            
            root.print("", false);
            
            System.out.println("\nEnter another expression (or press Enter to exit):\n");
        }

        myObj.close();
        System.out.println("Goodbye!");
    }
}
