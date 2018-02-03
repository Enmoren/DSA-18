package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> dd;

    public MyStack() {
        ll = new LinkedList<>();
        dd = new LinkedList<>();
    }

    @Override
    public void push(Integer e) {
        ll.addFirst(e);
        if (ll.size() ==1){
            dd.addFirst(e);
            return;
        }
        if (e > dd.peek()){
            dd.addFirst(e);
        }else{  dd.addFirst(dd.peek());  }

    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        dd.removeFirst();
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        return dd.peek();
    }
}
