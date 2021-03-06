public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        if (leftChild(i) < size && rightChild(i) < size) {
            if (heap[i] > heap[leftChild(i)] && heap[i] > heap[rightChild(i)]) {
                return;
            }
            int index = 0;
            if (heap[leftChild(i)] > heap[rightChild(i)])
                index = leftChild(i);
            else {
                index = rightChild(i);
            }
            swap(heap, i, index);
            sink(index);
        }
        else if(leftChild(i)<size && heap[i]<heap[leftChild(i)]){
            swap(heap,i,leftChild(i));
            sink(leftChild(i));
        }
        else if(rightChild(i)<size && heap[i]<heap[rightChild(i)]){
            swap(heap,i,rightChild(i));
            sink(rightChild(i));
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;
        for (int i=this.size / 2 - 1; i>=0; i--) {
            sink(i);
        }
    }

    /**
     * Best-case runtime:O(N)
     * Worst-case runtime:O(NlogN)
     * Average-case runtime:O(NlogN)
     *
     * Space-complexity:O(1)
     */
    @Override
    public int[] sort(int[] arr) {
        heapify(arr);
        for (int i=size-1; i>0; i--)
        {
            swap(heap,i,0);
            size--;
            sink(0);
        }
        return heap;
    }
}
