public class TriangleValidity {
    public static boolean isValidTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
        return area > 0;
    }

    public static void main(String[] args) {
        int x1 = 0, y1 = 0;
        int x2 = 1, y2 = 1;
        int x3 = 1, y3 = 0;

        if (isValidTriangle(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points form a valid triangle.");
        } else {
            System.out.println("The points do not form a valid triangle.");
        }
    }
}
