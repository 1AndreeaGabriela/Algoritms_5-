
import java.util.*;



class GiftWrapping {
    // Function to find the orientation of three points
    static int orientation(Point1 p, Point1 q, Point1 r) {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0)
            return 0;  // Collinear
        return (val > 0) ? 1 : 2; // 1 for clockwise, 2 for counterclockwise
    }

    static void convexHull(Point1[] points) {
        int n = points.length;
        if (n < 3)
            return; // Convex hull not possible

        // Initialize the output list
        ArrayList<Point1> hull = new ArrayList<>();

        // Find the leftmost point
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;

        int p = l, q;
        do {
            hull.add(points[p]);
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q]) == 2)
                    q = i;
            }
            p = q;

        } while (p != l);

        // Print the convex hull
        for (Point1 temp : hull)
            System.out.println("(" + temp.x + ", " + temp.y + ")");
    }
}


