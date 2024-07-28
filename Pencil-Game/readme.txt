A pencil game between me and my friends, where each person can take either 1,2 or 3 pencils at a time. The last person taking a pencil shall lose

It's easier to get a grasp of it with a line of 10 red-green pencils. In this example, we can be sure that if both players know the winning strategy, the first one will be the winner. Here is a game process:

||||||||||

The first player has an advantage and takes 1 pencil:

|||||||||

The second player has a disadvantage, so if the second player takes any number of pencils from 1 to 3, the first player is left with a winning strategy:

1: ||||||||

2: |||||||

3: ||||||

The first player stands in a winning position and takes that number. It will lead to a losing position for the second player:

|||||

The second player stands in a losing position — if the second player takes any number of pencils from 1 to 3, the first player will be left in a winning position:

1: ||||

2: |||

3: ||

The first player stands in a winning position and takes the right number of pencils. It leaves the second player with one pencil:

|

Here, I programmed a bot that follows a winning strategy. If the bot's position isn't the winning one, I took any number of pencils (1, 2, or 3) at random. 

Tthe logic of the bot is like this:

If the bot is in a losing position, the outcome of the game does not depend on his action, so if the number of pencils on the table in his turn is:

5,9,13,17... - bot takes a random number of pencils from 1 to 3

1 - bot takes the last pencil and loses

If the bot is in a winning position, his goal is to take as many pencils to put his opponent in a losing position, so if the number of pencils on the table in his turn:

4,8,12,16... - bot takes 3 pencils

3,7,11,15... - bot takes 2 pencils

2,6,10,14... - bot takes 1 pencil
