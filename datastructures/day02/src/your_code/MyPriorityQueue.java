package your_code;


import ADTs.QueueADT;
import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */

public class MyPriorityQueue {
    private MyQueue<Integer> ll;

    public MyPriorityQueue() {
        ll = new MyQueue<Integer>();
    }

    public void enqueue(int item) {
        if (ll.isEmpty()){
            ll.enqueue(item);
        }
        else{
            MyQueue<Integer> temp = new MyQueue<Integer>();
            while(!ll.isEmpty()){
                int obj = ll.dequeue();
                if (item > obj){
                    temp.enqueue(item);
                }
                temp.enqueue(obj);
            }
            ll=temp;
        }
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
        return (int) ll.dequeue();
    }

}