import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ColorListener extends MouseAdapter {

    private PixelPanel panel;

    public ColorListener(PixelPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        int row_position = panel.row_position;
        int col_position = panel.col_position;

        if (event.getButton() == MouseEvent.BUTTON1) {
            panel.setBackgroundColor(Color.BLUE);
            gameBoard.pixelPanelArrayCopy[row_position][col_position] = 1;
            panel.repaint();
        } 
        else if (event.getButton() == MouseEvent.BUTTON3) {
            panel.setBackgroundColor(Color.WHITE);
            gameBoard.pixelPanelArrayCopy[row_position][col_position] = 0;
            panel.repaint();
        } 
    }
}
