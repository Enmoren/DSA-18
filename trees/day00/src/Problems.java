import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
<<<<<<< HEAD
        BinarySearchTree<Integer> res = new BinarySearchTree<>();
//        values.sort(Integer::compareTo);
        Collections.sort(values);
        int end = values.size()-1;
        int start = 0;
        sortedArrayToBST(res,values,start,end);
//        System.out.print(values);
        return res;
    }
    public static void sortedArrayToBST(BinarySearchTree<Integer> res, List<Integer> value, int start, int end) {

        /* Base Case */
        if (start > end) {
            return;
        }
        if (start == end){
            res.add(value.get(start));
            return;
        }
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        res.add(value.get(mid));

        /* Recursively construct the left subtree and make it
         left child of root */
        sortedArrayToBST(res, value, start, mid);

        /* Recursively construct the right subtree and make it
         right child of root */
        sortedArrayToBST(res,value, mid + 1, end);
=======
        // TODO
        return new BinarySearchTree<>();
>>>>>>> 2bba5d6bcefc85757d2fcb149b0d1c59c9ab999d
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        return false;
    }
}
