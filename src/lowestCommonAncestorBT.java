public class lowestCommonAncestorBT {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;this.next = null;}
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
        TreeNode root = createTree(arr, 0);
        printInorder(root);
        System.out.println( );
        TreeNode x = new TreeNode( );
        x.val = 3;
        TreeNode y = new TreeNode( );
        y.val = 1;
        TreeNode commonAncestor = lowestCommonAncestor(root, x, y);
        System.out.println( );
        System.out.println(commonAncestor.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ListNode pathToX= findPath(root,p);
        ListNode pathToY = findPath(root,q);
        printList(pathToX);
        System.out.println();
        printList(pathToY);
        System.out.println();
        ListNode commonNode = commonListNode(pathToX,pathToY);
        TreeNode commonAncestor = new TreeNode();
        commonAncestor.val = commonNode.val;
        return commonAncestor;
    }
    public static ListNode commonListNode(ListNode x,ListNode y){
        while( x.next != null & y.next != null) {
            if (x.next.val == y.next.val) {
                x = x.next;
                y = y.next;
            } else
                return x;
        }
        if(x.next == null)
            return y;
        //if(y.next == null)
        //    return x;
        return x;
    }
    public static ListNode findPath(TreeNode root, TreeNode x){
        if(root == null)
            return null;
        if(x == null)
            return null;
        if(root.left == null && root.right == null && root.val != x.val)
            return null;
        ListNode head = new ListNode(root.val);
        //ListNode temp = head;
        System.out.println(head.val);
        if(x.val == root.val)
            return head;

        //temp.next =
        head.next = findPath(root.left, x);
       // System.out.println("temp value "+temp.val);
        if (head.next == null)
                head.next = findPath(root.right, x);
        if(head.next == null)
            return null;
        return head;
    }
    public static TreeNode createTree(int[] arr,int index){
        TreeNode root = new TreeNode();
        if(index >= arr.length || arr[index] == -1)
            return null;
        root.val = arr[index];
        root.left = createTree(arr,2*index+1);
        root.right = createTree(arr,2*index + 2);
        return root;
    }
    public static void printList(ListNode head){
        if(head == null)
            return;
        System.out.print(head.val);
        if(head.next != null)
            System.out.print("-->");
        printList(head.next);
    }
    public static void printInorder(TreeNode node) {

        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.val);
        printInorder(node.right);
    }
}
