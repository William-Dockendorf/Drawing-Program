import java.awt.Graphics;
import java.util.*;
public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  private NewSwingUI() {
  }
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  public void draw(Label label) {
    if (label.getStartingPoint() != null) {
      if (label.getText() != null) {
        graphics.drawString(label.getText(), (int) label.getStartingPoint().getX(), (int) label.getStartingPoint().getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(label.getText());
    graphics.drawString("_", (int) label.getStartingPoint().getX() + length, (int) label.getStartingPoint().getY());
  }
  public void draw(Line line) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (line.getPoint1() != null) {
      i1 = Math.round((float) (line.getPoint1().getX()));
      i2 = Math.round((float) (line.getPoint1().getY()));
      if (line.getPoint2() != null) {
        i3 = Math.round((float) (line.getPoint2().getX()));
        i4 = Math.round((float) (line.getPoint2().getY()));
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }
  public void draw(Item item) {
    System.out.println( "Cant draw unknown Item \n");
  }

  public void draw(Triangle triangle) {
      int x[] = new int[3];
      int y[] = new int[3];
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      int i6;
      //int nPoints = 3;

      System.out.println("You made it into the drawing stage.");

      if (triangle.getPoint1() != null) {
          System.out.println("Into the first point Draw loop.");
          i1 = Math.round((float) (triangle.getPoint1().getX()));
          i2 = Math.round((float) (triangle.getPoint1().getY()));
          //x[0] = i1; y[0] = i2;
          System.out.println("x1: " + i1 + "  y1: " + i2);
          if (triangle.getPoint2() != null)
          {
              System.out.println("Into the SECOND point Draw loop");
              i3 = Math.round((float) (triangle.getPoint2().getX()));
              i4 = Math.round((float) (triangle.getPoint2().getY()));
              //x[1] = i3; y[1] = i4;
              System.out.println("x2: " + i3 + "  y2: " + i4);
              if (triangle.getPoint3() !=null) {
                  i5 = Math.round((float) (triangle.getPoint2().getX()));
                  i6 = Math.round((float) (triangle.getPoint2().getY()));
                  System.out.println("x3: " + i5 + "  y3: " + i6);
                  x[0] = i1; x[1] = i3; x[2] = i5;
                  y[0] = i2; y[1] = i4; y[2] = i6;
                  System.out.println("After Storing all the points");
              }
          }
          //graphics.drawPolygon(x, y, nPoints);
          
          graphics.drawLine(x[0], y[0], x[1], y[1]);
          graphics.drawLine(x[1], y[1], x[2], y[2]);
          graphics.drawLine(x[0], y[0], x[2], y[2]);
          
          System.out.println("After the Drawing part.");
      }
  }
}