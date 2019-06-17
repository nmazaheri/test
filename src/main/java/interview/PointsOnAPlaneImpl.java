package interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nav on 12/15/15.
 */

public class PointsOnAPlaneImpl implements PointsOnAPlane {
    public static void main(String[] args) {
        PointsOnAPlane pointsOnAPlane = new PointsOnAPlaneImpl();
        pointsOnAPlane.addPoint(new Point(0, 3));
        pointsOnAPlane.addPoint(new Point(0, 4));
        pointsOnAPlane.addPoint(new Point(0, 5));
        pointsOnAPlane.addPoint(new Point(0, 6));
        pointsOnAPlane.addPoint(new Point(0, 7));
        pointsOnAPlane.addPoint(new Point(1, 1));

        System.out.println(pointsOnAPlane.findNearest(new Point(0, 0), 3));
    }

    List<Point> points = new ArrayList();

    @Override
    public void addPoint(Point point) {
        points.add(point);
    }

    @Override
    public Collection<Point> findNearest(Point center, int p) {
        List<PointDistance> distancePoint = new LinkedList();
        for (Point curr : points) {
            distancePoint.add(new PointDistance(curr, calcRelativeDistanceBetweenPoints(curr, center)));
        }
        Collections.sort(distancePoint);

        List<Point> result = new ArrayList();
        for (int i = 0; i < p && i < distancePoint.size(); i++) {
            result.add(distancePoint.get(i).p);
        }
        return result;
    }

    class PointDistance implements Comparable {
        Point p;
        double distance;

        public PointDistance(Point p, double distance) {
            this.p = p;
            this.distance = distance;
        }

        @Override
        public int compareTo(Object o) {
            PointDistance pd = (PointDistance) o;
            if (this.distance > pd.distance)
                return 1;
            else if (this.distance < pd.distance)
                return -1;
            else
                return 0;
        }
    }

    private static double calcRelativeDistanceBetweenPoints(Point a, Point b) {
        int xDelta = a.x - b.x;
        int yDelta = a.y - b.y;
        return xDelta * xDelta + yDelta * yDelta;
    }
}

