import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RotateButton extends JButton implements ActionListener {
    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;
    private RotateCommand rotateCommand;
    private UndoManager undoManager;

    public RotateButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
        super("Rotate");
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
        this.undoManager = undoManager;
        mouseHandler = new MouseHandler();
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println("Clicked");
        rotateCommand = new RotateCommand();
        drawingPanel.addMouseListener(mouseHandler);
    }

    private class MouseHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            undoManager.beginCommand(rotateCommand);
            rotateCommand.selectItem(View.mapPoint(event.getPoint()));
            rotateCommand.rotateItem(View.mapPoint(event.getPoint()));
            drawingPanel.removeMouseListener(this);
            undoManager.endCommand(rotateCommand);
        }
    }
}