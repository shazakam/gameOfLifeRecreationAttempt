
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class Button implements ActionListener{
    boolean play = false;
    PixelPanel[][] pixelPanelArray = arrayGetter();
    JButton theButton;

    Button(String name){
        this.theButton = new JButton(name);
        this.theButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub

            fill_copyArray();
            paint();  
        
    }

    public PixelPanel[][] arrayGetter(){
        return gameBoard.pixelPanelArray;
    }

    public int countSurroundingBlueBlocks(int i, int k){
        int numberOfSurroundingBlueBlocks = 0;
        if(pixelPanelArray[i-1][k].getBackgroundColor().equals(Color.BLUE)){
            numberOfSurroundingBlueBlocks++;
        }

        if(pixelPanelArray[i+1][k].getBackgroundColor().equals(Color.BLUE)){
            numberOfSurroundingBlueBlocks++;
        }

        if(pixelPanelArray[i][k-1].getBackgroundColor().equals(Color.BLUE)){
            numberOfSurroundingBlueBlocks++;
        }

        if(pixelPanelArray[i][k+1].getBackgroundColor().equals(Color.BLUE)){
            numberOfSurroundingBlueBlocks++;
        }

        if(pixelPanelArray[i-1][k+1].getBackgroundColor().equals(Color.BLUE)){
            numberOfSurroundingBlueBlocks++;
        }

        if(pixelPanelArray[i+1][k+1].getBackgroundColor().equals(Color.BLUE)){
            numberOfSurroundingBlueBlocks++;
        }

        if(pixelPanelArray[i-1][k-1].getBackgroundColor().equals(Color.BLUE)){
            numberOfSurroundingBlueBlocks++;
        }

        if(pixelPanelArray[i+1][k-1].getBackgroundColor().equals(Color.BLUE)){
            numberOfSurroundingBlueBlocks++;
        }

        return numberOfSurroundingBlueBlocks;
    }

    public void fill_copyArray(){
        int rows = pixelPanelArray.length;
        int cols = pixelPanelArray[0].length;
    
        for(int i = 0;i < rows;i++){
            for(int k = 0;k < cols;k++){

                int numberOfSurroundingBlueBlocks = 0;
                int row_position = pixelPanelArray[i][k].row_position;
                int col_position = pixelPanelArray[i][k].col_position;


                if(!((i == 0) || i == rows-1 || k == 0 || k == cols-1)){

                    if(pixelPanelArray[i][k].getBackgroundColor().equals(Color.BLUE)){
                        
                        numberOfSurroundingBlueBlocks = countSurroundingBlueBlocks(i, k);
                            
                        //If block needs to die, input zero in correct panel position in pixelPanelArrayCopy
                        if(!(numberOfSurroundingBlueBlocks == 2 || numberOfSurroundingBlueBlocks == 3)){
                            gameBoard.pixelPanelArrayCopy[row_position][col_position] = 0;
                        }
                        else{
                            gameBoard.pixelPanelArrayCopy[row_position][col_position] = 1;
                        }
                        
                    }
    
                    else{

                        numberOfSurroundingBlueBlocks = countSurroundingBlueBlocks(i, k);
    
                        if(numberOfSurroundingBlueBlocks == 3){
                            gameBoard.pixelPanelArrayCopy[row_position][col_position] = 1;
                        }
                        
                    }


                }
               
            }
        }

    }

    public void paint(){
        int[][] pixelPanelArrayCopy = gameBoard.pixelPanelArrayCopy;
        for(int row = 0;row < pixelPanelArrayCopy.length-1;row++){
            for(int col = 0;col < pixelPanelArrayCopy[0].length;col++){

                if((pixelPanelArray[row][col].getBackgroundColor().equals(Color.BLUE) && pixelPanelArrayCopy[row][col] == 1)
                ||(pixelPanelArray[row][col].getBackgroundColor().equals(Color.WHITE) && pixelPanelArrayCopy[row][col] == 0)){
                    continue;
                }
                else{
                    if(pixelPanelArray[row][col].getBackgroundColor().equals(Color.BLUE) && pixelPanelArrayCopy[row][col] == 0){
                        pixelPanelArray[row][col].setBackgroundColor(Color.WHITE);
                        pixelPanelArray[row][col].repaint();
                    }

                    else if(pixelPanelArray[row][col].getBackgroundColor().equals(Color.WHITE) && pixelPanelArrayCopy[row][col] == 1){
                        pixelPanelArray[row][col].setBackgroundColor(Color.BLUE);
                        pixelPanelArray[row][col].repaint();
                    }
                }
            }
        }
    }
}