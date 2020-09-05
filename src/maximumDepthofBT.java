import static java.lang.Integer.max;

public class maximumDepthofBT {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){ }
    }
    public static void main(String[] args){
        int[] arr = {3,9,20,-1,-1,15,7};
        TreeNode root = createTree(arr,0);
        printInorder(root);
        int depth = maxDepth(root);
        System.out.println("Depth is "+depth);
    }
    public static int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return 1+max(maxDepth(root.left),maxDepth(root.right));
    }
    public static TreeNode createTree(int[] arr,int index){
        if(index >= arr.length || arr[index] == -1)
            return null;
        TreeNode root = new TreeNode();
        root.val = arr[index];
        root.left = createTree(arr,2*index + 1);
        root.right = createTree(arr, 2*index + 2);
        return root;
    }
    public static void printInorder(TreeNode root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(" "+root.val);
        printInorder(root.right);
    }
}
