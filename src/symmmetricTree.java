public class symmmetricTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
    }
    public static void main(String[] args){
        int[] arr = {1,0};
        TreeNode root = createTree(arr,0);
        printTreeInorder(root);
        System.out.println(isSymmetric(root));
    }
    public static TreeNode createTree(int[] arr,int index){
        if( index >= arr.length || arr[index] == -1)
            return null;
        TreeNode root = new TreeNode();
        root.val = arr[index];
        root.left = createTree(arr,2*index + 1);
        root.right = createTree(arr,2*index + 2);
        return root;
    }
    public static void printTreeInorder(TreeNode root){
        if(root == null)
            return;
        printTreeInorder(root.left);
        System.out.print( " " +root.val);
        printTreeInorder(root.right);
    }
    public static boolean isSymmetric(TreeNode node){
        if(node == null)
            return true;
       // else if(node.left == null || node.right == null)
       //     return false;
        if(isMirrorImage(node.left,node.right))
            return true;
        return false;
    }
    public static boolean isMirrorImage(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        //else if(node1.val == node2.val && node1.left == null && node2.right == null)
        //    return true;
        else if(node1 !=null && node2 != null && node1.val == node2.val && isMirrorImage(node1.left,node2.right) && isMirrorImage(node1.right,node2.left))
            return true;
        return false;
    }
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        else if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))
            return root;
        else if(p.val < root.val && q.val < root.val)
            root = lowestCommonAncestorBST(root.left,p,q);
        else if(p.val > root.val && q.val > root.val)
            root = lowestCommonAncestorBST(root.right,p,q);
        return root;
    }
}
