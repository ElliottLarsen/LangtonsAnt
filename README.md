# Langton's Ant
This is a Langton's Ant simulation, which is a two-dimensional universal Turing machine invented by Chris Langton in 1986.

## Technologies
* Java

## GIF Walkthrough

<p>
<image src = "LangtonsAnt.gif" title = "Langton's Ant GIF" height = 900 width = 549>
</p>

## Project Details
* When the program first starts, it will prompt the user to enter the following information:
    * A number for the size of the square board.
    * Starting row and column numbers for the ant.  Row 0 is the first row from the top and column 0 is the first column from the left.
    * The initial orientation of the ant.  0 is up, 1 is right, 2 is down, and 3 is left.
    * Number of steps the ant will take.

* Board:
    * This 2D matrix is initialized with `-`.
    * As the ant moves across the board, it will change `-` to `*`.

* Ant:
    * Ant is represented by `A`.
    * If the ant is on a cell that has `-`, it will turn right 90 degrees relative to its current orientation, change the current cell to `*`, and move forward one step.
    * If the ant is on a cell that has `*`, it will turn left 90 degrees relative to its current orientation, change the current cell back to `-`, and move forward one step.
    * If the ant gets to the edge of the board, it will wrap and go to the other side of the board.

More comprehensive explanation of Langton's Ant can be found [HERE](https://en.wikipedia.org/wiki/Langton%27s_ant).

## Contact
Elliott Larsen
* Email elliottlrsn@gmail.com
* GitHub [@elliottlarsen](https://github.com/elliottlarsen)
* LinkedIn [@elliottlarsen](https://www.linkedin.com/in/elliottlarsen)