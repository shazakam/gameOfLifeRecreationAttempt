import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class PixelPanel extends JPanel {

        private static final long serialVersionUID = 8465814529701152253L;

        private static final int PIXEL_SIZE = 20;

        private Color backgroundColor;

        public PixelPanel() {
            this.backgroundColor = Color.WHITE;
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            this.setPreferredSize(new Dimension(PIXEL_SIZE, PIXEL_SIZE));
        }

        public Color getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(getBackgroundColor());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
