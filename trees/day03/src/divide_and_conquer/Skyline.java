package divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class Skyline {

    public static class Point {
        public int x;
        public int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Building {
        private int l, r, h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    // Runtime: O(NlogN)
    // Space Complexity: O(N)

    public static List<Point> skyline(Building[] B) {
       return mergesort(B,0, B.length);
    }

    public static ArrayList<Point> mergesort(Building[] B, int leftStart, int rightEnd){
        ArrayList<Point> temp = new ArrayList<>();
        if (B.length==0){
            return  null;
        }
        if (B.length == 1) {
            temp.add(new Point(B[leftStart].l, B[leftStart].h));
            temp.add(new Point(B[leftStart].r, 0));
            return temp;
        }
        int middle = (leftStart + rightEnd)/ 2;
        Building[] left = Arrays.copyOfRange(B, 0, middle);
        Building[] right = Arrays.copyOfRange(B, middle , B.length);

        ArrayList<Point> left_list = mergesort(left, 0, left.length  );
        ArrayList<Point> right_list = mergesort(right,0, right.length );

        return mergeHalves(left_list, right_list);
    }

    private static ArrayList<Point> mergeHalves(ArrayList<Point>leftlist, ArrayList<Point>rightlist) {
        ArrayList<Point> temp = new ArrayList<>();
        int left = 0;
        int right = 0;
        int left_height = 0;
        int right_height = 0;

        while (left < leftlist.size() && right < rightlist.size()){
            if (leftlist.get(left).x < rightlist.get(right).x){
                left_height = leftlist.get(left).y;
                int max_height = Math.max(left_height,right_height);
                temp.add(new Point(leftlist.get(left).x, max_height));
                left++;
            }else {
                right_height = rightlist.get(right).y;
                int max_height = Math.max(left_height,right_height);
                temp.add(new Point(rightlist.get(right).x, max_height));
                right++;
            }
        }
        while (left < leftlist.size()){
            temp.add(leftlist.get(left));
            left++;
        }
        while (right < rightlist.size()){
            temp.add(rightlist.get(right));
            right++;
        }

        int index = 0;
        while (index < temp.size()-1){
            if (temp.get(index).y == temp.get(index + 1 ).y){
//                System.out.print(temp.get(index).x);
//                System.out.print(temp.get(index).y);
//                System.out.print("  ");
//                System.out.print(temp.get(index - 1).x);
//                System.out.print(temp.get(index - 1).y);
//                System.out.print("  ");
                temp.remove(index + 1);}
            else if (temp.get(index).x == temp.get(index + 1).x ) {
                if (temp.get(index).y > temp.get(index + 1).y)
                    temp.remove(index + 1);
                else {
                    temp.remove(index);
                }
            }
            else {
                index++;
            }

        }
//        for (int i = 0; i < temp.size(); i++) {
//            System.out.print(temp.get(i).x);
//            System.out.print(temp.get(i).y);
//            System.out.print("  ");
//        }
        return temp;
    }
}
