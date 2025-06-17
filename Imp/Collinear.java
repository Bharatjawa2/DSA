public class PointOnSegment {
    public static boolean isPointOnSegment(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Check if the three points are collinear (cross product = 0)
        int crossProduct = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
        if (crossProduct != 0) {
            return false; // Not collinear
        }

        // Check if point (x3, y3) lies within the bounding box of (x1,y1) and (x2,y2)
        boolean withinX = (x3 >= Math.min(x1, x2)) && (x3 <= Math.max(x1, x2));
        boolean withinY = (y3 >= Math.min(y1, y2)) && (y3 <= Math.max(y1, y2));

        return withinX && withinY;
    }

    public static void main(String[] args) {
        // Example 1: Point (5,5) lies on the segment from (0,0) to (10,10)
        System.out.println(isPointOnSegment(0, 0, 10, 10, 5, 5)); // true

        // Example 2: Point (15,15) is collinear but outside the segment
        System.out.println(isPointOnSegment(0, 0, 10, 10, 15, 15)); // false

        // Example 3: Point (5,6) is not collinear
        System.out.println(isPointOnSegment(0, 0, 10, 10, 5, 6)); // false
    }
}
