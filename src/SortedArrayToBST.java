import java.util.Arrays;

public class SortedArrayToBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
        public static class BinarySearchTree {
            TreeNode root;
            BinarySearchTree() {}
            public TreeNode getRoot(){
                return this.root;
            }
            public void add(int newVal) {
                //System.out.println("in Add : "+newVal);
                if (root == null) {
                    root = new TreeNode(newVal);
                    System.out.println("created : " + newVal);
                }
                else if (newVal <= root.val) {
                    addLeft(root, newVal);
                } else {
                    addRight(root, newVal);
                }
            }
            public static void addLeft(TreeNode node, int newVal){
                    TreeNode newTreeNode = new TreeNode(newVal);
                    if (node.left == null) {
                            node.left = newTreeNode;
                    } else {
                            node = node.left;
                            if (newVal <= node.val) {
                                addLeft(node,newVal);
                            } else {
                                addRight(node,newVal);
                            }
                    }
            }
            public static void addRight(TreeNode node, int newVal){
                TreeNode newTreeNode = new TreeNode(newVal);
                if (node.right == null) {
                    node.right = newTreeNode;
                } else {
                    node = node.right;
                    if (newVal <= node.val) {
                        addLeft(node,newVal);
                    } else {
                        addRight(node,newVal);
                    }
                }
            }
        }static BinarySearchTree bst = new BinarySearchTree();
    public static void main(String args[]){
        int[] arr = {1,2,3,5,8,9};
        System.out.println(Arrays.toString(arr));
        TreeNode bstRoot = sortedArrayToBST(arr);
        System.out.println("Got : "+bstRoot.val);
        preOrder(bstRoot);
    }
    public static void preOrder(TreeNode head){
        if(head == null)
            return;
        System.out.print(" "+head.val);
        preOrder(head.left);
        preOrder(head.right);
    }
    public static TreeNode sortedArrayToBST(int[] arr){
        //BinarySearchTree bst = new BinarySearchTree();
        int len = arr.length;
        if(len == 1) {
            System.out.println("Adding : "+arr[0]);
            bst.add(arr[0]);
        }
        if(len > 1){
            bst.add(arr[len/2]);
            sortedArrayToBST(formArray(arr,0,(len/2) -1));
            sortedArrayToBST(formArray(arr,(len/2) +1,len - 1));
            }
        return bst.getRoot();
    }
    public static int[] formArray(int[] temp,int start,int end){
        System.out.println("Start : "+start+" end is : "+end);
        int[] formed = new int[end-start+1];
        if(start == end)
           formed[0] = temp[start];
        for(int i = start ; i <= end ; i++){
            formed[i - start] = temp[i];
        }
        System.out.println("Formed array :"+Arrays.toString(formed));
        return formed;
    }
}
