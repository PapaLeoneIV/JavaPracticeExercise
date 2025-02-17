package treenode;

public class TreeNode {
    private final String value;
    private final TreeNode left;
    private final TreeNode right;
    
    public TreeNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(String value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    

    //yep chatgpt did this print method
    public void print(String prefix, boolean isLeft) {
        if (right != null) {
            right.print(prefix + (isLeft ? "│   " : "    "), false);  
        }
        
        System.out.print(prefix); 
        System.out.print(isLeft ? "└── " : "┌── "); 
        System.out.println(value);  
        
        if (left != null) {
            left.print(prefix + (isLeft ? "    " : "│   "), true);
        }
    }

}
