import java.awt.*;
public class Triangle extends Item {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Triangle (Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public Triangle (Point point1) {
        this.point1 = point1;
    }
    public Triangle () {
    }

    public boolean includes(Point point) {
        return ((distance(point, point1) < 10.0) || (distance(point, point2) < 10.0));
    }

    public void render() {
        uiContext.draw(this);
    }

    public void setPoint1(Point point) {
        point1 = point;
    }

    public void setPoint2(Point point) {
        point2 = point;
    }

    public void setPoint3(Point point) {
        point3 = point;
    }

    public Point getPoint1() {
        return point1;
    }
    
    public Point getPoint2() {
        return point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public String toString() {
        return "Triangle: Point 1 is: " + point1 + " \nPoint 2: " + point2 + " \nPoint 3: " + point3;
    }

    public boolean move(Point itemPoint, Point newPoint) {
        point1.x += newPoint.x - itemPoint.x;
        point1.y += newPoint.y - itemPoint.y;
        point2.x += newPoint.x - itemPoint.x;
        point2.y += newPoint.y - itemPoint.y;
        point3.x += newPoint.x - itemPoint.x;
        point3.y += newPoint.y - itemPoint.y;

        return true;
    }

    public boolean rotateCW(Point point) {
        /* make the point the origin*/
        point1.setLocation(point1.x - point.x, point1.y - point.y);
        point2.setLocation(point2.x - point.x, point2.y - point.y);
        point3.setLocation(point3.x - point.x, point3.y - point.y);

        /*Now we rotate the point 90 degrees CW around the origin using a transform matrix 
        that looks like [0 -1]
                        [1  0]  or once you multiply [x, y] by this transform you get [y,-x]*/
        point1.setLocation(point1.y, point1.x * -1);
        point2.setLocation(point2.y, point2.x * -1);
        point3.setLocation(point3.y, point3.x * -1);

        /*Move the origin back into place, and move the points back to the appropriate location */
        point1.setLocation(point1.x + point.x, point1.y + point.y);
        point2.setLocation(point2.x + point.x, point2.y + point.y);
        point3.setLocation(point3.x + point.x, point3.y + point.y);

        return true;
    }
}