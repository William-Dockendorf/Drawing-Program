import java.awt.*;
import java.util.*;

public class MoveCommand extends Command {
    private Item item;
    private Point itemPoint;

    public MoveCommand() {
    }

    public MoveCommand(Point point) {
        setItemPoint(point);
    }

    public void setItemPoint(Point point) {
        Enumeration enumeration = model.getItems();
        while (enumeration.hasMoreElements()) {
            item = (Item) (enumeration.nextElement());
            if (item.includes(point)) {
                itemPoint = point;
                model.setItemToMove(item);
                break;
            }
        }
    }

    public void moveItemTo(Point point) {
        model.moveItem(itemPoint, point);
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