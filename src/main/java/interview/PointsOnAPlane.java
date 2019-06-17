package interview;

import java.util.Collection;

/**
 * Created by nav on 12/15/15.
 */
public interface PointsOnAPlane {

    void addPoint(Point point);

    Collection<Point> findNearest(Point center, int p);

    class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }
}
