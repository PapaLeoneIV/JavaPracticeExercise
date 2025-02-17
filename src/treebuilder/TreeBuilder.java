package treebuilder;


import java.util.Stack;
import treenode.TreeNode;

public class TreeBuilder {
    private boolean isNumber(String token){
        int i = 0;
        while(i < token.length()){
            if(!Character.isDigit(token.charAt(i))){
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }


    public TreeNode buildTree(String [] tokens){
        Stack<TreeNode> stack = new Stack<>();
        
        for(String token : tokens){
            if(isNumber(token)){
                stack.push(new TreeNode(token));
            } else if (isOperator(token)){
                TreeNode rightNode = stack.pop();
                TreeNode leftNode = stack.pop();
                stack.push(new TreeNode(token, leftNode, rightNode));
            } else {
                System.err.println("UNKNOWN TOKEN: " + token);
                System.exit(1);
            }
        }
        return stack.pop();
    }

}
