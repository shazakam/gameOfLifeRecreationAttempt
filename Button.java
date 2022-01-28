
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


        return numberOfSurroundingBlueBlocks;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub
        //PixelPanel[][] pixelPanelArray = arrayGetter();

        //Create method to find panels which are blue
        int rows = pixelPanelArray.length;
        int cols = pixelPanelArray[0].length;
    
        for(int i = 0;i < rows;i++){
            for(int k = 0;k < cols;k++){
                int numberOfSurroundingBlueBlocks = 0;

                //If the pixel colour is blue
                if(pixelPanelArray[i][k].getBackgroundColor().equals(Color.BLUE)){
                    //is the pixel on the edge or not?
                    if(!((i == 0) || i == rows-1 || k == 0 || k == cols-1)){

                        numberOfSurroundingBlueBlocks = countSurroundingBlueBlocks(i, k);
                        

                        //Check conditions for pixel for all surrounding blocks

                        if(numberOfSurroundingBlueBlocks == 2 || numberOfSurroundingBlueBlocks == 3){
                            continue;
                        }

                        else{
                            pixelPanelArray[i][k].setBackgroundColor(Color.WHITE);
                            pixelPanelArray[i][k].repaint();
                        }

                    }
                }

                else{

                    if(!((i == 0) || i == rows-1 || k == 0 || k == cols-1)){

                        numberOfSurroundingBlueBlocks = countSurroundingBlueBlocks(i, k);

                        if(numberOfSurroundingBlueBlocks == 3){
                            pixelPanelArray[i][k].setBackgroundColor(Color.BLUE);
                            pixelPanelArray[i][k].repaint();
                        }
                        else{
                            continue;
                        }

                    }

                }
            }
        }
        //Check whether they die or continue living or whether any adjacent blocks turn blue

        //Change colour based on result
        
        
    }

}