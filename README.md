Bee
You will be given an integer n for the size of the bee territory with square shape. On the next n lines, you will receive the rows of the territory. The bee will be placed on a random position, marked with the letter 'B'. On random positions there will be flowers, marked with 'f'. There may also be а bonus on the territory. There will always be only one bonus. It will be marked with the letter - 'O'. All of the empty positions will be marked with '.'.
Each turn, you will be given command for the bee’s movement.
The commands will be: "up", "down", "left", "right", "End".
If the bee moves to a flower, it pollinates the flower and increase pollinated flowers with one.
If it goes to a bonus, the bee gets a bonus one move forward and then the bonus disappears. If the bee goes out she can't return back and the program ends. If the bee receive "End" command the program ends. The bee needs at least 5 pollinated flowers.
Input
On the first line, you are given the integer n – the size of the square matrix.
The next n lines holds the values for every row.
On each of the next lines until you receive "End" command,  you will receive a move command.
Output
On the first line:
If the bee goes out of its territory print: "The bee got lost!"
On the second line:
 If the bee couldn’t pollinated enough flowers print: "The bee couldn't pollinate the flowers, she needed {needed} flowers more"
If the bee successfully pollinated enough flowers print: "Great job, the bee manage to pollinate {polinationed flowers} flowers!"
In the end print the matrix.
Constraints
The size of the square matrix will be between [2…10].
There will always be 0 or 1 bonus, marked with - 'O'.
The bee position will be marked with 'B'.
There won't be a case where a bonus moves the bee out of its territory.

Examples
Input	Output	Comments
5
Bff..
..O..
f.f.f
.....
fffff
right
right
down
left
left
down
down
right
down	The bee got lost!
Great job, the bee manage to pollinate 6 flowers!
.....
.....
....f
.....
..fff	1) right     2) right     3) down     5) left
   .Bf..        ..B..        .....       .....
   ..O..        ..O..        .....       .....
   f.f.f        f.f.f        f.B.f       fB..f  
   .....        .....        .....       .....
   fffff        fffff        fffff       fffff
…
2) pollinate a flower: 'f' (0, 1)
3) step on a bonus: 'O' (1, 2) and make one more step down to: 'f' (2, 2)
4) the bee is on (4, 1), the next command she receive is down and she goes out of the field and the program ends.
4
....
.O..
ff..
f.B.
left
left
up
right
up
End	The bee couldn't pollinate the flowers, she needed 2 flowers more
.B..
....
....
....	
