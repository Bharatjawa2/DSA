public class PointInTriangle {
    public static int doubleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2));
    }

    public static boolean isPointInsideTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
        int areaABC = doubleArea(x1, y1, x2, y2, x3, y3);
        int areaPAB = doubleArea(x, y, x1, y1, x2, y2);
        int areaPBC = doubleArea(x, y, x2, y2, x3, y3);
        int areaPCA = doubleArea(x, y, x3, y3, x1, y1);

        return areaABC == (areaPAB + areaPBC + areaPCA); // Exact equality
    }

    public static void main(String[] args) {
        int x1 = 0, y1 = 0;
        int x2 = 10, y2 = 0;
        int x3 = 0, y3 = 10;

        int x = 4, y = 4; // Inside
        System.out.println(isPointInsideTriangle(x1, y1, x2, y2, x3, y3, x, y)); // true

        x = 10; y = 10; // Outside
        System.out.println(isPointInsideTriangle(x1, y1, x2, y2, x3, y3, x, y)); // false
    }
}
