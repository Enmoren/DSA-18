
import java.util.*;



class Gap implements Comparable<Gap>{
    int start;
    int end;
    int size;

    public Gap(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Gap a){
        return this.getSize() - a.getSize();
    }

    public int getSize(){
        return end - start - 1;
    }
}

public class BarnRepair {
    public static int solve(int M, int occupied[]){

        Arrays.sort(occupied);
        PriorityQueue<Gap> emptystalls = new PriorityQueue<>();

        for (int i = 0; i < occupied.length-1; i++) {
            if (occupied[i + 1] - occupied[i] > 1) {
                emptystalls.offer(new Gap(occupied[i], occupied[i + 1]));
            }
        }

        int stallsblocked = occupied.length;
        int nums_board = emptystalls.size() + 1;
        while(nums_board > M){
            Gap gap = emptystalls.poll();
            stallsblocked += gap.getSize();
            nums_board--;
        }
        return stallsblocked;
    }
}