import java.awt.*;
import java.util.*;

public class RotateCommand extends Command {
    private Item item;
    private Point itemPoint;

    public RotateCommand() {
    }

    public RotateCommand(Point point) {
        selectItem(point);
    }

    public void selectItem(Point point) {
        Enumeration enumeration = model.getItems();
        while (enumeration.hasMoreElements()) {
            item = (Item) (enumeration.nextElement());
            if (item.includes(point)) {
                itemPoint = point;
                model.setItemToRotate(item);
                break;
            }
        }
    }

    public void rotateItem(Point point) {
        model.rotateItem(point);
    }

    public boolean undo() {
        model.unSelect(item);
        return true;
    }

    public boolean redo() {
        execute();
        return true;
    }

    public void execute() {
        model.setItemToMove(item);
    }
}