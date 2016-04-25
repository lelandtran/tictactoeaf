#TicTacToeAF#

##Setup##
Using bash, compile and run the code with the command ```./compileAndRun.sh```.  
Otherwise, copy and paste both lines in the ```compileAndRun.sh``` file to the command line.  
These commands will compile the ```.java``` files under the ```src/tictactoe``` directory and place the ```.class``` files in a directory called ```bin```.  

##Gameplay##
You will be asked to specify whether players 1 and 2 are humans or computers.  
Player 1 will be x's and Player 2 will be o's.  
Humans will be asked to enter a move. Choose a box by denoting a row and column number,  
i.e. enter ```<row> <column>``` when prompted for a move.  
Computers will automatically choose a move.  

###Row Column Map###
| Tic | Tac | Toe |
| --- |:---:| ---:|
| 0 0 | 0 1 | 0 2 |
| 1 0 | 1 1 | 1 2 |
| 2 0 | 2 1 | 2 2 |

##Extra stuff##
For added fun, you can edit the ```BOARD_SIZE``` static member constant to play tic tac toe on an NxN board.  
Class diagram included in the ```misc``` directory.  
