import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LevelOrderTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
    }

    public static void main(String[] args) {
        //int[] arr = {1,2,-1,3,-1,-1,-1,4,-1,-1,-1,-1,-1,-1,-1,5};
        //int[] arr = {3,9,20,11,12,15,7};
        int[] arr ={1,-1,2,};
        TreeNode root = createTree(arr, 0);
        System.out.println("In");
        printInorder(root);
        List<List<Integer>> kidsfromTop = levelOrderFromTop(root);
        System.out.println(kidsfromTop);
        List<List<Integer>> kidsfromBottom =levelOrderFromBottom(root);
        System.out.println(kidsfromBottom);
    }
    public static List<List<Integer>> levelOrderFromTop(TreeNode root) {
        List<List<Integer>> levelOrderTopBottom = new ArrayList<>();
        if (root == null)
            return levelOrderTopBottom;
        Map<Integer, List<Integer>> treeDescription = describe(root);

        for(int i = 0 ; i < treeDescription.size() ; i++){
           levelOrderTopBottom.add(treeDescription.get(i));
        }
        return levelOrderTopBottom;
    }
    public static List<List<Integer>> levelOrderFromBottom(TreeNode root) {
        List<List<Integer>> levelOrderBottomTop = new ArrayList<>();
        if (root == null)
            return levelOrderBottomTop;
        Map<Integer, List<Integer>> treeDescription = describe(root);

        for(int i = treeDescription.size() - 1 ; i >= 0 ; i--){
            levelOrderBottomTop.add(treeDescription.get(i));
        }
        return levelOrderBottomTop;
    }
        public static Map<Integer, List<Integer>> describe(TreeNode root){
        if(root == null)
            return null;
        Map<Integer, List<Integer>> nodeDescription = new HashMap<>();
        nodeDescription.put(0, Collections.singletonList(root.val));
        Map<Integer, List<Integer>> leftDescription = describe(root.left);
        Map<Integer, List<Integer>> rightDescription = describe(root.right);
        if(leftDescription == null && rightDescription == null)
            return nodeDescription;
        if(leftDescription != null && rightDescription != null) {
            for(int index = 0; index < Math.max(leftDescription.size(),rightDescription.size());index++)
                nodeDescription.put(index + 1, merge(leftDescription.get(index), rightDescription.get(index)));
        }
        else if(leftDescription != null && rightDescription == null)
        {
            for(int index = 0; index < leftDescription.size();index++)
                nodeDescription.put(index + 1, leftDescription.get(index));
        }
        else if(leftDescription == null && rightDescription != null)
        {
            for(int index = 0; index < rightDescription.size();index++)
                nodeDescription.put(index + 1, rightDescription.get(index));
        }

        System.out.println("NODE description of "+root.val+" is "+nodeDescription);
        return nodeDescription;
    }


    public static<T> List<T> merge(List<T> list1, List<T> list2)
    {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        List<T> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);

        return list;
    }

    public static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(" " + node.val);
        printInorder(node.right);
    }

    public static TreeNode createTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1)
            return null;
        TreeNode root = new TreeNode( );
        root.val = arr[index];
        root.left = createTree(arr, 2 * index + 1);
        root.right = createTree(arr, 2 * index + 2);
        return root;
    }
}