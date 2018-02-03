public class MyArrayList {
    private Cow[] elems;
    private int size;

    // TODO: Runtime: O(1)
    public MyArrayList() {
        this.elems = new Cow [10];
        this.size=0;
    }

    // TODO: Runtime: O(1)
    public MyArrayList(int capacity) {
        this.elems = new Cow [capacity];
        this.size = 0;
    }

    // TODO: Runtime: O(1)
    public boolean add(Cow c) {
        if (size >= elems.length) {
            Cow[] elems2 = new Cow[elems.length * 2];
            System.arraycopy(elems, 0, elems2, 0, elems.length );
            elems = elems2;
        }
        this.elems[size] = c;
        this.size++;
        return true;
    }

    // TODO: Runtime: O(1)
    public int size() {
        return this.size;
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.elems[index];
    }


    // TODO: Runtime: O(n)
    public void add(int index, Cow c) {
        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        add(c);
        for (int i=this.size-1; i>index; i--) {
            this.elems[i] = this.elems[i - 1];
        }
        this.elems[index] = c;

    }

    // TODO: Runtime: O(n)
    public Cow remove(int index) {
        if (index < 0 || index >= this.size) {

            throw new IndexOutOfBoundsException("index is out of array bounds");
        }
        Cow cow = this.elems[index];
        for (int i = index; i < size - 1; i++) {
            elems[i] = elems[i + 1];
        }
        this.size--;

        if (size < 0.25 * elems.length) {
            Cow[] elems2 = new Cow[elems.length / 2];
            System.arraycopy(elems, 0, elems2, 0, elems.length / 2);
            elems = elems2;
        }
        return cow;
    }

}
