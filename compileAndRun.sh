rm -rf bin
mkdir bin
javac -d bin src/tictactoe/*.java
java -classpath bin tictactoe.TicTacToeAF
