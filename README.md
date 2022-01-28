# gameOfLifeRecreationAttempt
This is my attempt at creating my own version of the Game of Life.
The program works as follows when run:
A grid appears on which the player may click on tiles to colour them blue
Alongside the grid, a start button also appears which when pressed goes through one iteration of the game.
The player may then choose to either continue pressing start to see where the iteration goes or to add more blocks.

This is still very much a work in progress. 
Currently, there is a major flaw in the manner in which the program decides whether a block lives or dies.
The problem being that it does not do it simultaneously and instead checks each block one by one and thus, doesn't accuratley represent the actual game.
The solution which I plan implementing is instead of going through the grid array and checking one by one, is to create a recursive function which is triggered when a blue block is found. The Pseudocode would be as follows-ish:

    Iterate through the grid array:
      if a blue block is found:
        Call the recursive function with the blue block as input with array position
      
      Recursive function:
      if block is blue:
        check conditions for continued life or deletion and save answer in a variable
        Then call function on surrounding blocks
          else:
            check conditions for creation of life
          if condition does not pass:
            return
        
      else:
        save result in a variable
        call function on surrounding blocks
        
        
I have no idea if this will work but this is what I have come up with and hope to implement soon.
      

