<<<<<<< HEAD
import java.util.ArrayList;
import java.util.LinkedList;
=======
>>>>>>> 2bba5d6bcefc85757d2fcb149b0d1c59c9ab999d
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean contains(T key) {
        return find(root, key) != null;
    }

    /**
     * Add a node to the BST. Internally calls insert to recursively find the new node's place
     */
    public boolean add(T key) {
        if (find(root, key) != null) return false;
        root = insert(root, key);
        size++;
        return true;
    }

    public void addAll(T[] keys) {
        for (T k : keys)
            add(k);
    }

<<<<<<< HEAD
    //O(n)runtime
    public List<T> inOrderTraversal() {
        List<T> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode<T> root, List <T> res) {
        if (root != null) {
            if (root.leftChild!= null) {
                helper(root.leftChild, res);
            }
            res.add(root.key);
            if (root.rightChild != null) {
                helper(root.rightChild, res);
            }
        }
=======
    public List<T> inOrderTraversal() {
        // TODO
        return null;
>>>>>>> 2bba5d6bcefc85757d2fcb149b0d1c59c9ab999d
    }

    /**
     * Deletes a node from the BST using the following logic:
     * 1. If the node has a left child, replace it with its predecessor
     * 2. Else if it has a right child, replace it with its successor
     * 3. If it has no children, simply its parent's pointer to it
     */
    public boolean delete(T key) {
        TreeNode<T> toDelete = find(root, key);
        if (toDelete == null) {
            System.out.println("Key does not exist");
            return false;
        }
        TreeNode<T> deleted = delete(toDelete);
        if (toDelete == root) {
            root = deleted;
        }
        size--;
        return true;
    }

    private TreeNode<T> delete(TreeNode<T> n) {
        // Recursive base case
        if (n == null) return null;

        TreeNode<T> replacement;

        if (n.isLeaf())
            // Case 1: no children
            replacement = null;
<<<<<<< HEAD
        else if (n.hasRightChild() != n.hasLeftChild()) {
            // Case 2: one child
            replacement = (n.hasRightChild()) ? n.rightChild : n.leftChild; // replacement is the non-null child
//            replacement.moveChildrenFrom(n); (?)
        }
        else {
            // Case 3: two children
            replacement = minValue(n.rightChild);
            delete(minValue(n.rightChild));
            replacement.moveChildrenFrom(n);
=======
        else if (n.hasRightChild() != n.hasLeftChild())
            // Case 2: one child
            replacement = (n.hasRightChild()) ? n.rightChild : n.leftChild; // replacement is the non-null child
        else {
            // Case 3: two children
            // TODO
            replacement = null;
>>>>>>> 2bba5d6bcefc85757d2fcb149b0d1c59c9ab999d
        }

        // Put the replacement in its correct place, and set the parent.
        n.replaceWith(replacement);
        return replacement;
    }

    public T findPredecessor(T key) {
        TreeNode<T> n = find(root, key);
        if (n != null) {
            TreeNode<T> predecessor = findPredecessor(n);
            if (predecessor != null)
                return predecessor.key;
        }
        return null;
    }

    public T findSuccessor(T key) {
        TreeNode<T> n = find(root, key);
        if (n != null) {
            TreeNode<T> successor = findSuccessor(n);
            if (successor != null)
                return successor.key;
        }
        return null;
    }
<<<<<<< HEAD
    //O(logN)runtime
    private TreeNode<T> findPredecessor(TreeNode<T> n) {
        if (n.leftChild!=null){
            return maxValue(n.leftChild);
        }
        else {
            TreeNode p = n.parent;
            while (p != null && n == p.leftChild) {
                n = p;
                p = p.parent;
            }
            return p;
        }
    }

    private TreeNode<T> maxValue(TreeNode<T> n) {
        TreeNode<T> current = n;
        /* loop down to find the leftmost leaf */
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current;
    }

    private TreeNode<T> findSuccessor(TreeNode<T> n) {
        if (n.rightChild!=null){
            return minValue(n.rightChild);
        }
        else {
            TreeNode p = n.parent;
            while (p != null && n == p.rightChild) {
                n = p;
                p = n.parent;
            }
            return p;
        }
    }

    private TreeNode<T> minValue(TreeNode<T> n) {
        TreeNode<T> current = n;
        /* loop down to find the leftmost leaf */
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
=======

    private TreeNode<T> findPredecessor(TreeNode<T> n) {
        // TODO
        return null;
    }

    private TreeNode<T> findSuccessor(TreeNode<T> n) {
        // TODO
        return null;
>>>>>>> 2bba5d6bcefc85757d2fcb149b0d1c59c9ab999d
    }

    /**
     * Returns a node with the given key in the BST, or null if it doesn't exist.
     */
    private TreeNode<T> find(TreeNode<T> currentNode, T key) {
        if (currentNode == null)
            return null;
        int cmp = key.compareTo(currentNode.key);
        if (cmp < 0)
            return find(currentNode.leftChild, key);
        else if (cmp > 0)
            return find(currentNode.rightChild, key);
        return currentNode;
    }

    /**
     * Recursively insert a new node into the BST
     */
    private TreeNode<T> insert(TreeNode<T> node, T key) {
        if (node == null) return new TreeNode<>(key);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftChild = insert(node.leftChild, key);
            node.leftChild.parent = node;
        } else {
            node.rightChild = insert(node.rightChild, key);
            node.rightChild.parent = node;
        }
        return node;
    }
}
