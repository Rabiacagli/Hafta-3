# Minesweeper Game 💣

Welcome to the MineSweeper Game! This is a simple console-based implementation of the classic Minesweeper game in Java.

##  How to Play  🎮

1. Run the `MineSweeper.run()` method.
2. Enter the number of rows and columns for the game board.
3. Select a row and column to make a move.
4. Try to reveal all the safe points without hitting a mine.

##  Code Overview 🚧

The Java code (`MineSweeper.java`) contains the implementation of the Minesweeper game. Here's a brief overview⬇️

**Constructor Method's Name :** MineSweeper

**'createBoard' :** We provide user input with Scanner class for matrix dimensions.

If the number of rows and columns entered is less than 2, we warn.

**Random Class and Conditions :**


1. The number of mines is determined, one quarter of the number of elements of the array is placed.
2. The Random class is called to place mines randomly.
3. The for loop allows a certain number of mines to be placed.
4. The do-while loop randomly selects a row and column.
5. And if there is already a mine in the selected cell, this process is repeated.

**'showBoard' :**

1. A method is created that shows the board to the user.
2. Loops are used to check each point of the board
3. If the selected coordinate has been opened before, a warning is given.
4. If there is a mine in the opened coordinate, '*' character is printed,
5. If the coordinate has not been opened before, the character '-' is printed.

**'makeMove' :**

1. The method that starts the game is created.
2. If the selected coordinate is already selected, the user is warned and allowed to continue the game.
3. If there are mines at the selected point, the game is lost.
4. If there are no mines at the selected point, the board is updated.
5. the game is won if all the correct points are opened.


**'countMines' :** A method is created to find the number of mines around a cell, and nested loops are used for this.

**'run' :** Methods and loops are executed, such as the user entering data, making moves,

it shows the board as long as the game continues.

**'showMineBoard' :** Whether the game is won or lost at the end, the mined board is shown to the user.


##  Running the Game 🚀

To play the game, simply run the `MineSweeper.run()` method in your Java environment.

Enjoy playing Minesweeper!



-------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------








