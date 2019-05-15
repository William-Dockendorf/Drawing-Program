import java.awt.*;
public class Label extends Item {
  private Point startingPoint;
  private String text = "";
  public Label(Point point) {
    startingPoint = point;
  }
  public void addCharacter(char character) {
    text += character;
  }
  public void removeCharacter() {
    if (text.length() > 0) {
      text = text.substring(0, text.length() - 1);
    }
  }
  public boolean includes(Point point) {
    return distance(point, startingPoint) < 10.0;
  }
  public void render() {
    uiContext.draw(this);
  }
  public String getText() {
    return text;
  }
  public Point getStartingPoint() {
    return startingPoint;
  }

  public boolean move(Point itemPoint, Point newPoint) {
    startingPoint.x += newPoint.x - itemPoint.x;
    startingPoint.y += newPoint.y - itemPoint.y;
    return true;
  }

  public boolean rotateCW(Point point) {
    System.out.println("You can't rotate a label.");
    return true;
  }
}