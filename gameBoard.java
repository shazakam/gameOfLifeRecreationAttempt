
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


public class gameBoard implements Runnable {
    static int width = 40;
    static int height = 20;
    public static PixelPanel[][] pixelPanelArray = new PixelPanel[height][width];
    private JFrame frame;

    public static void main(String[] args) {
        gameBoard game = new gameBoard();
        game.initGUI();

       
        //pixelPanelArray[4][7].setBackgroundColor(Color.BLUE);
        //pixelPanelArray[4][7].repaint();
    }

    @Override
    public void run() {
        initGUI();
    }

    public void initGUI() {
        frame = new JFrame("Pixel Art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(createPixels());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        JFrame buttonFrame = new JFrame("Start button");
        buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonFrame.add(createButtons());
        buttonFrame.setVisible(true);
        buttonFrame.setLocationRelativeTo(null);
        buttonFrame.pack();

    
    }

    private JPanel createButtons(){
        int width = 400;
        int height = 400;

        JPanel panel = new JPanel();
        Button startButton = new Button("Start");
        

        panel.add(startButton.theButton);

        return panel;
    }

    

    private JPanel createPixels() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(height, width, 0, 0));
        
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {

                PixelPanel pixelPanel = new PixelPanel();
                pixelPanel.addMouseListener(new ColorListener(pixelPanel));
                panel.add(pixelPanel);
                pixelPanelArray[row][column] = pixelPanel;
                
            }
        }

        return panel;
    }

}