import java.awt.*;

public class Main {
    public static void main (String[] args) {
        System.out.println("\n-------------------------Quickhull Algorithm--------------------------");


        int a[][] = {{0, 3}, {1, 1}, {2, 2}, {4, 4}, {0, 0}, {1, 2}, {3, 1}, {3, 3}};

        System.out.println("Toate punctele: ");

        for (int i = 0; i < a.length; i++)
            System.out.print("(" + a[i][0] + ","+ a[i][1]+ ") ");

        System.out.println("\n");
        int[][] result = QuickhullAlgorithm.FindConvexHull(a);
        System.out.println("\nPunctele polinomului sunt: ");
        for (int i = 0; i < result.length; i++)
            System.out.print("(" + result[i][0] + ","+ result [i][1]+ ") ");


        System.out.println("\n----------------------End of Quickhull Algorithm--------------------------");






        System.out.println("\n------------------------- Gift wrapping Algorithm--------------------------");


        Point1[] points = {new Point1(0, 3), new Point1(2, 2), new Point1(1, 1),
                new Point1(2, 1), new Point1(3, 0), new Point1(0, 0),
                new Point1(3, 3)};

        System.out.println("Toate punctele: ");
        for (Point1 p : points) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
        System.out.println("\nPunctele polinomului sunt: ");
        GiftWrapping.convexHull(points);

        System.out.println("\n----------------------End Gift wrapping Algorithm--------------------------");





        System.out.println("\n------------------------- Graham Scan Algorithm-----------------------------");

        {
            Point1[] points1 = {new Point1(0, 3), new Point1(2, 2), new Point1(1, 1),
                    new Point1(2, 1), new Point1(3, 0), new Point1(0, 0),
                    new Point1(3, 3)};


            System.out.println("Toate punctele: ");
            for (Point1 p : points) {
                System.out.println("(" + p.x + ", " + p.y + ")");
            }


            System.out.println("\nPunctele polinomului sunt: ");
            GrahamScan.convexHull(points1);
        }
        System.out.println("\n-------------------------End Graham Scan Algorithm--------------------------");


    }
}