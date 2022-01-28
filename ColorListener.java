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

        if (event.getButton() == MouseEvent.BUTTON1) {
            panel.setBackgroundColor(Color.BLUE);
            
            panel.repaint();
        } else if (event.getButton() == MouseEvent.BUTTON3) {
            panel.setBackgroundColor(Color.WHITE);
            panel.repaint();
        } 
    }
}
