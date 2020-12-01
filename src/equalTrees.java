public class equalTrees {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int value) {
            this.left = null;
            this.right = null;
            this.val = value;
        }

    }

    public static void main(String[] args) {
        //Node root = new Node(10);
        //addLeft(root,20);
        //addRight(root, 30);
        //addLeft(root.left, 25);
        //addRight(root.right, 40);
        int[] arr = {3,5,1,6,2,0,8,-1,-1,7,4};
        Node root = createTree(arr, 0);
        System.out.println("In");
        printInorder(root);
        System.out.println( );
        System.out.println("Pre");
        printPreorder(root);
        System.out.println( );
        System.out.println("Post");
        printPostorder(root);
        System.out.println( );
        System.out.println("Height "+findHeight(root));
        System.out.println(checkBalanceBinaryTree(root));

    }

    public static void addLeft(Node parent, int value) {
        parent.left = new Node(value);
    }

    public static void addRight(Node parent, int value) {
        parent.right = new Node(value);
    }

    public static int findHeight(Node node) {
        if (node == null)
            return -1;
        return 1 + (Math.max(findHeight(node.left), findHeight(node.right)));
    }

    public static void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.val);
        printInorder(node.right);
    }

    public static void printPreorder(Node node) {
        if (node == null)
            return;
        printPreorder(node.left);
        System.out.print(" " + node.val);
        printPreorder(node.right);
    }

    public static void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(" " + node.val);
    }

    public static boolean checkBalanceBinaryTree(Node root) {
        int leftH = findHeight(root.left);
        System.out.println("left : " + leftH);
        int rightH = findHeight(root.right);
        System.out.println("right : " + rightH);
        if (leftH - rightH <= 1)
            return true;
        return false;
    }

    public static Node createTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1)
            return null;
        Node node = new Node(arr[index]);
        node.left = createTree(arr, 2 * index + 1);
        node.right = createTree(arr, 2 * index + 2);
        return node;
    }


    public static Node graphConstructorFromArray(int[] arr) {
        Node head = new Node( );
        if (arr.length == 0)
            return null;
        else if (arr.length == 1)
            return new Node(arr[0]);
        else if (arr.length == 2) {
            Node parent = new Node(arr[0]);
            parent.left = new Node(arr[1]);
            return parent;
        } else {
            for (int i = 0; i < arr.length - (2 * i + 1); i++) {
                Node parent = new Node(arr[i]);
                if (i == 0)
                    head = parent;
                parent.left = new Node(arr[2 * i + 1]);
                parent.left = new Node(arr[2 * i + 2]);
            }
        }
        return head;
    }

    public static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null)
            return true;
        if((p == null && q != null) || (p != null && q == null) )
            return false;
        else if (p.left == null && q.left == null && p.right == null && q.right == null && p.val == q.val)
            return true;
        else if (p.left == null && q.left == null && p.right == null && q.right == null && p.val != q.val)
            return false;
        else if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && p.val == q.val)
            return true;
        return false;
    }

}
