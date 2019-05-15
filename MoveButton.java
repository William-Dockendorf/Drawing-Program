import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MoveButton extends JButton implements ActionListener {
    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;
    private MoveCommand moveCommand;
    private UndoManager undoManager;

    public MoveButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
        super("Move");
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
        this.undoManager = undoManager;
        mouseHandler = new MouseHandler();
    }

    public void actionPerformed(ActionEvent event) {
        moveCommand = new MoveCommand();
        drawingPanel.addMouseListener(mouseHandler);
    }

    private class MouseHandler extends MouseAdapter {
        private int pointCount = 0;
        public void mouseClicked(MouseEvent event) {
            if(++pointCount == 1) {
                undoManager.beginCommand(moveCommand);
                moveCommand.setItemPoint(View.mapPoint(event.getPoint()));
            }
            else if (pointCount == 2) {
                pointCount = 0;
                System.out.println(View.mapPoint(event.getPoint()));
                moveCommand.moveItemTo(View.mapPoint(event.getPoint()));
                drawingPanel.removeMouseListener(this);undoManager.endCommand(moveCommand);
            }
        }
    }
}