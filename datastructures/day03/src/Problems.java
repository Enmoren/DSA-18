import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {

        Stack<Integer> l = new Stack<>();
        if(k==A.length)
            return l;
        int index = 0;
        int i =0;
        while (i < A.length ){
           while (!l.isEmpty() && k > 0 && l.peek()>A[i]){
            l.pop();
            k--;
           }
           l.push(A[i]);
           i++;
        }
        while(k>0){
            l.pop();
            k--;
        }
        return l;
    }

    public static boolean isPalindrome(Node n) {
        if (n == null || n.next == null)
            return true;
        Node end = n;
        Node middle = n;
        while (end.next != null && end.next.next != null){
            end = end.next.next;
            middle = middle.next;
        }
        Node node = middle.next;
        Node nextnode ;
        Node prevnode = null;
        while (node != null){
            nextnode = node.next;
            node.next = prevnode;
            prevnode = node;
            node = nextnode;
        }
        Node head = prevnode;
        while (head != null){
            if (n.val != head.val){
                return false;
            }
            n = n.next;
            head = head.next;
        }
        return true;
    }

    public static String infixToPostfix(String s) {

        Stack stack = new Stack();
        String result = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                result = result + c + " ";
            }
            else if(c == '(' || c == ' '){
                continue;
            }
            else if(c == ')'){
                while (!stack.isEmpty())
                    result = result + stack.pop() + ' ';
            }
            else{
                stack.push(c);
            }
        }
        //single operator
        while (!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result.substring(0,result.length()-1);
    }

}
