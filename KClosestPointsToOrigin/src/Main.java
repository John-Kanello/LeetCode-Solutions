import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Main {

    public static void main(String[] args) {
        int[][] points = new int[][] {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        
        int k = 2;

        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    static int[][] kClosest(int[][] points, int k) {

        List<Square> list = new ArrayList<>();

        for(int i=0; i<points.length; i++) {
            double val = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            Square square = new Square(val, i);
            list.add(square);
        }

        list.sort(Comparator.comparingDouble(Square::getVal));

        int[][] res = new int[k][2];
        for(int i=0; i<k; i++) {
            Square iThSquare = list.get(i);
            int iTh = iThSquare.getPointer();
            res[i] = points[iTh];
            // res[i][0] = points[iTh][0];
            // res[i][1] = points[iTh][1];
        }

        return res;
    }
}

class Square {
    private double val;
    private int pointer;

    public Square(double val, int pointer) {
        this.val = val;
        this.pointer = pointer;
    }

    public double getVal() {
        return this.val;
    }

    public int getPointer() {
        return this.pointer;
    }
}